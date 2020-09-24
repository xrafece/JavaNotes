package com.xrafece.service;

import com.xrafece.entity.Period;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Xrafece
 */
public class DateTest {
    public static void main(String[] args) {

        Time startTime1 = Time.valueOf("9:00:00");
        Time endTime1 = Time.valueOf("11:00:00");
        Time startTime2 = Time.valueOf("11:05:00");
        Time endTime2 = Time.valueOf("20:00:00");
        Period period1 = new Period(startTime1, endTime1);
        Period period2 = new Period(startTime2, endTime2);

        /*
        最大时间段 sql 获取被限制当前最大时间段

        业务逻辑： 通过日期拉起 本日所有记录，（0-10条，估算）
        0记录------拉起限制开始时间和结束时间，返回可使用时间段   period 实体列表
        若干记录-------拉起限制开始时间和结束时间，返回可用时间段 period 实体列表

        若干记录处理：
        拉取最大最大时间段，

         */

        // Map<String, Time> timeMap = new HashMap<>();
        List<Period> periods = new ArrayList<>();

        periods.add(period1);
        periods.add(period2);

        System.out.println("--------");
        try {
            List<Period> availedPeriod = new ArrayList<>();
            Time startTime = Time.valueOf("7:00:00");
            Time endTime = Time.valueOf("22:00:00");
            Period period = new Period(startTime, endTime);
            availedPeriod.add(period);

            List<Period> function = function(availedPeriod, periods);
            for (Period period9 : function) {
                System.out.println(period9);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("--------");
    }

    private static List<Period> function(List<Period> availedPeriod, List<Period> recordPeriods) {

        for (int i = 0; i < recordPeriods.size(); i++) {
            for (int j = 0; j < availedPeriod.size(); j++) {

                Date startTimeM = recordPeriods.get(i).getStartTime();
                Date endTimeN = recordPeriods.get(i).getEndTime();

                Date startTimeA = availedPeriod.get(j).getStartTime();
                Date endTimeB = availedPeriod.get(j).getEndTime();

                if (startTimeA.compareTo(startTimeM) <= 0 && endTimeB.compareTo(endTimeN) >= 0) {
                    if (startTimeA.compareTo(startTimeM) == 0) {
                        if (endTimeB.compareTo(endTimeN) == 0) {
                            availedPeriod.remove(j);
                        } else {
                            availedPeriod.remove(j);
                            availedPeriod.add(new Period(endTimeN, endTimeB));
                        }
                    } else {
                        if (endTimeN.compareTo(endTimeB) == 0) {
                            availedPeriod.remove(j);
                            availedPeriod.add(new Period(startTimeA, startTimeM));
                        } else {
                            availedPeriod.remove(i);
                            availedPeriod.add(new Period(startTimeA, startTimeM));
                            availedPeriod.add(new Period(endTimeN, endTimeB));
                        }
                    }
                }
            }
        }
        return availedPeriod;
    }

    /**
     * 错误实例
     *
     * @param availedPeriod
     * @param recordPeriods
     * @return
     */
    private static List<Period> function2(List<Period> availedPeriod, List<Period> recordPeriods) {

        for (int i = 0; i < recordPeriods.size(); i++) {
            for (int j = 0; j < availedPeriod.size(); j++) {

                if (availedPeriod.get(j).getStartTime().compareTo(recordPeriods.get(i).getStartTime()) <= 0 && availedPeriod.get(j).getEndTime().compareTo(recordPeriods.get(i).getEndTime()) >= 0) {
                    if (availedPeriod.get(j).getStartTime().compareTo(recordPeriods.get(i).getStartTime()) == 0) {
                        if (availedPeriod.get(j).getEndTime().compareTo(recordPeriods.get(i).getEndTime()) == 0) {
                            availedPeriod.remove(j);
                        } else {
                            availedPeriod.remove(j);
                            availedPeriod.add(new Period(recordPeriods.get(i).getEndTime(), availedPeriod.get(j).getEndTime()));
                        }
                    } else {
                        if (recordPeriods.get(i).getEndTime().compareTo(availedPeriod.get(j).getEndTime()) == 0) {
                            availedPeriod.remove(j);
                            availedPeriod.add(new Period(availedPeriod.get(j).getStartTime(), recordPeriods.get(i).getStartTime()));
                        } else {
                            availedPeriod.remove(i);
                            availedPeriod.add(new Period(availedPeriod.get(j).getStartTime(), recordPeriods.get(i).getStartTime()));
                            availedPeriod.add(new Period(recordPeriods.get(i).getEndTime(), availedPeriod.get(j).getEndTime()));
                        }
                    }
                }

            }
        }
        return availedPeriod;
    }
}

    // private static Map timeCalculate(Map<String, Time> timeMap) {
    //     if ((!timeMap.containsKey("startTime") && !timeMap.containsKey("endTime"))) {
    //         return timeMap;
    //     } else {
    //         if (timeMap.get("startTime").compareTo(Time.valueOf("7:00:00")) < 0) {
    //             return timeMap;
    //         } else if (timeMap.get("startTime").compareTo(Time.valueOf("22:00:00")) == 0) {
    //             Map<String, Time> timeListMap = new HashMap<>();
    //             timeListMap.put("startTime", Time.valueOf("7:00:00"));
    //             timeListMap.put("endTime", timeMap.get("startTime"));
    //             return timeListMap;
    //         } else if (timeMap.get("endTime").compareTo(Time.valueOf("22:00:00")) < 0) {
    //             return timeMap;
    //         } else if (timeMap.get("endTime").after(Time.valueOf("22:00:00"))) {
    //             return timeMap;
    //         } else {
    //             Map<String, Time> timeListMap = new HashMap<>();
    //             timeListMap.put("startTime1", Time.valueOf("7:00:00"));
    //             timeListMap.put("endTime1", timeMap.get("startTime"));
    //             timeListMap.put("startTime2", Time.valueOf("22:00:00"));
    //             timeListMap.put("endTime2", timeMap.get("endTime"));
    //
    //         }
    //     }
    // }

