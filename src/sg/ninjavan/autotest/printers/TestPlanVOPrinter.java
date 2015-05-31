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
        printCoverPage();
        int i =0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();
            }
        }
        logger.info("start() int="+i+" size="+size);
        while(i<size){
            // Setting the first page as the cover page
            // so we need to add 1
            testCaseVOPrinter.print(testPlanVO.getTestCaseVOs().get(i),excelWriter,i+1);
            i++;
        }
    }

    private void printCoverPage(){
        excelWriter.createSheet("Cover",0);
        excelWriter.writeCell(0,0,0,"TC");
        excelWriter.writeCell(0,1,0,"Description");
        excelWriter.writeCell(0,2,0,"Total Steps");
        excelWriter.writeCell(0,3,0,"Total Pass");
        excelWriter.writeCell(0,4,0,"Pass");

        int i =0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();

            }
        }
        logger.info("printCoverPage() int="+i+" size="+size);
        while(i<size){
            printCoverPageItems(testPlanVO.getTestCaseVOs().get(i),i);
            i++;
        }
    }

    private void printCoverPageItems(TestCaseVO testCaseVO,int row){
        excelWriter.writeCell(0,0,row+1,Integer.toString(row));
        excelWriter.writeCell(0,1,row+1,testCaseVO.getDescription());
        excelWriter.writeCell(0,2,row+1,Integer.toString(testCaseVO.getTotal_steps()));
        excelWriter.writeCell(0,3,row+1,Integer.toString(testCaseVO.getTotal_steps_passed()));
        if(testCaseVO.isPassed()){
            excelWriter.writeCell(0,4,row+1,"Y");
        }else{
            excelWriter.writeCell(0,4,row+1,"N");
        }
    }

    public void close(){
        excelWriter.close();
    }
}
