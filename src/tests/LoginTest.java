package tests;

import org.testng.annotations.Test;

import data.DataFiles;
import pages.LoginPage;
import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
  
             WebDriver driver;
             LoginPage lp = new LoginPage();
             
             DataFiles dp = new DataFiles();
	
  @BeforeMethod
  public void beforeMethod() throws InterruptedException, IOException {
	  
	  lp.openBrowser();
	  lp.openLoginPage();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  lp.closebrowser();
	  
  }

   @Test
   public void LoginWithWrongEmailPasswordTest() throws InterruptedException {
	
	lp.login(dp.WrongEmail, dp.WrongPassword);
	
	
	
	Assert.assertEquals(dp.SpecialCharandWrongEmailPassword, lp.SpecialCharandWrongEmailPassword());
	
   }

   
   @Test
   public void LoginWithSpecialCharEmailTest() throws InterruptedException {
	
	 
	lp.login(dp.EmailWithSpecialChar, dp.WrongPassword);
	
	
	
	Assert.assertEquals(dp.SpecialCharandWrongEmailPassword, lp.SpecialCharandWrongEmailPassword());
	
	
	
	
}
   
   @Test
   public void LoginWithEmptyEmailTest() throws InterruptedException {
	
	lp.login(" ", dp.WrongPassword);
	
	
	
	Assert.assertEquals(dp.EmptyEmail, lp.EmptyEmail());
   }
   
   @Test
   public void LoginWithEmptyPassTest() throws InterruptedException {
	
	lp.login(dp.WrongEmail, " ");
	
	
	Assert.assertEquals(dp.EmptyPass,  lp.EmptyPass());
}
}