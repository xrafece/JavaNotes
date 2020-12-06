# 易班API使用笔记

## 易班`YBOpenApi.jar`使用

### maven -> pom.xml 添加依赖

```xml
<dependencies>
    <dependency>
        <groupId>cn.yiban</groupId>
        <artifactId>openapi</artifactId>
        <scope>system</scope>
        <version>1.0</version>
        <systemPath>${project.basedir}/YBOpenApi.jar</systemPath>
    </dependency>
</dependencies>

<build>
    <resources>
        <resource>
            <directory>${project.basedir}</directory>
            <targetPath>BOOT-INF/lib</targetPath>
            <includes>
                <include>*.jar</include>
            </includes>
        </resource>
    </resources>
</build>

```

### 使用

获取授权

```java
// 获取易班授权对象
Authorize authorize = new Authorize(Constant.YIBAN_APP_ID, Constant.YIBAN_APP_SECRET);
// 获取回调地址（或站内应用地址）
String url = authorize.forwardurl(Constant.YIBAN_APP_REDIRECT_URI, new Date().toString(), Authorize.DISPLAY_TAG_T.MOBILE);
// 重定向至应用主页
httpServletResponse.sendRedirect(url);
```

使用授权后应用信息

```java
// 获取应用数据（站内应用）
FrameUtil frameUtil = new FrameUtil(request, response, Constant.YIBAN_APP_ID, Constant.YIBAN_APP_SECRET, Constant.YIBAN_APP_REDIRECT_URI);
// 伪代码，但必须执行以下方法，此方法判断是否授权并解析数据
frameUtil.perform()
// 获取解析后的接口数据
String userId = frameUtil.getUserId();
String username = frameUtil.getUserName();
String accessToken = frameUtil.getAccessToken();
// 获取用户本人数据
// import cn.yiban.open.common.User;
User user = new User(accessToken);
// 数据格式为 json 需要进行解析
JSONObject json = JSONObject.fromObject(user.me());
JSONObject info = json.getJSONObject("info");
System.out.println(info);
System.out.println(info.getString("yb_username"));
System.out.println(info.getString("yb_userhead"));
```
