package Testing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class Pojo  extends  Login{

    Pojo a;


    public Pojo(){
        PageFactory.initElements(driver,this);

    }

    @FindBy(how = How.ID, using = "txtUsername")
    protected WebElement userNameField;

    @FindBy(how = How.ID, using = "txtPassword")
    protected WebElement PasswordField;

    @FindBy(how = How.ID, using = "btnLogin")
    protected WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//a[@href='#'] [@id='welcome']")
    protected WebElement elmntUserName;

    @FindBy(how = How.ID, using = "menu_pim_viewMyDetails")
    protected WebElement btnMyInfo;

    @FindBy(how = How.XPATH, using = "//div[@class='personalDetails']//h1")
    protected WebElement headerPersonalInfo;





    @BeforeClass
    public void sample(){
        Login hp = new Login();
        hp.BrowserLaunch();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }


    @Test(priority = 1, dataProvider = "logindetails")
    @Parameters({"username", "password"})
    public void enterCredentialsAndLogin(String username, String password)  {
        a = new Pojo();
        a.userNameField.sendKeys(username);
        a.PasswordField.sendKeys(password);
        a.btnLogin.click();

    }



    @Test(priority = 2, enabled = false)
    public void verifyLoggedIn() {
        a = new Pojo();
        String charName = a.elmntUserName.getText();
        String newText = "Sriram";

        Assert.assertFalse(Boolean.parseBoolean(charName), newText);
    }

    @Test(priority = 3, enabled = false)
    public void clickInfo(){
        a = new Pojo();
        a.btnMyInfo.click();
    }

    @Test(priority = 4, enabled = false)
    public void verifyHeader(){
        a = new Pojo();
      if (a.headerPersonalInfo.isDisplayed())
          System.out.println("Displayed");
      else
          System.out.println("Not displayed");
    }

    @AfterClass
    public void TearDown() {
        driver.quit();
    }


}
