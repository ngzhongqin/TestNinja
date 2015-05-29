package sg.ninjavan.autotest.framework.util;

/**
 * Created by zhongqinng on 30/5/15.
 */
public class Sleeper {
    public Sleeper(){};

    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }
}
