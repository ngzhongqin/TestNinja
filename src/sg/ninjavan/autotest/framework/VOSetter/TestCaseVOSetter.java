package sg.ninjavan.autotest.framework.VOSetter;

import sg.ninjavan.autotest.Main;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.ExcelReader;

import java.util.ArrayList;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class TestCaseVOSetter {
    private ExcelReader excelReader;

    public TestCaseVOSetter(int sheet_num){
        excelReader = new ExcelReader();
        ArrayList<ActionVO> actionVOs = excelReader.getActionVOList(sheet_num);
        String description = excelReader.getTestCaseDescription(sheet_num);
        int total_steps = -1;
        if(actionVOs!=null){
            total_steps=actionVOs.size();
        }
        Main.logger.info("sheet_num = "+sheet_num+ " description: "+description+" total_steps= "+total_steps);
    }
}
