package sg.ninjavan.autotest.setters;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.TestCaseVO;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.framework.util.excel.ExcelReader;

import java.util.ArrayList;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class TestPlanVOSetter {
    private Logger logger = Logger.getLogger(TestPlanVOSetter.class);
    private ExcelReader excelReader;
    private int number_of_testcases;

    public TestPlanVOSetter(){
        excelReader=new ExcelReader();
        number_of_testcases = -1;
        if(excelReader!=null){
            number_of_testcases = excelReader.getNumberOfAvailableSheets();
        }
        logger.info("number_of_testcases: "+number_of_testcases);
    }

    public TestPlanVO getTestPlan(){
        logger.info("getTestPlan: Starts");
        TestPlanVO returnTestPlanVO = new TestPlanVO();
        ArrayList<TestCaseVO> testCaseVOArrayList = new ArrayList<TestCaseVO>();
        TestCaseVOSetter testCaseVOSetter = new TestCaseVOSetter();
        int i = 1;
        while(i < number_of_testcases+1){
            TestCaseVO testCaseVO = testCaseVOSetter.getTestCaseVO(i);
            testCaseVOArrayList.add(testCaseVO);
            i++;
        }
        returnTestPlanVO.setTestCaseVOs(testCaseVOArrayList);
        return returnTestPlanVO;
    }
}
