package sg.ninjavan.autotest.framework.VO;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.constants.ActionType;

/**
 * Created by zhongqinng on 26/5/15.
 */
public class ActionVO {
    private Logger logger = Logger.getLogger(ActionVO.class);
    private String sn;
    private ActionType action;
    private String input;
    private String xPath;
    private String description;
    private boolean screenshot_needed;
    private String expectedValue;
    private String actualValue;
    private boolean pass_fail;
    private String screenshotPath;

    public ActionVO(String sn,
                    String actionString,
                    String xPath,
                    String input,
                    String description,
                    String screenshot_needed,
                    String expectedValue){
        logger.info("ActionVO created - sn= " + sn
                + " actionString= " + actionString
                + " xPath= "+xPath
                + " input= "+ input
                + " description= "+description
                + " screenshot_needed= "+screenshot_needed
                + " expectedValue= "+expectedValue);

        if(sn!=null) {
            this.sn = sn;
        }
        if(actionString!=null) {
            if (actionString.equals("OpenBrowser")) {
                this.action = ActionType.OpenBrowser;
            }

            if (actionString.equals("EnterText")) {
                this.action = ActionType.EnterText;
            }

            if (actionString.equals("ClickButton")) {
                this.action = ActionType.ClickButton;
            }

            if (actionString.equals("FileInput")) {
                this.action = ActionType.FileInput;
            }
            if (actionString.equals("DropDown")) {
                this.action = ActionType.DropDown;
            }
            if (actionString.equals("Hover")) {
                this.action = ActionType.Hover;
            }
            if (actionString.equals("CheckValue")) {
                this.action = ActionType.CheckValue;
            }
            this.actualValue=" ";
        }

        this.input=input;
        this.xPath=xPath;
        this.description=description;
        this.screenshot_needed=false;
        if(screenshot_needed!=null){
            if(screenshot_needed.equals("Y")){
                this.screenshot_needed=true;
            }
        }

        this.expectedValue = expectedValue;
    }




    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getxPath() {
        return xPath;
    }

    public void setxPath(String xPath) {
        this.xPath = xPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isScreenshot_needed() {
        return screenshot_needed;
    }

    public void setScreenshot_needed(boolean screenshot_needed) {
        this.screenshot_needed = screenshot_needed;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getActualValue() {
        return actualValue;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }

    public boolean isPass_fail() {
        return pass_fail;
    }

    public void setPass_fail(boolean pass_fail) {
        this.pass_fail = pass_fail;
    }

    public String getScreenshotPath() {
        return screenshotPath;
    }

    public void setScreenshotPath(String screenshotPath) {
        this.screenshotPath = screenshotPath;
    }
}
