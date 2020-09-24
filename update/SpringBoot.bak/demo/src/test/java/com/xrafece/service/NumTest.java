package com.xrafece.service;

import com.xrafece.entity.Num;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xrafece
 */
public class NumTest {
    @Test
    void name() throws Exception {
        List<Num> numList = new ArrayList<>();
        numList.add(new Num(2, 3));
        numList.add(new Num(9, 10));
        numList.add(new Num(3, 9));
        numList.add(new Num(1, 2));
        numList.add(new Num(0, 1));


        List<Num> resultList = new ArrayList<>();
        resultList.add(new Num(0, 10));

        List<Num> function = function2(resultList, numList);
        for (Num num : function) {
            System.out.println(num);
        }
        Num num = new Num(3, 9);
        if (legal(function, num)) {
            numList.add(num);
        }
    }

    /**
     * 新增检验
     *
     * @param function
     * @param args
     * @return
     */
    private boolean legal(List<Num> function, Num args) {
        boolean flag = false;
        for (int i = 0; i < function.size(); i++) {
            Integer x = function.get(i).getX();
            Integer y = function.get(i).getY();
            if (args.getX() >= x && args.getY() <= y) {
                flag = true;
            }
        }
        return flag;
    }


    /**
     * 错误写法
     *
     * @param resultList
     * @param numList
     * @return
     * @throws Exception
     */
    private List<Num> function(List<Num> resultList, List<Num> numList) throws Exception {
        // int size = resultList.size();
        for (int i = 0; i < resultList.size(); i++) {
            for (int j = 0; j < numList.size(); j++) {

                int a = resultList.get(i).getX();
                int b = resultList.get(i).getY();

                int m = numList.get(j).getX();
                int n = numList.get(j).getY();
                System.out.println(" " + a + " " + b + " " + m + " " + n);
                //  a <= m   b >= n
                if (m >= a && n <= b) {
                    if (m == a) {
                        if (n == b) {
                            resultList.remove(i);
                        } else {
                            resultList.remove(i);
                            resultList.add(new Num(n, b));
                        }
                    } else {
                        if (n == b) {
                            resultList.remove(i);
                            resultList.add(new Num(a, m));
                        } else {
                            resultList.remove(i);
                            resultList.add(new Num(a, m));
                            resultList.add(new Num(n, b));
                        }
                    }
                }
            }
        }
        return resultList;
    }


    private List<Num> function2(List<Num> resultList, List<Num> numList) {

        for (int i = 0; i < numList.size(); i++) {
            for (int j = 0; j < resultList.size(); j++) {

                int a = resultList.get(j).getX();
                int b = resultList.get(j).getY();

                int m = numList.get(i).getX();
                int n = numList.get(i).getY();
                System.out.println(" " + a + " " + b + " " + m + " " + n);
                //  a <= m   b >= n
                if (m >= a && n <= b) {
                    if (m == a) {
                        if (n == b) {
                            resultList.remove(j);
                        } else {
                            resultList.remove(j);
                            resultList.add(new Num(n, b));
                        }
                    } else {
                        if (n == b) {
                            resultList.remove(j);
                            resultList.add(new Num(a, m));
                        } else {
                            resultList.remove(j);
                            resultList.add(new Num(a, m));
                            resultList.add(new Num(n, b));
                        }
                    }
                }
            }
        }
        return resultList;
    }
}
                /*
                i
                 */
                /*
                m < a   n < b
                a < m   b < n
                m < a   b < n

0              10
   12 3    9
0 1 2 3 9 10

                a > m && a > n
                m < n < a < b
                a < b < m < n
                 */

