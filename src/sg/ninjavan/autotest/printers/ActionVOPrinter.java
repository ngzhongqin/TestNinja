package sg.ninjavan.autotest.printers;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.ExcelWriter;

/**
 * Created by zhongqinng on 31/5/15.
 * Prints results of ActionVO into excel
 */
public class ActionVOPrinter {
    public static Logger logger = Logger.getLogger(ActionVOPrinter.class);

    public ActionVOPrinter(){
    }

    public void print(ActionVO actionVO, int sheet_num, int row, ExcelWriter excelWriter){
        logger.info("print() actionVO Description="+actionVO.getDescription());
        excelWriter.writeCell(sheet_num,0,row,actionVO.getSn());
        excelWriter.writeCell(sheet_num,1,row,actionVO.getAction().toString());
        excelWriter.writeCell(sheet_num,2,row,actionVO.getxPath());
        excelWriter.writeCell(sheet_num,3,row,actionVO.getInput());
        excelWriter.writeCell(sheet_num,4,row,actionVO.getDescription());
        if(actionVO.isScreenshot_needed()) {
            excelWriter.writeCell(sheet_num, 5, row, "Y");
        }
        else{
            excelWriter.writeCell(sheet_num, 5, row, "N");
        }
        excelWriter.writeCell(sheet_num,6,row,actionVO.getExpectedValue());
        excelWriter.writeCell(sheet_num,7,row,actionVO.getActualValue());
        if(actionVO.isPass_fail()) {
            excelWriter.writeCell(sheet_num, 8, row, "Y");
        }
        else{
            excelWriter.writeCell(sheet_num, 8, row, "N");
        }

    }


}
