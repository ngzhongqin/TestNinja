package sg.ninjavan.autotest.framework.util;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.constants.ErrorCode;

/**
 * Created by zhongqinng on 26/5/15.
 */
public class Browser {
    private WebDriver driver;

    public Browser(){
        ExcelReader excelReader = new ExcelReader();
        System.setProperty("webdriver.chrome.driver", excelReader.getChromeDriverPath());
        driver = new ChromeDriver();
    }

    public boolean openBrowser(String url){
        System.out.println("url: "+url);
        boolean returnBoolean = false;
        try {
            driver.get(url);
            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: Exception - "+e.getMessage() + " url: "+url);
        }
        return returnBoolean;
    }

    public boolean enterTextBox(String xPath, String textString){
        boolean returnBoolean = false;
        try {
            driver.findElement(By.xpath(xPath)).sendKeys(textString);

            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: enterTextBox Exception - "+e.getMessage() + " xpath: "+xPath);
        }
        return returnBoolean;
    }

    public boolean clickButton(String xPath){
        boolean returnBoolean = false;
        try {
            driver.findElement(By.xpath(xPath)).click();

            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: clickButton Exception - "+e.getMessage() + " xpath: "+xPath);
            System.out.println("<Error>: xpath not found: "+xPath);
            System.exit(ErrorCode.ELEMENT_NOT_FOUND);
        }
        return returnBoolean;
    }

    public boolean closeBrowser(){
        boolean returnBoolean = false;
        try {
            driver.close();

            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: closeBrowser Exception - "+e.getMessage());
        }
        return returnBoolean;
    }

    public boolean fileInput(String xPath, String input){
        boolean returnBoolean = false;
        try {
            driver.findElement(By.xpath(xPath)).sendKeys(input);

            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: fileInput Exception - "+e.getMessage() + " xpath: "+xPath+" input: "+input);
            System.exit(ErrorCode.ELEMENT_NOT_FOUND);
        }
        return returnBoolean;
    }

    public boolean dropDown(String xPath, String input){
        boolean returnBoolean = false;
        try {
            Select select = new Select( driver.findElement(By.xpath(xPath)));
            select.deselectAll();
            select.selectByValue(input);

            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: dropDown Exception - "+e.getMessage() + " xpath: "+xPath+" input: "+input);
        }
        return returnBoolean;
    }

    public boolean hover(String xPath){
        boolean returnBoolean = false;
        try {
            WebElement element = driver.findElement(By.xpath(xPath));
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
            Sleeper sleeper = new Sleeper();
            sleeper.sleep(2);

            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            System.out.println("<Error>: hover Exception - "+e.getMessage() + " xpath: "+xPath);
            System.exit(ErrorCode.ELEMENT_NOT_FOUND);
        }
        return returnBoolean;
    }

    public ActionVO checkValue(ActionVO actionVO){
        ActionVO returnActionVO = actionVO;
        try {
            WebElement element = driver.findElement(By.xpath(returnActionVO.getxPath()));
            String actualValue = element.getText();
            System.out.println("checkValue: actualValue: "+actualValue+" expectedValue: ");

        }catch (Exception e){
            System.out.println("<Error>: checkValue Exception - "+e.getMessage() + " xpath: "+actionVO);
            System.exit(ErrorCode.ELEMENT_NOT_FOUND);
        }
        return returnActionVO;
    }

    public void takeScreenshot(ActionVO actionVO){
        Screenshot screenshot = new Screenshot(driver);
        screenshot.takeScreenshot(actionVO);
    }



}
