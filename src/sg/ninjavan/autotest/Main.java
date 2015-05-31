package sg.ninjavan.autotest;

import org.apache.log4j.*;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.framework.VOSetter.TestPlanVOSetter;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("conf/log4j.properties");
        logger.info("Start of AutoTester");


        TestPlanVOSetter testPlanVOSetter = new TestPlanVOSetter();
        TestPlanVO testPlanVO = testPlanVOSetter.getTestPlan();

        logger.info("testPlanVO: "+testPlanVO);
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null)
                logger.info("testPlanVO.size: "+testPlanVO.getTestCaseVOs().size());
        }
    }
}
