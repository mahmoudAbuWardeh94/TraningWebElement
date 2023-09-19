import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementTest {
	public WebDriver driver;

	@BeforeTest()
	public void this_is_before_test() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void Textarea_practice() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Mahmoud");
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("0791402724");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("mahmoud.abuwardeh@nadsoft.net");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Mm1234560");
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("amman-mecca street");
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/button")).click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
	}

	@Test(priority = 2)
	public void Radio_Button_practice() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement radioBtnF = driver.findElement(By.id("female"));
		WebElement radtiBtnM = driver.findElement(By.id("male"));

		radioBtnF.click();
		System.out.println("============");
		boolean checkIfRadioBtnIsSelected = radioBtnF.isSelected();
		System.out.println(checkIfRadioBtnIsSelected);
		System.out.println("============");

	}

	@Test(priority = 3)
	public void CheckBox_practice() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// select specific checkbox

//		WebElement check=driver.findElement(By.xpath("//*[@id=\"monday\"]"));
//		check.click();
//		System.out.println("ISSS SELLEECTEDD");
//
//		System.out.println(check.isSelected());
//		System.out.println("ISSS SELLEECTEDD");
//
//		 select all checkboxes
//		 input[@type='checkbox' and @name='group2']"
//
		List<WebElement> checkBoxs = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains (@id,'day')]"));

		System.out.println("**********CheckBoxes******");
		System.out.println(checkBoxs.size());
		System.out.println("**********CheckBoxes******");

		for (int i = 0; i < checkBoxs.size(); i++) {

			checkBoxs.get(i).click();
			System.out.println(checkBoxs.get(i).getAttribute("id"));
		}

//		 Select multiple check boxes by choice
//		for (int k = 0; k < checkBoxs.size(); k++) {
//			String chName = checkBoxs.get(k).getAttribute("id");
//			if (chName.equals("mondayd") || chName.equals("sundayd")) {
//				checkBoxs.get(k).click();
//			}
//
//			else if (chName.equals("friday")) {
//				checkBoxs.get(k).click();
//			}
//		}
//

	}

	@Test(priority = 4)
	public void drop_down_list() {

		WebElement dropList = driver.findElement(By.className("custom-select"));
		Select dropDownList = new Select(dropList);
		dropDownList.selectByVisibleText("Finland");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.END);

	}

	@Test(priority = 5)
	public void upload_file() {

		
	}

}
