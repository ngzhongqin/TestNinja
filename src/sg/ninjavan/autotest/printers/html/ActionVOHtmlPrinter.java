package sg.ninjavan.autotest.printers.html;

import sg.ninjavan.autotest.framework.VO.ActionVO;

/**
 * Created by zhongqinng on 1/6/15.
 */
public class ActionVOHtmlPrinter {

    public ActionVOHtmlPrinter(){};

    public String print(ActionVO actionVO){
        String isPassed = "N";
        if(actionVO.isPass_fail()){
            isPassed="Y";
        }

        String actionVoDetail =
                "<tr>" + "\n"
                        + "<td width=\"5%\">"+ actionVO.getSn() +"</td>" + "\n"
                        + "<td width=\"20%\">"+ actionVO.getDescription()  + "</td>" + "\n"
                        + "<td width=\"5%\">"+ isPassed  + "</td>" + "\n"
                        + "<td width=\"10%\">"+ actionVO.getAction().toString() +"</td>" + "\n"
                        + "<td width=\"20%\">"+ actionVO.getxPath() +"</td>" + "\n"
                        + "<td width=\"20%\">"+ actionVO.getInput() +"</td>" + "\n"
                        + "<td width=\"10%\">"+ actionVO.getExpectedValue() +"</td>" + "\n"
                        + "<td width=\"10%\">"+ actionVO.getActualValue() +"</td>" + "\n"
                + "</tr>" + "\n";

        return actionVoDetail;
    }
}
