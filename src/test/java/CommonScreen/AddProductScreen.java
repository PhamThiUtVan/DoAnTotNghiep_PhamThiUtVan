package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class AddProductScreen {
	public static final String NAME_TXT_ID = "name";
	public static final String CODE_TXT_ID = "code";
	public static final String UPLOAD_BTN_XPATH = "//button[contains(text(),'Upload')]";
	public static final String UPLOAD_INPUT_XPATH = "//input[@type='file' and @name='img[]']";
	public static final String DESCRIPTION_TXT_ID = "description";
	public static final String PRICE_TXT_ID = "price";
	public static final String SALE_TXT_ID = "priceSale";
	public static final String QUANTITY_TXT_ID = "quantity";
	public static final String ADD_BTN_XPATH = "//button[contains(text(),'Thêm mới')]";
	
	public static final String MSG_XPATH = "//div[@class='swal-modal']//div[@class='swal-text']";
	
	public static final String SUCCESS_MSG = "Thêm sản phẩm thành công";
	public static final String NAME_EMPTY_MSG = "Tên sản phẩm là bắt buộc";
	public static final String CODE_EMPTY_MSG = "Mã sản phẩm là bắt buộc";
	public static final String CODE_EXIST_MSG = "Mã sản phẩm đã tồn tại";
	public static final String IMAGE_EMPTY_MSG = "Hình ảnh là bắt buộc";
	public static final String DESCRIPTION_EMPTY_MSG = "Mô tả là bắt buộc";
	public static final String PRICE_EMPTY_MSG = "Giá sản phẩm là bắt buộc";
	public static final String PRICE_INVALID_MSG = "Giá gốc không hợp lệ";
	public static final String SALE_EMPTY_MSG = "Giá bán là bắt buộc";
	public static final String SALE_INVALID_MSG = "Giá bán không hợp lệ";
	public static final String QUANTITY_EMPTY_MSG = "Số lượng sản phẩm là bắt buộc";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL_ADMIN);
			LoginAdminScreen.login(driver, Constant.BASE_EMAIL_ADMIN, Constant.BASE_PASSWORD_ADMIN);
			Utilities.clickObscuredElement(driver, HomeAdminScreen.PRODUCT_LINK_XPATH, HomeAdminScreen.ADD_PRODUCT_LINK_XPATH, Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, HomeAdminScreen.ADD_PRODUCT_LINK_XPATH, ADD_BTN_XPATH, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void addProduct(WebDriver driver, String id, String name, String code, String image, String description, String price, String sale, 
	        String quantity, String expectedMsg) throws Exception {
	    Utilities.inputValueAndValidate(driver, By.id(NAME_TXT_ID), name, name);
	    Utilities.inputValueAndValidate(driver, By.id(CODE_TXT_ID), code, code);
	    if (!image.equals(Constant.EMPTY_STRING)) {
	        org.openqa.selenium.WebElement fileInput = driver.findElement(By.xpath(UPLOAD_INPUT_XPATH));
	        fileInput.sendKeys(Constant.IMAGE_FOLDER + image);
	        Thread.sleep(2000);
	    }
	    Utilities.inputValueAndValidate(driver, By.id(DESCRIPTION_TXT_ID), description, description);
	    Utilities.inputValueAndValidate(driver, By.id(PRICE_TXT_ID), price, price);
	    Utilities.inputValueAndValidate(driver, By.id(SALE_TXT_ID), sale, sale);
	    Utilities.inputValueAndValidate(driver, By.id(QUANTITY_TXT_ID), quantity, quantity);
	    Utilities.clickObscuredElement(driver, ADD_BTN_XPATH, MSG_XPATH, Constant.WAIT_ELEMENT_EXIST);
	    
	    String actualMsg = "";
	    try {
	        actualMsg = driver.findElement(By.xpath(MSG_XPATH)).getText();
	    } catch (Exception e) {
	        actualMsg = "";
	    }
	    
	    Utilities.captureScreen(driver, id);
	    
	    try {
	        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
	        js.executeScript(
	            "var overlays = document.querySelectorAll('.swal-overlay'); " +
	            "overlays.forEach(function(el) { el.remove(); }); " +
	            "document.body.classList.remove('swal-displayed');"
	        );
	        Thread.sleep(1500);
	    } catch (Exception e) {
	    }
	    
	    Utilities.assertString(expectedMsg, actualMsg);
	}
}
