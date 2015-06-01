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
    private int total_test_case;
    private int total_passed;
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

    public int getTotal_test_case() {
        return total_test_case;
    }

    public void setTotal_test_case(int total_test_case) {
        this.total_test_case = total_test_case;
    }

    public int getTotal_passed() {
        return total_passed;
    }

    public void setTotal_passed(int total_passed) {
        this.total_passed = total_passed;
    }

    public String getPercentagePassed(){
        String percentagePassed = "0 %";
        if(total_test_case!=0){
            double percentage = ((double) total_passed / (double) total_test_case) * 100;
            percentagePassed = Double.toString(percentage)+" %";
        }

        return percentagePassed;
    }
}
