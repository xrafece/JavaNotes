package com.xrafece.util;

import com.xrafece.entity.Period;

import java.util.Date;
import java.util.List;

/**
 * @author Xrafece
 */
public class TimeUtils {
    /**
     * 根据已有记录刷新可用时间段列表
     *
     * @param availedPeriod
     * @param recordPeriods
     * @return
     */
    public static List<Period> refreshAvaliedPeriods(List<Period> availedPeriod, List<Period> recordPeriods) {

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
}
