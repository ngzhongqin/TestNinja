package sg.ninjavan.autotest.framework.VO;

import java.util.ArrayList;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class TestCaseVO {
    private ArrayList<ActionVO> actionVOs;
    private String description;
    private int total_steps;
    private int total_steps_passed;
    private boolean passed;

    public TestCaseVO(String description, ArrayList<ActionVO> actionVOs){
        this.description = description;
        this.actionVOs=actionVOs;
        this.passed=false;
    }

    public ArrayList<ActionVO> getActionVOs() {
        return actionVOs;
    }

    public void setActionVOs(ArrayList<ActionVO> actionVOs) {
        this.actionVOs = actionVOs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal_steps() {
        return total_steps;
    }

    public void setTotal_steps(int total_steps) {
        this.total_steps = total_steps;
    }

    public int getTotal_steps_passed() {
        return total_steps_passed;
    }

    public void setTotal_steps_passed(int total_steps_passed) {
        this.total_steps_passed = total_steps_passed;
    }

    public boolean isPassed() {
        if(total_steps==total_steps_passed)
            this.passed=true;
        else
            this.passed=false;

        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
