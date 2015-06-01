package sg.ninjavan.autotest.framework.util.excel;

import jxl.Workbook;
import jxl.format.*;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.*;
import jxl.write.Colour;
import jxl.write.Pattern;
import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.util.DateHandler;

import java.io.File;
import java.io.IOException;

/**
 * Created by zhongqinng on 31/5/15.
 * This class is used to write content into the result sheet.
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
        logger.debug("writeCell sheet_num=" + sheet_num + " col=" + col + " row=" + row + " content=" + content);
        WritableSheet writableSheet = wworkbook.getSheet(sheet_num);
        Label label = new Label(col,row,content,getChildCellFormat());
        try {
            writableSheet.addCell(label);
        } catch (Exception e) {
            logger.error("writeCell sheet_num=" + sheet_num + " col=" + col+" row="+row+" content="+content);
        }
    }

    public void writeHeaderCell(int sheet_num,int col,int row,String content){
        logger.debug("writeHeaderCell sheet_num=" + sheet_num + " col=" + col + " row=" + row + " content=" + content);
        WritableSheet writableSheet = wworkbook.getSheet(sheet_num);
        Label label = null;
        try {
            label = new Label(col,row,content,getHeaderCellFormat());
        } catch (Exception e) {
            logger.error("writeHeaderCell set label");
        }

        try {
            writableSheet.addCell(label);
        } catch (Exception e) {
            logger.error("writeHeaderCell sheet_num=" + sheet_num + " col=" + col+" row="+row+" content="+content);
        }
    }

    public void createSheet(String sheetName, int index) {
        wworkbook.createSheet(sheetName,index);
    }


    //This method must be used to write all the changes back into the excel sheet.
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

    private WritableCellFormat getHeaderCellFormat() {
        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 16);
        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        try {
            cellFormat.setBackground(jxl.format.Colour.YELLOW, jxl.format.Pattern.SOLID);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        } catch (Exception e) {
            logger.error("getChildCellFormat() IOException");
        }
        return cellFormat;
    }

    private WritableCellFormat getChildCellFormat() {
        WritableFont cellFont = new WritableFont(WritableFont.COURIER, 12);
        WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
        try {
            cellFormat.setBackground(jxl.format.Colour.WHITE, jxl.format.Pattern.NONE);
            cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
        } catch (Exception e) {
            logger.error("getChildCellFormat() IOException");
        }
        return cellFormat;
    }

}
