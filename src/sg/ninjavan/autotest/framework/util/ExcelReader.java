package sg.ninjavan.autotest.framework.util;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;
import sg.ninjavan.autotest.Main;


import java.io.File;
import java.io.IOException;

/**
 * Created by zhongqinng on 26/5/15.
 */
public class ExcelReader {
    public static Logger logger = Logger.getLogger(ExcelReader.class);
    private Workbook test_case_workbook;

    public ExcelReader(){
        try {
            test_case_workbook = Workbook.getWorkbook(new File("testScript/AutomatedTesting.xls"));
        } catch (IOException e) {
            Main.logger.error("IOException - "+e.getMessage());
        } catch (BiffException e) {
            logger.error("BiffException - "+e.getMessage());
        }catch (Exception e){
            logger.error("Exception - "+e.getMessage());
        }
    };




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

    public String getLog4JPath(){
        return getCell(0,2,3);
    }

    public String getTestCaseDescription(int sheet_num) {
        return getCell(sheet_num,1,0);
    }

    public int getNumberOfAvailableSheets(){
        int returnInt = -1;
        if(test_case_workbook!=null){
            returnInt = test_case_workbook.getNumberOfSheets() - 1;
        }
        return returnInt;
    }
}
