package sg.ninjavan.autotest.framework.util.html;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.util.DateHandler;
import sg.ninjavan.autotest.framework.util.excel.ExcelReader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by zhongqinng on 1/6/15.
 * This class prints the content onto a html
 */
public class HtmlWriter {
    public static Logger logger = Logger.getLogger(HtmlWriter.class);


    public void print() {
        try {
            ExcelReader excelReader = new ExcelReader();
            DateHandler dateHandler = new DateHandler();
            String templatePath = excelReader.getReportTemplatePath();

            String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
//            for (int i = 0; i < details.size();i++) {
//                reportIn = reportIn.replaceFirst(resultPlaceholder,"<tr><td>" + Integer.toString(i+1) + "</td><td>" + details.get(i).getResult() + "</td><td>" + details.get(i).getResultText() + "</td></tr>" + resultPlaceholder);
//            }


            dateHandler.getDateString();

            String reportPath = excelReader.getResultFolderPath()+dateHandler.getDateString()+"_result.html";
            Files.write(Paths.get(reportPath),reportIn.getBytes(), StandardOpenOption.CREATE);

        } catch (Exception e) {
            System.out.println("Error when writing report file:\n" + e.toString());
        }
    }

}
