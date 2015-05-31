package sg.ninjavan.autotest.printers;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.TestCaseVO;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.framework.util.ExcelWriter;

/**
 * Created by zhongqinng on 31/5/15.
 * This class prints the result set of a TestPlan into excel sheet using the class ExcelWriter
 */
public class TestPlanVOPrinter {
    public static Logger logger = Logger.getLogger(TestPlanVOPrinter.class);
    private ExcelWriter excelWriter;
    private TestPlanVO testPlanVO;

    public TestPlanVOPrinter(TestPlanVO testPlanVO){
        this.testPlanVO=testPlanVO;
        excelWriter = new ExcelWriter();
    }

    public void start() {
        logger.info("start()");
        TestCaseVOPrinter testCaseVOPrinter = new TestCaseVOPrinter();
        int i =0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();
            }
        }
        logger.info("start() int="+i+" size="+size);
        while(i<size){
            testCaseVOPrinter.print(testPlanVO.getTestCaseVOs().get(i),excelWriter,i);
            i++;
        }
    }



    public void close(){
        excelWriter.close();
    }
}
