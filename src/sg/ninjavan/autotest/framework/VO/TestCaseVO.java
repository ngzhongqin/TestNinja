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

    public TestCaseVO(String description, ArrayList<ActionVO> actionVOs){
        this.description = description;
        this.actionVOs=actionVOs;
    }

}
