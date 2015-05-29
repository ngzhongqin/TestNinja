package sg.ninjavan.autotest.framework.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sg.ninjavan.autotest.framework.VO.ActionVO;

import java.io.File;

/**
 * Created by zhongqinng on 27/5/15.
 */
public class Screenshot {
    private WebDriver driver;
    public Screenshot(WebDriver driver){
        this.driver=driver;
    }

    public boolean takeScreenshot(ActionVO actionVO){

        boolean returnBoolean = false;
        try {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            ExcelReader excelReader=new ExcelReader();
            FileUtils.copyFile(scrFile, new File(excelReader.getResultFolderPath() + actionVO.getSn() + "_" + actionVO.getDescription() + ".png"));
            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: takeScreenshot Exception - "+e.getMessage());
        }
        return returnBoolean;

    }
}
