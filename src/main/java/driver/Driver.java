package driver;

import java.time.Duration;
import java.util.Objects;

import constatnts.FrameworkConstants;
import enums.ConfigProp;
import utils.PropUtil;

public class Driver {

	private Driver() {
	}

	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (Exception e) {
				e.printStackTrace();
			}

			DriverManager.getDriver().manage().timeouts()
					.implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWait()));
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().get(PropUtil.get(ConfigProp.URL));
			DriverManager.getDriver().manage().window().maximize();

		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
