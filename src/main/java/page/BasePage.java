package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.DriverManager;

public class BasePage {
	
	public void clickEnterKey() {
		Actions actions = new Actions(DriverManager.getDriver());
		actions.sendKeys(Keys.ENTER);
		actions.perform();
	}
	
	public String getElemntText(WebElement element) {
		return element.getText();
	}

}
