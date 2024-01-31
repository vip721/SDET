package Steps;

import Common.BaseTest;
import Runner.TestRunner;
import io.cucumber.java.After;

public class Hooks extends TestRunner {

    @After(order = 1)
    public void tearDown(){
        if (BaseTest.getDriver() != null) {
            BaseTest.getDriver().quit();
            BaseTest.driver = null;
        }
    }
}
