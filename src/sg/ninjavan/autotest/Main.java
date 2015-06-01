package sg.ninjavan.autotest;

import org.apache.log4j.*;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.printers.excel.TestPlanVOPrinter;
import sg.ninjavan.autotest.setters.TestPlanVOSetter;
import sg.ninjavan.autotest.framework.util.excel.ExcelReader;
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
        TestPlanVO result_test_plan = testPlanDriver.start();
        testPlanDriver.close();

        //Print the results into the excel sheet.
        TestPlanVOPrinter testPlanVOPrinter = new TestPlanVOPrinter(result_test_plan);
        testPlanVOPrinter.start();
        testPlanVOPrinter.close();


        logger.info("End of AutoTest");
        System.exit(0);
    }
}
