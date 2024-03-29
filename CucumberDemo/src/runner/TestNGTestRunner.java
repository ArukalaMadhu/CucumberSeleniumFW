package runner;


import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import commonutils.FileUtilMetods;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(
		features = "src/features",//the path of the feature files location or folder/package path
		glue = {"com/stepdefinition","test/stepdef"},//the path of step definition files
//		format = {"pretty","html:target/cucumber-reports/cucumber-pretty",
//                "json:target/cucumber-reports/CucumberTestReport.json",
//                "rerun:target/cucumber-reports/rerun.txt"}, // generate different type of output files
		//plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty","json:target/cucumber-reports/CucumberTestReport.json"},
		plugin = { "pretty","html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json"},
		dryRun = false,  //if dryRun=true => This will check immediately whether steps has definition or not. (only checking purpose)
		monochrome = true, //display the output in console in readable format
		strict = true // it will fail the execution if it finds any undefined steps
		//tags= {"@smokeTest,@E2E"} // OR -> {"@smokeTest,@E2E"} AND -> {"@smokeTest","@E2E"}, {"~@smokeTest} means smokeTest will not be executed
		)

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
//	@AfterClass
//	 public static void writeExtentReport() {
//	 Reporter.loadXMLConfig(new File(FileUtilMetods.reportConfigPath));
//	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
//     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
//     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
//     Reporter.setSystemInfo("Selenium", "3.7.0");
//     Reporter.setSystemInfo("Java Version", "1.8.0_151");
//	 }
	
//	private TestNGCucumberRunner testNGCucumberRunner;
//	 
//    @BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
// 
//    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
//    public void feature(CucumberFeatureWrapper cucumberFeature) {
//        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//    }
// 
//    @DataProvider
//    public Object[][] features() {
//        return testNGCucumberRunner.provideFeatures();
//    }
// 
//    @AfterClass(alwaysRun = true) 
//    public void tearDownClass() throws Exception {
//        testNGCucumberRunner.finish();
//    }

}
