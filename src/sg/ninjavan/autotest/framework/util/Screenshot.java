package sg.ninjavan.autotest.framework.util;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.excel.ExcelReader;

import java.io.File;

/**
 * Created by zhongqinng on 27/5/15.
 */
public class Screenshot {
    private WebDriver driver;
    private Logger logger = Logger.getLogger(Screenshot.class);
    public Screenshot(WebDriver driver){
        this.driver=driver;
    }

    public ActionVO takeScreenshot(ActionVO actionVO, int test_case){
        Sleeper sleeper=new Sleeper();
        sleeper.sleep(5);
        ActionVO returnActionVO = actionVO;
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            ExcelReader excelReader=new ExcelReader();
            String screenshotPath = excelReader.getResultFolderPath()+"/"
                    + "screenshots/"
                    + "TC_"+ Integer.toString(test_case)+"/"
                    + actionVO.getSn() + "_" + actionVO.getDescription() + ".png";
            FileUtils.copyFile(scrFile, new File(screenshotPath));
            returnActionVO.setScreenshotPath(screenshotPath);
        }catch (Exception e){
            logger.error("<Error>: takeScreenshot Exception");
        }
        return returnActionVO;

    }
}
