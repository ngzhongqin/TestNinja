package sg.ninjavan.autotest;

import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        DOMConfigurator.configure("log4j.xml");
        PropertyConfigurator.configure("log4j.properties");
        logger.info("start");
    }
}
