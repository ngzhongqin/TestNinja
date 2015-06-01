package sg.ninjavan.autotest.printers.html;

import sg.ninjavan.autotest.framework.VO.TestCaseVO;

/**
 * Created by zhongqinng on 1/6/15.
 */
public class TestCaseVOHtmlPrinter {
    private ActionVOHtmlPrinter actionVOHtmlPrinter;

    public TestCaseVOHtmlPrinter(){
        actionVOHtmlPrinter = new ActionVOHtmlPrinter();
    };

    public String print(TestCaseVO testCaseVO, int testCaseIndex){
        String testCaseString =
                "<h3>"+ "TC_"+Integer.toString(testCaseIndex)+" "+testCaseVO.getDescription() +"</h3>"+ "\n"
                + "<table border=\"1\" >" + "\n"
                + "<tr>" + "\n"
                        + "<th width=\"4%\">"+ "S/N" +"</th>" + "\n"
                        + "<th width=\"20%\">"+ "Description"  + "</th>" + "\n"
                        + "<th width=\"4%\">"+ "Screenshot"  + "</th>" + "\n"
                        + "<th width=\"2%\">"+ "Pass"  + "</th>" + "\n"
                        + "<th width=\"10%\">"+ "ActionType" +"</th>" + "\n"
                        + "<th width=\"20%\">"+ "xPath" +"</th>" + "\n"
                        + "<th width=\"20%\">"+ "Input" +"</th>" + "\n"
                        + "<th width=\"10%\">"+ "Expected" +"</th>" + "\n"
                        + "<th width=\"10%\">"+ "Actual" +"</th>" + "\n"
                + "</tr>" + "\n";


        int i = 0;
        int size = -1;
        if(testCaseVO!=null){
            if(testCaseVO.getActionVOs()!=null){
                size=testCaseVO.getActionVOs().size();
            }
        }

        while (i<size){
            testCaseString=testCaseString+actionVOHtmlPrinter.print(testCaseVO.getActionVOs().get(i));
            i++;
        }

        testCaseString = testCaseString + "</table>" + "\n";

        return testCaseString;
    }


}
