package sg.ninjavan.autotest.framework.VOSetter;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.VO.TestCaseVO;
import sg.ninjavan.autotest.framework.util.ExcelReader;

import java.util.ArrayList;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class TestCaseVOSetter {
    private Logger logger = Logger.getLogger(TestCaseVOSetter.class);
    private ExcelReader excelReader;

    public TestCaseVOSetter(){
    }

    public TestCaseVO getTestCaseVO(int sheet_num){
        logger.info("getTestCaseVO Starts: sheet_num = "+sheet_num);
        TestCaseVO returnTestCaseVO = null;
        excelReader = new ExcelReader();
        ArrayList<ActionVO> actionVOs = getActionVOList(sheet_num);
        String description = excelReader.getTestCaseDescription(sheet_num);
        int total_steps = -1;
        if(actionVOs!=null){
            total_steps=actionVOs.size();
        }
        logger.info("sheet_num = "+sheet_num+ " description: "+description+" total_steps= "+total_steps);

        returnTestCaseVO = new TestCaseVO(description,actionVOs);
        returnTestCaseVO.setTotal_steps(total_steps);

        return returnTestCaseVO;
    }


    public ArrayList<ActionVO> getActionVOList(int sheet_num){
        ArrayList<ActionVO> returnArrayList = new ArrayList<ActionVO>();
        int row = 2;
        ActionVOSetter actionVOSetter = new ActionVOSetter();
        String checkString = excelReader.getCell(sheet_num, 0, row);
        while(checkString!=null){
            ActionVO actionVO = actionVOSetter.getActionVO(sheet_num,row);
            returnArrayList.add(actionVO);
            row++;
            checkString = excelReader.getCell(sheet_num,0,row);
        }
        return returnArrayList;
    };
}
