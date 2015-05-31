package sg.ninjavan.autotest;

import org.apache.log4j.*;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.setters.TestPlanVOSetter;
import sg.ninjavan.autotest.framework.util.ExcelReader;
import sg.ninjavan.autotest.drivers.TestPlanDriver;

public class Main {
    public static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        ExcelReader excelReader = new ExcelReader();
        PropertyConfigurator.configure(excelReader.getLog4JPath());
        logger.info("Start of AutoTester");

        //Get Test Plan
        TestPlanVOSetter testPlanVOSetter = new TestPlanVOSetter();
        TestPlanVO testPlanVO = testPlanVOSetter.getTestPlan();

        //Start of Test Plan
        TestPlanDriver testPlanDriver = new TestPlanDriver(testPlanVO);
        testPlanDriver.start();
        testPlanDriver.close();
    }
}
