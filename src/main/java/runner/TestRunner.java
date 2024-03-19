package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import driver.Driver;
import page.BasePage;

public class TestRunner extends BasePage{

	protected TestRunner() {};
	
	@BeforeMethod
	@Parameters(value = {"browserName"})
	protected void setUp(String browserName) {
		Driver.initDriver(browserName);
	}
	
	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
	
}
