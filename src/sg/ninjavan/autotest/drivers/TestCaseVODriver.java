package sg.ninjavan.autotest.drivers;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.VO.TestCaseVO;
import sg.ninjavan.autotest.framework.util.Browser;

/**
 * Created by zhongqinng on 31/5/15.
 */
public class TestCaseVODriver {
    private final ActionVODriver actionVODriver;
    private Logger logger = Logger.getLogger(TestCaseVODriver.class);

    public TestCaseVODriver(){
        logger.info("TestCaseVODriver Created");
        this.actionVODriver = new ActionVODriver();
    }

    public TestCaseVO start(Browser browser,TestCaseVO testCaseVO, int testCaseIndex) {
        logger.info("start()");
        testCaseVO.setTime_started(System.currentTimeMillis());
        int i=0;
        int size = -1;
        if(testCaseVO!=null){
            if(testCaseVO.getActionVOs()!=null){
                size = testCaseVO.getActionVOs().size();
            }
        }
        logger.info("start() i="+i+" size="+size);

        while (i<size){
            actionVODriver.start(testCaseVO.getActionVOs().get(i),browser,testCaseIndex);
            i++;
        }

        testCaseVO = setTotalAndPassedSteps(testCaseVO);
        testCaseVO.setTime_ended(System.currentTimeMillis());
        return testCaseVO;
    }

    private TestCaseVO setTotalAndPassedSteps(TestCaseVO testCaseVO){
        int i=0;
        int passed =0;
        int size = -1;
        if(testCaseVO!=null){
            if(testCaseVO.getActionVOs()!=null){
                size = testCaseVO.getActionVOs().size();
            }
        }
        logger.info("setTotalAndPassedSteps() i="+i+" size="+size);

        while (i<size){
            ActionVO actionVO = testCaseVO.getActionVOs().get(i);
            if(actionVO.isPass_fail())
                passed++;
            i++;
        }

        testCaseVO.setTotal_steps(size);
        testCaseVO.setTotal_steps_passed(passed);

        return testCaseVO;

    }

}
