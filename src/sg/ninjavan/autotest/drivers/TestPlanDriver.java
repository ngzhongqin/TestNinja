package sg.ninjavan.autotest.drivers;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.TestCaseVO;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.framework.util.Browser;

/**
 * Created by zhongqinng on 31/5/15.
 */
public class TestPlanDriver {
    private Logger logger = Logger.getLogger(TestPlanDriver.class);
    private TestPlanVO testPlanVO;
    private Browser browser;

    public TestPlanDriver(TestPlanVO testPlanVO){
        logger.info("TestPlanDriver Created");
        this.testPlanVO=testPlanVO;
        this.browser= new Browser();
    }

    public TestPlanVO start(){
        logger.info("start()");
        testPlanVO.setTime_started(System.currentTimeMillis());
        int i=0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();
            }
        }

        while (i<size){
            TestCaseVO testCaseVO = testPlanVO.getTestCaseVOs().get(i);
            TestCaseVODriver testCaseVODriver = new TestCaseVODriver();
            testCaseVODriver.start(browser,testCaseVO,i);
            i++;
        }
        testPlanVO.setTime_ended(System.currentTimeMillis());
        return testPlanVO;
    }

    public void close(){
        browser.closeBrowser();
    }
}
