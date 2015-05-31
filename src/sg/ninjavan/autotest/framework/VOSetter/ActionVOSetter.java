package sg.ninjavan.autotest.framework.VOSetter;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.ExcelReader;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class ActionVOSetter {
    private Logger logger = Logger.getLogger(ActionVOSetter.class);
    private ExcelReader excelReader;
    public ActionVOSetter(){
        excelReader = new ExcelReader();
    }

    public ActionVO getActionVO(int sheet_number, int row){
        String sn = excelReader.getCell(sheet_number, 0, row);
        String action = excelReader.getCell(sheet_number,1,row);
        String xPath = excelReader.getCell(sheet_number,2,row);
        String input = excelReader.getCell(sheet_number,3,row);
        String description = excelReader.getCell(sheet_number,4,row);
        String screenshot_needed = excelReader.getCell(sheet_number,5,row);
        String expectedValue = excelReader.getCell(sheet_number,6,row);

        ActionVO returnActionVO = new ActionVO(sn,action,xPath,input,description,screenshot_needed,expectedValue);
        return returnActionVO;
    }

}
