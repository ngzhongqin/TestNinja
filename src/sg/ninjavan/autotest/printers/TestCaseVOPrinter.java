package sg.ninjavan.autotest.printers;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.TestCaseVO;
import sg.ninjavan.autotest.framework.util.ExcelWriter;

/**
 * Created by zhongqinng on 31/5/15.
 */
public class TestCaseVOPrinter {
    private Logger logger = Logger.getLogger(TestCaseVOPrinter.class);

    public TestCaseVOPrinter(){
    }

    public void print(TestCaseVO testCaseVO,ExcelWriter excelWriter, int sheet_num){
        logger.info("print()");
        excelWriter.createSheet("TC_" + Integer.toString(sheet_num), sheet_num);
        ActionVOPrinter actionVOPrinter = new ActionVOPrinter();
        printTestCaseDescription(testCaseVO,sheet_num,excelWriter);
        printColumnName(sheet_num, excelWriter);
        int i = 0;
        int size = -1;
        if(testCaseVO!=null){
            if(testCaseVO.getActionVOs()!=null){
                size=testCaseVO.getActionVOs().size();
            }
        }
        logger.info("print() i="+i+" size="+size);

        while (i<size){
            actionVOPrinter.print(testCaseVO.getActionVOs().get(i),sheet_num,i+2,excelWriter);
            i++;
        }
    }

    private void printTestCaseDescription(TestCaseVO testCaseVO,int sheet_num,ExcelWriter excelWriter){
        logger.info("printTestCaseDescription()");
        excelWriter.writeCell(sheet_num, 0, 0, "Description");
        excelWriter.writeCell(sheet_num,1,0,testCaseVO.getDescription());
    }

    private void printColumnName(int sheet_num,ExcelWriter excelWriter){
        logger.info("printColumnName()");
        excelWriter.writeCell(sheet_num, 0, 1, "S/N");
        excelWriter.writeCell(sheet_num,1,1,"ActionType");
        excelWriter.writeCell(sheet_num,2,1,"xPath");
        excelWriter.writeCell(sheet_num,3,1,"Input");
        excelWriter.writeCell(sheet_num,4,1,"Description");
        excelWriter.writeCell(sheet_num, 5, 1, "Screenshot Needed");
        excelWriter.writeCell(sheet_num,6,1,"Expected Value");
        excelWriter.writeCell(sheet_num,7,1,"Actual Value");
        excelWriter.writeCell(sheet_num, 8, 1, "Passed");
    }

}
