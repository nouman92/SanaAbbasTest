package sanaabbastest;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class SanaAbbasTestSuite {
	WebDriver driver;
	boolean outOfStock = false;
	@BeforeTest
	public void beforeTest() throws MalformedURLException {	

		//chrome remote Driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("/usr/bin/google-chrome");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); 
	}

	@AfterTest
	public void afterTest(){

		driver.quit();

	}
	@Test
	public void SanaAbbasTest() {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		WebElement addCart;

		//OPEN WEBSITE
		driver.get("http://www.sanaabbas.com/");
		//,"LUXURY PRET","FORMALS","BRIDALS"
		List<String> LinksString = Arrays.asList("PRET","LUXURY PRET","FORMALS","BRIDALS");
		//RANDOMLY SELECT CATEGORY
		Random randomCategories = new Random();
		String randomLink = LinksString.get(randomCategories.nextInt(LinksString.size()));
		driver.findElement(By.linkText(randomLink)).click();
		System.out.println("Randomly selected Tab is : " + randomLink);

		if(randomLink==LinksString.get(0))
		{
			System.out.println("Page title is: " + driver.getTitle());

			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			//System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 100);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));
			System.out.println("Random product getText is "+randomProduct.getText());
			System.out.println("Random product getAttribute title is "+randomProduct.getAttribute("class"));
			//randomProduct.click();
			
			Actions actions = new Actions(driver);
			actions.moveToElement(randomProduct).click().perform();
			System.out.println("Random product is clicked");

			//String a=randomProduct.getAttribute("class");
			WebElement a=driver.findElement(By.cssSelector(".bundle-option.option-Size"));//*[@id="product-options-wrapper"]/dl/dd/div
			System.out.println(a.getText());
			System.out.println("id is "+a.getAttribute("id"));
			System.out.println("class is "+a.getAttribute("class"));
			System.out.println("name is "+a.getAttribute("name"));
			System.out.println("Tagname is "+a.getTagName());

			//*[@id="bundle-option-87"]
			//*[@id="bundle-option-84"]
			//*[@id="product-options-wrapper"]/dl/dd/div
			//*[@id="bundle-option-15"]
			Select oSelect3 = new Select(driver.findElement(By.id(a.getAttribute("id"))));
			oSelect3.selectByIndex(1);
			System.out.println("Size is Seleceted");

			//*[@id="product_addtocart_form"]/div[3]/div[7]/div[2]/div[3]/button
			addCart=driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[3]/div[7]/div[2]/div[3]/button"));
			WebDriverWait waitForAddCart= new WebDriverWait(driver, 50);
			waitForAddCart.until(ExpectedConditions.visibilityOf(addCart));
			//			if(waitForAddCart.until(ExpectedConditions.visibilityOf(addCart)).equals(true))
			//			{
			System.out.println("inside if instock");
			addCart.click();
			System.out.println("Add to Cart is clicked");

			//CHECKOUT
			//*[@id="header-cart"]/div[3]/div[3]/div/a[1]/span
			WebDriverWait waitForCheckOut= new WebDriverWait(driver, 50);
			waitForCheckOut.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-cart']/div[3]/div[3]/div/a[1]/span"))).click();
			System.out.println("CheckOut is clicked");
		}
		else if(randomLink==LinksString.get(1))
		{
			System.out.println("Page title is: " + driver.getTitle());

			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			//System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 50);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));
			System.out.println("Random product getText is "+randomProduct.getText());
			System.out.println("Random product getAttribute title is "+randomProduct.getAttribute("class"));
			//randomProduct.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(randomProduct).click().perform();
			System.out.println("Random product is clicked");

			//String a=randomProduct.getAttribute("class");
			WebElement a=driver.findElement(By.cssSelector(".bundle-option.option-Size"));//*[@id="product-options-wrapper"]/dl/dd/div
			System.out.println(a.getText());
			System.out.println("id is "+a.getAttribute("id"));
			System.out.println("class is "+a.getAttribute("class"));
			System.out.println("name is "+a.getAttribute("name"));
			System.out.println("Tagname is "+a.getTagName());

			//*[@id="bundle-option-87"]
			//*[@id="bundle-option-84"]
			//*[@id="product-options-wrapper"]/dl/dd/div
			//*[@id="bundle-option-15"]
			Select oSelect3 = new Select(driver.findElement(By.id(a.getAttribute("id"))));
			oSelect3.selectByIndex(1);
			System.out.println("Size is Seleceted");

			//*[@id="product_addtocart_form"]/div[3]/div[7]/div[2]/div[3]/button
			addCart=driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[3]/div[7]/div[2]/div[3]/button"));
			WebDriverWait waitForAddCart= new WebDriverWait(driver, 50);
			waitForAddCart.until(ExpectedConditions.visibilityOf(addCart));
			//			if(waitForAddCart.until(ExpectedConditions.visibilityOf(addCart)).equals(true))
			//			{
			System.out.println("inside if instock");
			addCart.click();
			System.out.println("Add to Cart is clicked");

			//CHECKOUT
			//*[@id="header-cart"]/div[3]/div[3]/div/a[1]/span
			WebDriverWait waitForCheckOut= new WebDriverWait(driver, 50);
			waitForCheckOut.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-cart']/div[3]/div[3]/div/a[1]/span"))).click();
			System.out.println("CheckOut is clicked");
		}
		else if(randomLink==LinksString.get(2))
		{
			System.out.println("Page title is: " + driver.getTitle());

			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			//System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 100);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));
			System.out.println("Random product getText is "+randomProduct.getText());
			System.out.println("Random product getAttribute title is "+randomProduct.getAttribute("class"));
			//randomProduct.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(randomProduct).click().perform();
			System.out.println("Random product is clicked");

			//String a=randomProduct.getAttribute("class");
//			WebElement a=driver.findElement(By.cssSelector(".bundle-option.option-Size"));//*[@id="product-options-wrapper"]/dl/dd/div
//			System.out.println(a.getText());
//			System.out.println("id is "+a.getAttribute("id"));
//			System.out.println("class is "+a.getAttribute("class"));
//			System.out.println("name is "+a.getAttribute("name"));
//			System.out.println("Tagname is "+a.getTagName());

			//*[@id="bundle-option-87"]
			//*[@id="bundle-option-84"]
			//*[@id="product-options-wrapper"]/dl/dd/div
			//*[@id="bundle-option-15"]
			Select oSelect3 = new Select(driver.findElement(By.xpath("//*[@id='attribute133']")));
			oSelect3.selectByIndex(1);
			System.out.println("Size is Seleceted");

			//*[@id="product_addtocart_form"]/div[3]/div[7]/div[2]/div[3]/button
			//*[@id="product_addtocart_form"]/div[3]/div[5]/div[2]/div[4]/button
			addCart=driver.findElement(By.xpath("//*[@id='product_addtocart_form']/div[3]/div[5]/div[2]/div[4]/button"));
			WebDriverWait waitForAddCart= new WebDriverWait(driver, 50);
			waitForAddCart.until(ExpectedConditions.visibilityOf(addCart));
			//			if(waitForAddCart.until(ExpectedConditions.visibilityOf(addCart)).equals(true))
			//			{
			System.out.println("inside if instock");
			addCart.click();
			System.out.println("Add to Cart is clicked");

			//CHECKOUT
			//*[@id="header-cart"]/div[3]/div[3]/div/a[1]/span
			//*[@id="header-cart"]/div[3]/div[3]/div/a[1]/span
			WebDriverWait waitForCheckOut= new WebDriverWait(driver, 50);
			waitForCheckOut.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header-cart']/div[3]/div[3]/div/a[1]/span"))).click();
			System.out.println("CheckOut is clicked");
		}
		else if(randomLink==LinksString.get(3))
		{
			System.out.println("Page title is: " + driver.getTitle());

			//SELECT A RANDOM PRODUCT
			List<WebElement> allProducts = driver.findElements(By.cssSelector("a.product-image"));
			System.out.println("print the allProducts total size "+allProducts.size());
			System.out.println("print the allProducts "+allProducts);
			//System.out.println("print the allProducts.size() "+allProducts.size());
			Random random2 = new Random();
			WebElement randomProduct = allProducts.get(random2.nextInt(allProducts.size()));

			WebDriverWait waitForRandomProduct= new WebDriverWait(driver, 100);
			waitForRandomProduct.until(ExpectedConditions.visibilityOf(randomProduct));
			System.out.println("Random product getText is "+randomProduct.getText());
			System.out.println("Random product getAttribute title is "+randomProduct.getAttribute("class"));
			//randomProduct.click();
			Actions actions = new Actions(driver);
			actions.moveToElement(randomProduct).click().perform();
			System.out.println("Random product is clicked");
			System.out.println("BOOK YOUR APPOINTMENT");
			driver.quit();
			System.exit(0);
			
			
		}
	
		//FILL IN THE BILLING INFORMATION
		driver.findElement(By.xpath("//*[@id='billing:firstname']")).sendKeys("test");
		System.out.println("First Name is Enterd");

		driver.findElement(By.xpath("//*[@id='billing:lastname']")).sendKeys("test");
		System.out.println("Last Name is Enterd");
		//*[@id="billing:email"]
		//*[@id="bill_form"]/div[2]/div[1]/input
		driver.findElement(By.xpath("//*[@id='bill_form']/div[2]/div[1]/input")).sendKeys("test@gmail.com");
		System.out.println("Email is Enterd");

		//*[@id="billing:confirm_email"]
		driver.findElement(By.xpath("//*[@id='billing:confirm_email']")).sendKeys("test@gmail.com");
		System.out.println("Email is confirmed");

		driver.findElement(By.xpath("//*[@id='billing:street1']")).sendKeys("test");
		System.out.println("Street 1 is Enterd");

//		driver.findElement(By.xpath("//*[@id='billing:street2']")).sendKeys("test");
//		System.out.println("Street 2 is Enterd");

		//driver.findElement(By.xpath("//*[@id='billing:region']")).sendKeys("test");
		//System.out.println("Region is Enterd");
		//driver.findElement(By.xpath("//*[@id='billing:postcode']")).sendKeys("test");
		//System.out.println("Billing postcode is Enterd");

		//Select oSelect2 = new Select(driver.findElement(By.xpath("//*[@id='billing:country_id']")));
		//oSelect2.selectByVisibleText("PAKISTAN");

		Select oSelect3 = new Select(driver.findElement(By.xpath("//*[@id='billing:city']")));
		oSelect3.selectByIndex(3);
		System.out.println("City is Enterd");

		driver.findElement(By.xpath("//*[@id='billing:telephone']")).sendKeys("03001234567");
		System.out.println("Telephone is Enterd");

		driver.findElement(By.xpath("//*[@id='tel2']")).sendKeys("03001234567");
		System.out.println("Telephone is Confirmed");

		//*[@id="shipping:same_as_billing"]
		driver.findElement(By.xpath("//*[@id='shipping:same_as_billing']")).click();
		System.out.println("Shipping to this address is clicked");

		//SELECT CASH ON DELEIVERY
		//*[@id="p_method_cashondelivery"]
//		driver.findElement(By.xpath("//*[@id='p_method_cashondelivery']")).click();
//		System.out.println("Cash on Delivery is Clicked");

		//PLACE ORDER
		WebDriverWait wait3 = new WebDriverWait(driver, 200);
		//*[@id="review-buttons-container"]/button
		//*[@id="review-buttons-container"]/button
		wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='review-buttons-container']/button")));
		driver.findElement(By.xpath("//*[@id='review-buttons-container']/button")).click();
		System.out.println("Place Order Now Button is Clicked");
	}
}
