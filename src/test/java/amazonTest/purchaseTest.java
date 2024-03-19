package amazonTest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import page.AmazonPage;
import runner.TestRunner;

public class purchaseTest extends TestRunner {

	AmazonPage AmazonPage;

	@BeforeMethod
	@BeforeClass
	public void setUp() {
		AmazonPage = new AmazonPage();
	}

	@Test(enabled = true)
	public void verifyMonitorPurchaseTest() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String productPagePrice = null;
		String cartPagePrice = null;
		String subTotal = null;

		// Populating Search box with monitor and clicking enter
		AmazonPage.populateSearchBox("Monitor");
		clickEnterKey();
		// Selecting 1st option form search result
		AmazonPage.clickOption(1);
		// Switching to product page
		AmazonPage.switchToNewWindow();
		// Capturing Product page price
		productPagePrice = AmazonPage.getProductPagePrice();
		// Adding the product to cart and navigating to cart page
		AmazonPage.clickBtnAddToCart();
		AmazonPage.clickBtnCart();
		// Capturing Cart page price and Cart sub total
		cartPagePrice = AmazonPage.getCartPagePrice().get(0);
		subTotal = AmazonPage.getCartSubTotal();
		// Asserting product page price with cart page price and cart sub total
		softAssert.assertEquals(productPagePrice, cartPagePrice, "Product page price and Cart page price do not match");
		softAssert.assertEquals(productPagePrice, subTotal, "Product page price and Subtotal do not match");
		// Assert all
		softAssert.assertAll();
	}

	@Test(enabled = true)
	public void verifyLaptopPurchaseTest() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		String productPagePrice = null;
		String cartPagePrice = null;
		String subTotal = null;

		// Populating Search box with monitor and clicking enter
		AmazonPage.populateSearchBox("Laptop");
		clickEnterKey();
		// Selecting 2nd option form search result
		AmazonPage.clickOption(2);
		// Switching to product page
		AmazonPage.switchToNewWindow();
		// Capturing Product page price
		productPagePrice = AmazonPage.getProductPagePrice();
		// Adding the product to cart and navigating to cart page
		AmazonPage.clickBtnAddToCart();
		AmazonPage.clickBtnCartTopRight();
		// Capturing Cart page price and Cart sub total
		cartPagePrice = AmazonPage.getCartPagePrice().get(0);
		subTotal = AmazonPage.getCartSubTotal();
		// Asserting product page price with cart page price and cart sub total
		softAssert.assertEquals(productPagePrice, cartPagePrice, "Product page price and Cart page price do not match");
		softAssert.assertEquals(productPagePrice, subTotal, "Product page price and Subtotal do not match");
		// Assert all
		softAssert.assertAll();

	}

	@Test(enabled = true)
	public void verifyHeadphoneAndKeyboardPurchaseTest() throws InterruptedException {

		SoftAssert softAssert = new SoftAssert();

		int headPhoneProductPagePrice;
		int keyboardProductPagePrice;
		int totalAmount;
		int cartPagePrice1;
		int cartPagePrice2;
		int subTotal;

		// Populating Search box with Headphones and clicking enter
		AmazonPage.populateSearchBox("Headphones");
		clickEnterKey();
		// Selecting 2nd option form search result
		AmazonPage.clickOption(1);
		// Switching to product page
		AmazonPage.switchToNewWindow();
		// Capturing Product page price
		headPhoneProductPagePrice = Integer.parseInt(AmazonPage.getProductPagePrice().replaceAll(",", ""));
		// Adding the product to cart and navigating to cart page
		AmazonPage.clickBtnAddToCart();
		AmazonPage.clickBtnCartTopRight();
		// Populating Search box with Keyboards and clicking enter
		AmazonPage.populateSearchBox("Keyboard");
		clickEnterKey();
		// Selecting 2nd option form search result
		AmazonPage.clickOption(1);
		// Switching to product page
		AmazonPage.switchToNewWindow();
		// Capturing Product page price
		keyboardProductPagePrice = Integer.parseInt(AmazonPage.getProductPagePrice().replaceAll(",", ""));
		// Adding the product to cart and navigating to cart page
		AmazonPage.clickBtnAddToCart();
		AmazonPage.clickBtnCart();
		// Sum of both products
		totalAmount = headPhoneProductPagePrice + keyboardProductPagePrice;
		// Capturing Cart page price and Cart sub total
		cartPagePrice1 = Integer.parseInt(AmazonPage.getCartPagePrice().get(0).replace(",", ""));
		cartPagePrice2 = Integer.parseInt(AmazonPage.getCartPagePrice().get(1).replace(",", ""));
		subTotal = Integer.parseInt(AmazonPage.getCartSubTotal().replaceAll(",", ""));
		// Asserting product page price with cart page price and cart sub total
		softAssert.assertEquals(keyboardProductPagePrice, cartPagePrice1, "Product page price and Cart page price do not match for Keyboard");
		softAssert.assertEquals(headPhoneProductPagePrice, cartPagePrice2, "Product page price and Cart page price do not match for headphone");
		softAssert.assertEquals(totalAmount, subTotal, "Product page price and Subtotal do not match");
		// Assert all
		softAssert.assertAll();
	}
}
