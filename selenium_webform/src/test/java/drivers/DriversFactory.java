package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriversFactory {

	protected static WebDriver driver;

	public static void iniciarDriver(String url) {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        }
        }

	public static void encerrarDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}
}
