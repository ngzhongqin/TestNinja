package sg.ninjavan.autotest.drivers;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.Browser;


public class ActionVODriver {
    private Logger logger = Logger.getLogger(ActionVODriver.class);
    public ActionVODriver(){
    }


    public ActionVO start(ActionVO actionVO, Browser browser, int testCaseIndex) {
        logger.info("Start() ActionVO: SN="+actionVO.getSn()+" Description="+actionVO.getDescription());
        ActionVO returnActionVO = actionVO;
        if(actionVO!=null){
            switch (actionVO.getAction()){
                case OpenBrowser:
                    returnActionVO = browser.openBrowser(actionVO);
                    browser.takeScreenshot(actionVO,testCaseIndex);
                    break;
                case EnterText:
                    returnActionVO = browser.enterTextBox(actionVO);
                    browser.takeScreenshot(actionVO,testCaseIndex);
                    break;
                case ClickButton:
                    returnActionVO = browser.clickButton(actionVO);
                    browser.takeScreenshot(actionVO,testCaseIndex);
                    break;
                case FileInput:
                    returnActionVO = browser.fileInput(actionVO);
                    browser.takeScreenshot(actionVO,testCaseIndex);
                    break;
                case DropDown:
                    returnActionVO = browser.dropDown(actionVO);
                    browser.takeScreenshot(actionVO,testCaseIndex);
                    break;
                case Hover:
                    returnActionVO =  browser.hover(actionVO);
                    browser.takeScreenshot(actionVO,testCaseIndex);
                    break;
                case CheckValue:
                    returnActionVO = browser.checkValue(actionVO);
                    browser.takeScreenshot(actionVO,testCaseIndex);
                    break;
                default:
                    break;
            }
        }
        print_result_on_log(returnActionVO);
        return returnActionVO;
    }

    private void print_result_on_log(ActionVO actionVO){
        logger.info("Result Description="+actionVO.getDescription()
                    + " ActionType="+actionVO.getAction()
                    + " Pass="+actionVO.isPass_fail());
    }
}
