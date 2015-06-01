package sg.ninjavan.autotest.framework.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhongqinng on 31/5/15.
 */
public class DateHandler {
    public DateHandler(){

    }

    public String getDateString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmm");
        String string  = dateFormat.format(new Date());

        return string;
    }

    public String getDateStringFromLong(long time){
        Date d = new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
        String string  = dateFormat.format(d);
        return string;
    }

    public String getElapsedTime(long startTime, long endTime){

        //milliseconds
        long different = endTime - startTime;

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        String elapsedTime = elapsedDays+" days "+elapsedHours+" hours "+elapsedMinutes+" minutes "+elapsedSeconds+" seconds";

        return elapsedTime;

    }

}
