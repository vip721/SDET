package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features="src/test/java/Features",
        glue={"Steps"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

//    @BeforeClass
//    public  void setup(){
//
//    }
//
//
//    @AfterClass
//    public void tearDown(){
//
//    }



}



