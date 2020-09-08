package common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static String nowF(Date date,String format){
        SimpleDateFormat df=new SimpleDateFormat(format);
        return df.format(date);
    }

    public static String now(){
        return nowF(new Date(),"yyyy-MM-dd HH:mm:ss");
    }
}
