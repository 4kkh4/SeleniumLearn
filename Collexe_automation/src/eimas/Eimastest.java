package eimas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Eimastest {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Master\\Selenium\\20220828\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.yahoo.com");
		
		driver.findElement(By.xpath("//*[@id=\"signin-main\"]/div[1]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/form/div[1]/div[3]/input")).sendKeys("kuwadhial");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();


	}

}
