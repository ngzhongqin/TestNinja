package sg.ninjavan.autotest.printers;

import org.apache.log4j.Logger;
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
//        int i =0;
//        int size = -1;
//        if(testPlanVO!=null){
//            if(testPlanVO.getTestCaseVOs()!=null){
//                size = testPlanVO.getTestCaseVOs().size();
//            }
//        }
//        logger.info("start() int="+i+" size="+size);
//        while(i<size){
//            createSheet(Integer.toString(i),i);
//            i++;
//        }

        createSheet("0",0);
        ActionVOPrinter actionVOPrinter = new ActionVOPrinter();
        actionVOPrinter.printColumnName(0,excelWriter);
        actionVOPrinter.print(testPlanVO.getTestCaseVOs().get(0).getActionVOs().get(0),0,1,excelWriter);
        actionVOPrinter.print(testPlanVO.getTestCaseVOs().get(0).getActionVOs().get(1),0,2,excelWriter);
    }

    private void createSheet(String sheetName,int index){
        excelWriter.createSheet(sheetName,index);
    }

    public void close(){
        excelWriter.close();
    }
}
