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
        testPlanVO.setTotal_test_case(getTotalTestCase());
        testPlanVO.setTotal_passed(getTotalTestCasePassed());
        return testPlanVO;
    }

    public void close(){
        browser.closeBrowser();
    }

    private int getTotalTestCase(){
        int i=0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();
            }
        }

        return size;
    }

    private int getTotalTestCasePassed(){
        int i=0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();
            }
        }
        int passed =0;

        while(i<size){
            if(testPlanVO.getTestCaseVOs().get(i).isPassed()){
                passed++;
            }
            i++;
        }

        return passed;
    }
}
