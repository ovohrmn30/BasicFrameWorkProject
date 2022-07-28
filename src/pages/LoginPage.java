package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//WebElement Id = driver.findElement(By.id("Username"));
	//WebElement Password = driver.findElement(By.id("Password"));
	//WebElement Login = driver.findElement(By.xpath("//input[@value='Log in']"));
	//WebElement SpecialCharandWrongEmailPassword = driver.findElement(By.xpath("//p[@class='text-danger']"));
	//WebElement EmptyEmail = driver.findElement(By.xpath("(//span[@class='text-danger'])[1]"));
	//WebElement EmptyPass = driver.findElement(By.xpath("(//span[@class='text-danger'])[2]")); 
	
	@FindBy (id = "Username" )
	public WebElement Id;
	
	@FindBy (id = "Password" )
	public WebElement Password;
	
	@FindBy (xpath = "//input[@value='Log in']" )
	public WebElement Login;
	
	@FindBy (xpath = "//p[@class='text-danger']" )
	public WebElement SpecialCharandWrongEmailPassword;
	
	@FindBy (xpath = "(//span[@class='text-danger'])[1]" )
	public WebElement EmptyEmail;
	
	@FindBy (xpath = "(//span[@class='text-danger'])[2]" )
	public WebElement EmptyPass;
	
	
public void openBrowser() throws IOException {
	
	FileInputStream f = new FileInputStream("C:\\Testing\\prop.properties");
	Properties prop = new Properties();
	prop.load(f);
	
	String browser = prop.getProperty("browser");
	System.out.println(browser);
	
	if(browser.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		driver = new FirefoxDriver();
	}else if (browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
		driver = new ChromeDriver();
	}else {
		System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
		driver = new SafariDriver();
	}
     PageFactory.initElements(driver, this);
	}

public void openLoginPage() {
	driver.get("https://online-testing.com/Account/Login"); // open Facebook
	  
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   
}

public void closebrowser() {
	
	driver.quit();
}

public void login(String a, String b) throws InterruptedException {
	
	Id.sendKeys(a);
	Password.sendKeys(b);
	Login.click();

Thread.sleep(3000);
}

public String SpecialCharandWrongEmailPassword() {
	
	String actualErr = SpecialCharandWrongEmailPassword.getText();
	System.out.println(actualErr);
	return actualErr;
}

public String EmptyEmail() {
	
	String actualErr = EmptyEmail.getText();
	System.out.println(actualErr);
	return actualErr;
}

public String EmptyPass() {
	
	String actualErr = EmptyPass.getText();
	System.out.println(actualErr);
	return actualErr;
}
}
