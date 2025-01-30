package baseclass;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	private static BaseClass baseclass;
	@Getter
    private static WebDriver driver;

	private BaseClass(String browserName) throws InterruptedException {
		switch (browserName.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				new ChromeDriver();
				driver.manage().window().maximize();
				Thread.sleep(5000);
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				Thread.sleep(5000);
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				Thread.sleep(5000);
				break;
		}
	}

	public static void openPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public static BaseClass getBaseCllass(String browserName) throws InterruptedException {
		if (baseclass == null) {
			baseclass = new BaseClass(browserName);
		}
		return baseclass;
	}
}
