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
}
