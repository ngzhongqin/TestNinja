package sg.ninjavan.autotest.framework.VOSetter;

import sg.ninjavan.autotest.Main;
import sg.ninjavan.autotest.framework.util.ExcelReader;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class TestPlanVOSetter {
    private ExcelReader excelReader;
    private int number_of_testcases;

    public TestPlanVOSetter(){
        excelReader=new ExcelReader();
        number_of_testcases = -1;
        if(excelReader!=null){
            number_of_testcases = excelReader.getNumberOfAvailableSheets();
        }
        Main.logger.info("number_of_testcases: "+number_of_testcases);
    }
}
