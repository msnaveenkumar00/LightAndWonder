package driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private DriverManager() {};
	
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(WebDriver driverRef) {
		if(Objects.nonNull(driverRef)) {
			driver.set(driverRef);
		}
	}
	
	public static void unload() {
		driver.remove();
	}
}
