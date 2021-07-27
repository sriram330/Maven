package Testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class DataProviderClass extends Login{

    DataProviderClass a;

    public DataProviderClass(){
        PageFactory.initElements(driver,this);

    }
    @FindBy(how = How.ID, using = "txtUsername")
    protected WebElement userNameField;

    @FindBy(how = How.ID, using = "txtPassword")
    protected WebElement PasswordField;

    @DataProvider(name="logindetails")
    public Object [][] data(){
        return new Object[][]{
                {"sriram", "sriram123"},
                {"hello", "Hello12!2"},
                {"123+'?", "$%#^@&"}
        };
    }
    @BeforeClass
    public void sample(){
        Login hp = new Login();
        hp.BrowserLaunch();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }


    @Test(priority = 1, dataProvider = "logindetails")
    @Parameters({"username", "password"})
    public void enterCredentialsAndLogin(String username, String password)  {
        a = new DataProviderClass();
        a.userNameField.sendKeys(username);
        a.PasswordField.sendKeys(password);
        a.userNameField.clear();
        a.userNameField.clear();
    }
    @AfterClass
    public void TearDown() {
        driver.quit();
    }

}
