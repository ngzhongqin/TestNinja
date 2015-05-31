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
    private TestCaseVO testCaseVO;

    public TestCaseVODriver(TestCaseVO testCaseVO){
        logger.info("TestCaseVODriver Created");
        this.testCaseVO=testCaseVO;
        this.actionVODriver = new ActionVODriver();
    }

    public TestCaseVO start(Browser browser) {
        logger.info("start()");
        int i=0;
        int size = -1;
        if(testCaseVO!=null){
            if(testCaseVO.getActionVOs()!=null){
                size = testCaseVO.getActionVOs().size();
            }
        }
        logger.info("start() i="+i+" size="+size);

        while (i<size){
            ActionVO actionVO = testCaseVO.getActionVOs().get(i);
            actionVODriver.start(actionVO,browser);
            i++;
        }

        return testCaseVO;
    }

}
