package sg.ninjavan.autotest.framework.VO;

import java.util.ArrayList;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class TestPlanVO {
    private ArrayList<TestCaseVO> testCaseVOs;

    public TestPlanVO(){

    }

    public ArrayList<TestCaseVO> getTestCaseVOs() {
        return testCaseVOs;
    }

    public void setTestCaseVOs(ArrayList<TestCaseVO> testCaseVOs) {
        this.testCaseVOs = testCaseVOs;
    }
}
