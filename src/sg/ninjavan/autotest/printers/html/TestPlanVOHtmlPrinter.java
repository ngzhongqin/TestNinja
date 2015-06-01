package sg.ninjavan.autotest.printers.html;

import org.apache.log4j.Logger;
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
        HtmlWriter htmlWriter = new HtmlWriter();
        htmlWriter.print();
    }

}
