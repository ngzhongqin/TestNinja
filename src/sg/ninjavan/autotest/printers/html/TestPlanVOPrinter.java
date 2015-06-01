package sg.ninjavan.autotest.printers.html;

import org.apache.log4j.Logger;
import sg.ninjavan.autotest.framework.VO.TestPlanVO;
import sg.ninjavan.autotest.framework.util.excel.ExcelWriter;

/**
 * Created by zhongqinng on 31/5/15.
 */
public class TestPlanVOPrinter {
    private TestPlanVO testPlanVO;
    public Logger logger = Logger.getLogger(TestPlanVOPrinter.class);

    public TestPlanVOPrinter(TestPlanVO testPlanVO){
        this.testPlanVO=testPlanVO;
    }
}
