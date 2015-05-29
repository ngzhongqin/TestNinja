package sg.ninjavan.autotest.framework.util;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import sg.ninjavan.autotest.Main;
import sg.ninjavan.autotest.framework.VO.ActionVO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by zhongqinng on 26/5/15.
 */
public class ExcelReader {
    private Workbook test_case_workbook;

    public ExcelReader(){
        try {
            test_case_workbook = Workbook.getWorkbook(new File("AutomatedTesting.xls"));
        } catch (IOException e) {
//            System.out.println("<Error>: IOException - "+e.getMessage());
            Main.logger.error("IOException - "+e.getMessage());
//            e.printStackTrace();
        } catch (BiffException e) {
//            System.out.println("<Error>: BiffException - "+e.getMessage());
            Main.logger.error("BiffException - "+e.getMessage());
//            e.printStackTrace();
        }catch (Exception e){
            Main.logger.error("Exception - "+e.getMessage());
        }
    };

    public ArrayList<ActionVO> getActionVOList(int sheet_num){
        ArrayList<ActionVO> returnArrayList = new ArrayList<ActionVO>();
        int row = 2;
        String checkString = getCell(sheet_num,0,row);
        while(checkString!=null){
            ActionVO actionVO = getActionVO(sheet_num,row);
            returnArrayList.add(actionVO);
            row++;
            checkString = getCell(sheet_num,0,row);
        }
        return returnArrayList;
    };

    private ActionVO getActionVO(int sheet_number, int row){
        String sn = getCell(sheet_number,0,row);
        String action = getCell(sheet_number,1,row);
        String xPath = getCell(sheet_number,2,row);
        String input = getCell(sheet_number,3,row);
        String description = getCell(sheet_number,4,row);
        String screenshot_needed = getCell(sheet_number,5,row);
        String expectedValue = getCell(sheet_number,6,row);

        ActionVO returnActionVO = new ActionVO(sn,action,xPath,input,description,screenshot_needed,expectedValue);
        return returnActionVO;
    }

    public String getCell(int sheet_number, int col, int row){
        String returnString = null;
        try {
            Sheet sheet = test_case_workbook.getSheet(sheet_number);
            Cell cell = sheet.getCell(col,row);
            returnString = cell.getContents();
        }catch (Exception e){
            System.out.println("<Error>: Exception - "+e.getMessage());
        }

        return returnString;
    }

    public void close_workbook(){
        try {
            test_case_workbook.close();
        }catch (Exception e){
            System.out.println("<Error>: Exception - "+e.getMessage());
        }
    }

    public String getChromeDriverPath(){
        return getCell(0,2,1);
    }

    public String getResultFolderPath(){
        return getCell(0,2,2);
    }

    public String getTestCaseDescription(int sheet_num) {
        return getCell(sheet_num,1,0);
    }

    public int getNumberOfAvailableSheets(){
        int returnInt = -1;
        if(test_case_workbook!=null){
            returnInt = test_case_workbook.getNumberOfSheets();
        }
        return returnInt;
    }
}
