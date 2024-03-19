package page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPage extends BasePage {

	public AmazonPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	public void populateSearchBox(String txt) {
		DriverManager.getDriver().navigate().refresh();
		searchBox.clear();
		searchBox.sendKeys(txt);
	}

	@FindBy(id = "nav-search-submit-button")
	private WebElement btnSearch;

	public void clickBtnSearch() {
		btnSearch.click();
	}

	@FindBy(css = "div[data-index='3'] img")
	private WebElement searchFirstOptImg;

	public void clicksearchFirstOptImg() {
		searchFirstOptImg.click();
	}

	public void clickOption(int nthOption) {
		By nthItem = By.cssSelector("div[data-index='" + String.valueOf(nthOption + 2) + "'] img");
		DriverManager.getDriver().findElement(nthItem).click();
	}

	public void switchToNewWindow() {
		Set<String> windowHandles = DriverManager.getDriver().getWindowHandles();
		String parentWindow = DriverManager.getDriver().getWindowHandle();

		for (String window : windowHandles) {
			if (!window.equals(parentWindow)) {
				DriverManager.getDriver().close();
				DriverManager.getDriver().switchTo().window(window);
				System.out.println("Switch to new window is succesfull");
				break;
			}
		}
	}

	@FindBy(css = "#corePriceDisplay_desktop_feature_div .a-price-whole")
	private WebElement productPagePrice;

	public String getProductPagePrice() {
		return getElemntText(productPagePrice).trim();
	}

	@FindBy(id = "add-to-cart-button")
	private List<WebElement> btnAddToCart;

	public void clickBtnAddToCart() {
		if(btnAddToCart.size()==1) {
			btnAddToCart.get(0).click();
			clickSkipIfVisible();
		}else {
			if(btnAddToCart.get(0).isDisplayed()) {
				btnAddToCart.get(0).click();
				clickSkipIfVisible();
			}else {
				btnAddToCart.get(1).click();
				clickSkipIfVisible();
			}
		}
	}
	
	@FindBy(css="#attachSiNoCoverage input")
	private WebElement btnSkip;
	
	public void clickSkipIfVisible() {
		try {
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(btnSkip)).click();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(css = "#attach-sidesheet-view-cart-button .a-button-input")
	private WebElement btnCart;

	public void clickBtnCart() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(btnCart)).click();
	}

	@FindBy(id ="nav-cart")
	private WebElement btnCartTopRight;
	
	public void clickBtnCartTopRight() {

		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(tagAdded));
		wait.until(ExpectedConditions.elementToBeClickable(btnCartTopRight)).click();
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Added')]")
	private WebElement tagAdded;
	
	@FindBy(css = ".sc-badge-price-to-pay span[class*='price']")
	private List<WebElement> cartPagePrice;

	public List<String> getCartPagePrice() {
		List<String> price = new ArrayList<>();
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		for(WebElement opt : cartPagePrice) {
			price.add(wait.until(ExpectedConditions.visibilityOf(opt)).getText().trim().replace(".00", ""));
		}
		return price;
	}

	@FindBy(css = "#sc-subtotal-amount-buybox span[class*='price']")
	private WebElement cartSubTotal;

	public String getCartSubTotal() {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(cartSubTotal)).getText().trim().replace(".00", "");
	}
}
