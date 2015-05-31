package sg.ninjavan.autotest.framework.util;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhongqinng on 31/5/15.
 */
public class ExcelWriter {
    public static Logger logger = Logger.getLogger(ExcelWriter.class);
    private WritableWorkbook wworkbook;


    public ExcelWriter(){
        ExcelReader excelReader=new ExcelReader();
        DateHandler dateHandler = new DateHandler();
        {
            try {
                wworkbook = Workbook.createWorkbook(new File(excelReader.getResultFolderPath()+dateHandler.getDateString()+"_result.xls"));
            } catch (Exception e) {
                logger.error("Fail to create Workbook");
            }

        }
    }

    public void writeCell(int sheet_num,int col,int row,String content){
        logger.info("writeCell sheet_num=" + sheet_num + " col=" + col + " row=" + row + " content=" + content);
        WritableSheet writableSheet = wworkbook.getSheet(sheet_num);
        Label label = new Label(col,row,content);
        try {
            writableSheet.addCell(label);
        } catch (Exception e) {
            logger.error("writeCell sheet_num=" + sheet_num + " col=" + col+" row="+row+" content="+content);
        }
    }

    public void createSheet(String sheetName, int index) {
        wworkbook.createSheet(sheetName,index);
//        try {
//            wworkbook.write();
//        } catch (Exception e) {
//            logger.error("Fail to createSheet sheetName="+sheetName+" index="+index);
//        }
    }

    public void close() {
        logger.info("close()");
        try {
            wworkbook.write();
            wworkbook.close();
        } catch (IOException e) {
            logger.error("close() IOException");
        } catch (WriteException e) {
            logger.error("close() WriteException");
        }catch (Exception e){
            logger.error("close() Exception");
        }
    }

}
