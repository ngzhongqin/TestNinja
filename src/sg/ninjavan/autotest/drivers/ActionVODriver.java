package sg.ninjavan.autotest.drivers;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.Browser;

public class ActionVODriver {
    private Logger logger = Logger.getLogger(ActionVODriver.class);
    public ActionVODriver(){
    }


    public void start(ActionVO actionVO, Browser browser) {
        logger.info("Start() ActionVO: SN="+actionVO.getSn()+" Description="+actionVO.getDescription());
        if(actionVO!=null){
            switch (actionVO.getAction()){
                case OpenBrowser:
                    browser.openBrowser(actionVO.getInput());
                    browser.takeScreenshot(actionVO);
                    break;
                case EnterText:
                    browser.enterTextBox(actionVO.getxPath(),actionVO.getInput());
                    browser.takeScreenshot(actionVO);
                    break;
                case ClickButton:
                    browser.clickButton(actionVO.getxPath());
                    browser.takeScreenshot(actionVO);
                    break;
                case FileInput:
                    browser.fileInput(actionVO.getxPath(),actionVO.getInput());
                    browser.takeScreenshot(actionVO);
                    break;
                case DropDown:
                    browser.dropDown(actionVO.getxPath(),actionVO.getInput());
                    browser.takeScreenshot(actionVO);
                    break;
                case Hover:
                    browser.hover(actionVO.getxPath());
                    browser.takeScreenshot(actionVO);
                    break;
                case CheckValue:
                    browser.checkValue(actionVO);
                    browser.takeScreenshot(actionVO);
                    break;
                default:
                    break;
            }
        }
    }
}
