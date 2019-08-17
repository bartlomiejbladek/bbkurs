package bb.testa.testb.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {
    public WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
      wd.findElement(By.linkText("groups")).click();
    }
    public void gotoAddUserPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void allertAccept() {
        wd.switchTo().alert().accept();

    }
}
