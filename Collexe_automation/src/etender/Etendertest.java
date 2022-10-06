package etender;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Etendertest {
	WebDriver driver;
	
	@Test (priority=1)
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Master\\Selenium\\20220828\\Chromedirver\\chromedriver_win32_106\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://app-plx-staging.azurewebsites.net");
		driver.manage().window().maximize();
		
		String ExpectedTitle = "AGORA Sourcing - DEV";
		String ActualTitle = driver.getTitle();
		System.out.println("The title of login page : "+ActualTitle);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
	}
	
	@Test (priority=2)
	public void login() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/app-root/ng-component/div/div/div/div[2]/div[2]/ng-component/div[1]/form/div[1]/input")).sendKeys("akkha@collexe.asia");
		driver.findElement(By.xpath("/html/body/app-root/ng-component/div/div/div/div[2]/div[2]/ng-component/div[1]/form/div[2]/input")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/app-root/ng-component/div/div/div/div[2]/div[2]/ng-component/div[1]/form/div[4]/button")).click();
		
		String ExpectedTitle = "AGORA Sourcing - DEV";
		String ActualTitle = driver.getTitle();
		System.out.println("The title of login page : "+ActualTitle);
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
//		driver.getTitle().contains("Dashboard");
		
	
	}
	
	public void accessRFX() throws InterruptedException {
		Thread.sleep(6000);
//		driver.findElement(By.xpath("//span[contains(text(),' RFX ')]")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_aside_menu\"]/ul/li[3]/div/ul/li[1]/a/span[2]")).click();
		driver.getTitle().contains("RFX Overview");
	}
	
	public void CreateEvent() throws InterruptedException {
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		driver.findElement(By.xpath("//button[contains(text(),' Event Name ')]")).click();
		driver.getTitle().contains("Event Creation");
		driver.findElement(By.xpath("//*[@id=\"voucherHeaderForm\"]/div[1]/div[2]/div/input")).sendKeys("Automated Testing-04102022-AM4");
		driver.findElement(By.xpath("//*[@id=\"voucherHeaderForm\"]/div[2]/div[1]/div/textarea")).sendKeys("Automated testing full (ideal) cycle until publish");
		driver.findElement(By.xpath("//*[@id=\"EventReason\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'LOGI - Logistics')]")).click();
		driver.findElement(By.xpath("//*[@id=\"termStatus\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Inactive')]")).click();
		driver.findElement(By.xpath("//*[@id=\"termStatus\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Active')]")).click();
		driver.findElement(By.xpath("//*[@id=\"Coordinator\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'MICHELLE KUEK - MIRZA@COLLEXE.ASIA')]")).click();
		driver.findElement(By.xpath("//*[@id=\"Coordinator\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'POON CHAI MING - AKKHA@COLLEXE.ASIA')]")).click();
//		driver.findElement(By.xpath("//*[@id=\"UserDelegation\"]")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//span[contains(text(),'MICHELLE KUEK - MIRZA@COLLEXE.ASIA')]")).click();
		
	
//      <Start Upon Publish>
		driver.findElement(By.xpath("//*[@id=\"voucherHeaderForm\"]/div[3]/div/div/label/span")).click();

		WebElement firstDatePicker = driver.findElement(By.id("p1"));
		js.executeScript("arguments[0].scrollIntoView(true);",firstDatePicker); 

//		<start date picker>
		Thread.sleep(1000);
		WebElement elementDate1 = firstDatePicker.findElement(By.xpath("span[@class='e-input-group e-control-wrapper e-datetime-wrapper']/child::span[2]"));
		Thread.sleep(1000);
		SetDatePicker1(elementDate1, "Friday, October 7, 2022");
		

//		<start date time picker>
		Thread.sleep(1000);
		WebElement elementTime1 = firstDatePicker.findElement(By.xpath("//*[@id=\"p1\"]/span/span[3]"));
		Thread.sleep(1000);
		SetTimePicker1(elementTime1, "11:30 PM");
		Thread.sleep(1000);
		
		WebElement secondDatePicker = driver.findElement(By.id("p2"));
		
//		<end date picker>
		Thread.sleep(1000);
		WebElement elementDate2 = secondDatePicker.findElement(By.xpath("span[@class='e-input-group e-control-wrapper e-datetime-wrapper']/child::span[2]"));
		Thread.sleep(1000);
		SetDatePicker2(elementDate2, "Monday, October 10, 2022");
		

//		<end date time picker>
		Thread.sleep(1000);
		WebElement elementTime2 = secondDatePicker.findElement(By.xpath("//*[@id=\"p2\"]/span/span[3]"));
		Thread.sleep(1000);
		SetTimePicker2(elementTime2, "11:50 PM");
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[3]/createcampaignoreventtempcomponent/div/div[1]/div[2]/div/div/div/div/div[1]/button")).click();
		
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[contains(text(),' Schedule Planner ')]")).click();
	}
	
	public void SetDatePicker1 (WebElement element, String time) {
		
		try {
			element.click();
			Thread.sleep(1000);
			WebElement datepicker1 = driver.findElement(By.id("p1_datepopup"));
			datepicker1.findElement(By.xpath("//span[@title='"+time+"']")).click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SetTimePicker1 (WebElement element, String time) {
		
		try {
			element.click();
			Thread.sleep(1000);
			WebElement timepicker1 = driver.findElement(By.id("p1_timepopup"));
			timepicker1.findElement(By.xpath("//li[@data-value='"+time+"']")).click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void SetDatePicker2 (WebElement element, String time) {
		
		try {
			element.click();
			Thread.sleep(1000);
			WebElement datepicker2 = driver.findElement(By.id("p2_datepopup"));
			datepicker2.findElement(By.xpath("//span[@title='"+time+"']")).click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void SetTimePicker2 (WebElement element, String time) {
		
		try {
			element.click();
			Thread.sleep(1000);
			WebElement timepicker2 = driver.findElement(By.id("p2_timepopup"));
			timepicker2.findElement(By.xpath("//li[@data-value='"+time+"']")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void EventPlanner() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[contains(text(),' Schedule Planner ')]")).click();
//		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[3]/createcampaignoreventtempcomponent/div/div[1]/div[2]/div/div/div/div/div[2]/button[1]")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"EventType\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'RFI')]")).click();
		driver.findElement(By.xpath("//*[@id=\"EventType\"]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'RFQ')]")).click();
		Thread.sleep(2000);
		//*[@id="kt_wrapper"]/div[3]/ng-component/div/div[2]/div/div/div[1]/div[2]/div/button[3]
		driver.findElement(By.xpath("//button[contains(text(),'Next >')]")).click();
		Thread.sleep(3000);
	}
	
	public void Channel() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[3]/ng-component/div/div[2]/div/div[2]/div[1]/div/div/label/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[3]/ng-component/div/div[2]/div/div[2]/div[1]/div/div/label/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-brand']")).click();
		Thread.sleep(1000);
	}

	public void Setup() throws InterruptedException {
//		<document>
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement fileUploader = driver.findElement(By.id("fileUpload"));
		js.executeScript("arguments[0].scrollIntoView(true);",fileUploader);
//		driver.findElement(By.xpath("//*[@id=\"fileUpload\"]/div/div[1]/span")).click();
		Thread.sleep(2000);
		
		WebElement upload = driver.findElement(By.xpath("//*[@id=\"fileUpload\"]/div/div[1]/span/input"));
		upload.sendKeys("E:\\Kerja\\Collexe\\EIMAS\\data\\Sample\\DUMMY.pdf");
		Thread.sleep(10000);

		js.executeScript("window.scrollBy(0,-500)","");

//		<Questionnaire>		
		driver.findElement(By.xpath("//*[@id=\"Survey-link\"]/span")).click();
		
//		<vendors>		
		driver.findElement(By.xpath("//*[@id=\"Participant-link\"]/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"Participant\"]/div/div[1]/div/div/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[3]/ng-component/participantlistmodal/div/div/div/div[2]/div[2]/div/base-list/div[1]/form/div/div[1]/div/div/div/input")).sendKeys("yana");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[3]/ng-component/participantlistmodal/div/div/div/div[2]/div[2]/div/base-list/div[1]/form/div/div[1]/div/div/div/span/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),' Yana company ')]")).click();
		driver.findElement(By.xpath("//*[@id=\"kt_wrapper\"]/div[3]/ng-component/participantlistmodal/div/div/div/div[2]/div[3]/button[2]")).click();
//		<confirm button>
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();

		
//		<Grading>
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"Grading-link\"]")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Publish')]")).click();
//		<confirm button>
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/button[1]")).click();
	}
	

	public static void main(String[] args) throws InterruptedException {
		Etendertest obj = new Etendertest();
		obj.launchbrowser();
		obj.login();
//		obj.accessRFX();
//		obj.CreateEvent();
//		obj.EventPlanner();
//		obj.Channel();
//		obj.Setup();
	
	}

} 
