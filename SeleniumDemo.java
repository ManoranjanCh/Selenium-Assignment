package com.mano.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDemo {

		WebDriver driver;
		public void invokeBrowser() {
			try {
				//To run in Firefox Browser
				System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver.exe");
				driver = new FirefoxDriver();
				
				/*//To run in Chrome Browser
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
				driver = new ChromeDriver();
				//To run in InternetExplorer Browser
				System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();	*/			
				
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//Launch the URL
				driver.get("http://demosite.center/wordpress/wp-login.php");
				//To get the title of the Page
				String title = driver.getTitle();
				System.out.println("The Title of the page is "+title);
				
				//Login with Invalid credential and verify the error message
				driver.findElement(By.id("user_login")).sendKeys("admin");
				driver.findElement(By.id("user_pass")).sendKeys("demo12");     
				driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
				String message = driver.findElement(By.id("login_error")).getText();
				System.out.println("The error message is"+ message);
				   
				driver.navigate().back();
				Thread.sleep(5000);
				
				//Login with valid Credential
				driver.findElement(By.id("user_login")).sendKeys("admin");
			    driver.findElement(By.id("user_pass")).sendKeys("demo123");
				driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
				System.out.println("The title of the page After Login is"+driver.getTitle());
				
				driver.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
		public static void main(String[] args) {
			SeleniumDemo sd = new SeleniumDemo();
			sd.invokeBrowser();
	}

}
