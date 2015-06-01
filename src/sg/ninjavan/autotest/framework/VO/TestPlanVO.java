package sg.ninjavan.autotest.framework.VO;

import sg.ninjavan.autotest.framework.util.DateHandler;

import java.util.ArrayList;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class TestPlanVO {
    private ArrayList<TestCaseVO> testCaseVOs;
    private long time_started;
    private long time_ended;
    public TestPlanVO(){

    }

    public ArrayList<TestCaseVO> getTestCaseVOs() {
        return testCaseVOs;
    }

    public void setTestCaseVOs(ArrayList<TestCaseVO> testCaseVOs) {
        this.testCaseVOs = testCaseVOs;
    }

    public long getTime_started() {
        return time_started;
    }

    public void setTime_started(long time_started) {
        this.time_started = time_started;
    }

    public long getTime_ended() {
        return time_ended;
    }

    public void setTime_ended(long time_ended) {
        this.time_ended = time_ended;
    }

    public String getStartTime(){
        DateHandler dateHandler=new DateHandler();
        return dateHandler.getDateStringFromLong(this.getTime_started());
    }

    public String getEndTime(){
        DateHandler dateHandler=new DateHandler();
        return dateHandler.getDateStringFromLong(this.getTime_ended());
    }

    public String getElapsedTime(){
        DateHandler dateHandler = new DateHandler();
        return dateHandler.getElapsedTime(this.time_started,this.time_ended);
    }
}
