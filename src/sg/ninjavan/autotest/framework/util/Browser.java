package sg.ninjavan.autotest.framework.util;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.opera.core.systems.OperaDesktopDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.excel.ExcelReader;

/**
 * Created by zhongqinng on 26/5/15.
 */
public class Browser {
    private Logger logger = Logger.getLogger(Browser.class);
    private WebDriver driver;

    public Browser(){
        ExcelReader excelReader = new ExcelReader();
        /*
            Changing the driver from Chrome to Firefox.
            Chrome currently doesn't support full screen screenshot.
            http://stackoverflow.com/questions/3422262/take-a-screenshot-with-selenium-webdriver
            http://stackoverflow.com/questions/17885169/selenium-chrome-driver-makes-screenshot-just-of-visible-part-of-page
         */


        System.setProperty("webdriver.chrome.driver", excelReader.getChromeDriverPath());
        driver = new ChromeDriver();

//        driver = new FirefoxDriver();

    }

    public ActionVO openBrowser(ActionVO actionVO){
        logger.info("openBroswer() ");
        ActionVO returnActionVO = actionVO;
        returnActionVO.setPass_fail(false);
        try {
            driver.get(returnActionVO.getInput());
            returnActionVO.setPass_fail(true);
        }catch (Exception e){
            returnActionVO.setPass_fail(false);
            logger.error("openBrowser fail Description="+actionVO.getDescription()+" input="+actionVO.getInput());
        }
        return returnActionVO;
    }

    public ActionVO enterTextBox(ActionVO actionVO){
        ActionVO returnActionVO = actionVO;
        try {
            driver.findElement(By.xpath(returnActionVO.getxPath())).sendKeys(returnActionVO.getInput());

            returnActionVO.setPass_fail(true);
        }catch (Exception e){
            returnActionVO.setPass_fail(false);
            logger.error("enterTextBox fail Description="+actionVO.getDescription()+" xPath="+actionVO.getxPath()+" input="+actionVO.getInput());
        }
        return returnActionVO;
    }

    public ActionVO clickButton(ActionVO actionVO){
        ActionVO returnActionVO = actionVO;
        returnActionVO.setPass_fail(false);
        try {

            moveToElement(returnActionVO);

            driver.findElement(By.xpath(returnActionVO.getxPath())).click();

            returnActionVO.setPass_fail(true);
        }catch (Exception e){
            returnActionVO.setPass_fail(false);
            logger.error("clickButton fail Description=" + actionVO.getDescription() + " xPath=" + actionVO.getxPath());
        }
        return returnActionVO;
    }

    public boolean closeBrowser(){
        boolean returnBoolean = false;
        try {
            driver.close();

            returnBoolean = true;
        }catch (Exception e){
            returnBoolean = false;
            logger.error("closeBrowser fail");
        }
        return returnBoolean;
    }

    public ActionVO fileInput(ActionVO actionVO){
        ActionVO returnActionVO = actionVO;
        returnActionVO.setPass_fail(false);
        try {
            moveToElement(returnActionVO);

            driver.findElement(By.xpath(returnActionVO.getxPath())).sendKeys(returnActionVO.getInput());

            returnActionVO.setPass_fail(true);
        }catch (Exception e){
            returnActionVO.setPass_fail(false);
            logger.error("fileInput fail Description=" + actionVO.getDescription() + " xPath=" + actionVO.getxPath() + " input=" + actionVO.getInput());
        }
        return returnActionVO;
    }


    public ActionVO dropDown(ActionVO actionVO){
        ActionVO returnActionVO = actionVO;
        returnActionVO.setPass_fail(false);
        try {

            moveToElement(returnActionVO);

            Select select = new Select( driver.findElement(By.xpath(returnActionVO.getxPath())));
            select.deselectAll();
            select.selectByValue(returnActionVO.getInput());

            returnActionVO.setPass_fail(true);
        }catch (Exception e){
            returnActionVO.setPass_fail(false);
            logger.error("dropDown fail Description=" + actionVO.getDescription() + " xPath=" + actionVO.getxPath() + " input=" + actionVO.getInput());
        }
        return returnActionVO;
    }

    public ActionVO hover(ActionVO actionVO){
        ActionVO returnActionVO = actionVO;
        returnActionVO.setPass_fail(false);
        try {
            moveToElement(returnActionVO);
            Sleeper sleeper = new Sleeper();
            //hover takes more time
            sleeper.sleep(4);

            returnActionVO.setPass_fail(true);
        }catch (Exception e){
            returnActionVO.setPass_fail(false);
            logger.error("hover fail Description=" + actionVO.getDescription() + " xPath=" + actionVO.getxPath());
        }
        return returnActionVO;
    }

    public ActionVO checkValue(ActionVO actionVO){
        ActionVO returnActionVO = actionVO;
        try {
            moveToElement(returnActionVO);

            WebElement element = driver.findElement(By.xpath(returnActionVO.getxPath()));
            String actualValue = element.getText();
            returnActionVO.setActualValue(actualValue);
            if(returnActionVO.getExpectedValue().equals(returnActionVO.getActualValue())){
                returnActionVO.setPass_fail(true);
            }

        }catch (Exception e){
            returnActionVO.setPass_fail(false);
            logger.error("checkValue fail Description=" + returnActionVO.getDescription() + " xPath=" + returnActionVO.getxPath()+
            " actualValue="+returnActionVO.getActualValue()+ " expectedValue="+returnActionVO.getExpectedValue());
        }

        return returnActionVO;
    }

    public void takeScreenshot(ActionVO actionVO, int testCaseIndex){
        Screenshot screenshot = new Screenshot(driver);
        screenshot.takeScreenshot(actionVO,testCaseIndex);
    }

    public void moveToElement(ActionVO actionVO){
        WebElement element = driver.findElement(By.xpath(actionVO.getxPath()));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

}
