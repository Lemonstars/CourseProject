package util;

import java.util.Calendar;

/**
 * Created by starrylemon on 2017/3/13.
 */
public class MyDate {

    private static MyDate singleton;


    private MyDate(){}

    public static MyDate getInstance(){
        if (singleton==null){
            singleton=new MyDate();
        }
        return  singleton;
    }


    //得到今天的日期
    public String getTodayDate(){
        String result;
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int date = c.get(Calendar.DATE);
        result=year+"-"+month+"-"+date;

        return result;
    }

    //bootstrap的datepicker日期月份采用的是中文
    public String  convertDate(String date){
        String result;

        String[] split=date.split("\\s+");
        String month=split[1];
        String allMonth[]=new String[]{"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};
        String digitMonth[]=new String[]{"1","2","3","4","5","6","7","8","0","10","11","12"};
        String targetDigit=null;
        for(int i=0;i<12;i++){
            if(month.equals(allMonth[i])){
                targetDigit=digitMonth[i];
            }
        }

        result=split[0]+"-"+targetDigit+"-"+split[2];
        return result;
    }
}
