package org.wendu.dye.common;

import java.util.*;

public class CommonUtils {

        private static String getYearMonth(Calendar cal){
            int baseZeroMonth = cal.get(Calendar.MONTH);
            return cal.get(Calendar.YEAR) + "-" +
                    (baseZeroMonth<9?("0"+(baseZeroMonth+1)):String.valueOf(baseZeroMonth+1));
        }

        public static Map<String,Object> getYearMonthList(){

            Map<String,Object> yearMonthMap = new HashMap<>();

            Calendar cal = Calendar.getInstance();

            //本月
            yearMonthMap.put("currentYearMonth",getYearMonth(cal));

            //下一月
            cal.add(Calendar.MONTH, 1);
            yearMonthMap.put("nextYearMonth",getYearMonth(cal));

            List<String> list = new ArrayList<>();
            cal.add(Calendar.MONTH, -13);
            for(int i=0;i<25;i++){
                list.add(getYearMonth(cal));
                cal.add(Calendar.MONTH,1);
            }
            yearMonthMap.put("list", list);

            return yearMonthMap;
        }
}
