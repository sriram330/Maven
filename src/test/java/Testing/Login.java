package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    static WebDriver driver;

    public WebDriver BrowserLaunch(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_(1)\\chromedriver.exe");
         driver = new ChromeDriver();

         return driver;
    }
    public void enterValue(WebElement elmnt, String strValue) throws InterruptedException {
        elmnt.click();
        elmnt.clear();
        wait(2);
        elmnt.sendKeys(strValue);
    }





}

