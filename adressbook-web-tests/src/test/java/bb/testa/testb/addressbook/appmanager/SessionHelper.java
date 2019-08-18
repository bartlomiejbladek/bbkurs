package bb.testa.testb.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {
    //public WebDriver wd;

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userName, String password) {
        type(By.name("user"),userName);
        //wd.findElement(By.id("LoginForm")).click();
        type(By.name("pass"),password);
        click(By.xpath("//input[@value='Login']"));
        //wd.findElement(By.xpath("//body")).click();
    }

}
