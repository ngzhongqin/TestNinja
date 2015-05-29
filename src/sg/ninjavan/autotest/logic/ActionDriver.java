package sg.ninjavan.autotest.logic;

import sg.ninjavan.autotest.framework.VO.ActionVO;
import sg.ninjavan.autotest.framework.util.Browser;

public class ActionDriver {
    private Browser browser;

    public  ActionDriver (){
        this.browser=new Browser();
    }


    public void startAction(ActionVO actionVO) {
        if(actionVO!=null){
            switch (actionVO.getAction()){
                case OpenBrowser:
                    this.browser.openBrowser(actionVO.getInput());
                    this.browser.takeScreenshot(actionVO);
                    break;
                case EnterText:
                    this.browser.enterTextBox(actionVO.getxPath(),actionVO.getInput());
                    this.browser.takeScreenshot(actionVO);
                    break;
                case ClickButton:
                    this.browser.clickButton(actionVO.getxPath());
                    this.browser.takeScreenshot(actionVO);
                    break;
                case FileInput:
                    this.browser.fileInput(actionVO.getxPath(),actionVO.getInput());
                    this.browser.takeScreenshot(actionVO);
                    break;
                case DropDown:
                    this.browser.dropDown(actionVO.getxPath(),actionVO.getInput());
                    this.browser.takeScreenshot(actionVO);
                    break;
                case Hover:
                    this.browser.hover(actionVO.getxPath());
                    this.browser.takeScreenshot(actionVO);
                    break;
                case CheckValue:
                    this.browser.checkValue(actionVO);
                    this.browser.takeScreenshot(actionVO);
                    break;
                default:
                    break;
            }
        }
    }

    public void close() {
        this.browser.closeBrowser();
    }

}
