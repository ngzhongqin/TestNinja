package sg.ninjavan.autotest.printers.html;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.TestCaseVO;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.framework.util.html.HtmlWriter;

/**
 * Created by zhongqinng on 31/5/15.
 */
public class TestPlanVOHtmlPrinter {
    private TestPlanVO testPlanVO;
    public Logger logger = Logger.getLogger(TestPlanVOHtmlPrinter.class);

    public TestPlanVOHtmlPrinter(TestPlanVO testPlanVO){
        this.testPlanVO=testPlanVO;
    }

    public void print(){
        String testPlanCover = getTestPlanCover();
        String testCaseDetails = getTestCaseDetails();
        HtmlWriter htmlWriter = new HtmlWriter();
        htmlWriter.print(testPlanCover,testCaseDetails);


    }

    private String getTestCaseDetails() {
        String testCaseDetails = null;
        int i =0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();

            }
        }

        logger.info("getTestCaseDetails() int="+i+" size="+size);
        TestCaseVOHtmlPrinter testCaseVOHtmlPrinter = new TestCaseVOHtmlPrinter();

        if(size>0) {
            //print the first test case
            //so that the report wouldnt have null
            testCaseDetails = testCaseVOHtmlPrinter.print(testPlanVO.getTestCaseVOs().get(0), 0);
            i++;

            while (i < size) {
                testCaseDetails = testCaseDetails + testCaseVOHtmlPrinter.print(testPlanVO.getTestCaseVOs().get(i), i);
                i++;
            }
        }

        return testCaseDetails;
    }


    private String getTestPlanCover() {
        String testPlanCover= "<h1>Ninja Test Plan</h1>"+ "\n"
                + populateElapsedTime()
                + "<h2>Test Cases</h2>"+ "\n"
                + "<table border=\"1\" >" + "\n"
                + "<tr>" + "\n"
                + "<th width=\"10%\">TC</th>" + "\n"
                + "<th width=\"50%\">Description</th>" + "\n"
                + "<th width=\"10%\">Total Steps</th>" + "\n"
                + "<th width=\"10%\">Total Pass</th>" + "\n"
                + "<th width=\"10%\">Pass</th>" + "\n"
                + "</tr>" + "\n"
                + populateTestPlanDetails()
                + "</table>" + "\n";

        return testPlanCover;
    }

    private String populateElapsedTime(){
        String elapsedTime =
                "<table border=\"1\" >" + "\n"
                        + "<tr>" + "\n"
                            + "<th width=\"20%\">Start Time</th>" + "\n"
                            + "<td width=\"20%\">"+testPlanVO.getStartTime()+"</td>" + "\n"
                        + "<tr>" + "\n"
                        + "<tr>" + "\n"
                            + "<th width=\"20%\">Elapsed Time</th>" + "\n"
                            + "<td width=\"20%\">"+testPlanVO.getElapsedTime()+"</td>" + "\n"
                        + "<tr>" + "\n"
                        + "<tr>" + "\n"
                            + "<th width=\"20%\">End Time</th>" + "\n"
                            + "<td width=\"20%\">"+testPlanVO.getEndTime()+"</td>" + "\n"
                        + "<tr>" + "\n"
                        + "<tr>" + "\n"
                            + "<th width=\"20%\">Total Test Cases</th>" + "\n"
                            + "<td width=\"20%\">"+testPlanVO.getTotal_test_case()+"</td>" + "\n"
                        + "<tr>" + "\n"
                        + "<tr>" + "\n"
                            + "<th width=\"20%\">Passed Test Cases</th>" + "\n"
                            + "<td width=\"20%\">"+testPlanVO.getTotal_passed()+"</td>" + "\n"
                        + "<tr>" + "\n"
                        + "<tr>" + "\n"
                            + "<th width=\"20%\">% Passed</th>" + "\n"
                            + "<td width=\"20%\">"+testPlanVO.getPercentagePassed()+"</td>" + "\n"
                        + "<tr>" + "\n"
                + "</table>" + "\n";
        return elapsedTime;
    }

    private String populateTestPlanDetails(){
        String testPlanDetails = null;

        int i =0;
        int size = -1;
        if(testPlanVO!=null){
            if(testPlanVO.getTestCaseVOs()!=null){
                size = testPlanVO.getTestCaseVOs().size();

            }
        }

        logger.info("populateTestPlanDetails() int="+i+" size="+size);
        if(size>0) {
            testPlanDetails = populateTestPlanDetailsItems(testPlanVO.getTestCaseVOs().get(0),0);
            i++;
            while (i < size) {
                testPlanDetails = testPlanDetails + populateTestPlanDetailsItems(testPlanVO.getTestCaseVOs().get(i), i);
                i++;
            }
        }


        return testPlanDetails;
    }

    private String populateTestPlanDetailsItems(TestCaseVO testCaseVO, int i) {
        String isPassed = "N";
        if(testCaseVO.isPassed())
            isPassed="Y";

        String item =
                "<tr>" + "\n"
                + "<td width=\"10%\">"+ Integer.toString(i) +"</td>" + "\n"
                + "<td width=\"50%\">"+ testCaseVO.getDescription()  + "</td>" + "\n"
                + "<td width=\"10%\">"+ testCaseVO.getTotal_steps()  + "</td>" + "\n"
                + "<td width=\"10%\">"+ testCaseVO.getTotal_steps_passed() +"</td>" + "\n"
                + "<td width=\"10%\">"+ isPassed +"</td>" + "\n"
                + "</tr>" + "\n";
        return item;
    }

}
