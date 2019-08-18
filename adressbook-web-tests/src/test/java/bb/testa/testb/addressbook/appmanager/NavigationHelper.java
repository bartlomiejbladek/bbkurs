package bb.testa.testb.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper extends HelperBase {
    //public WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
      click(By.linkText("groups"));
    }
    public void gotoAddUserPage() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("home")));
        click(By.linkText("home"));
    }

    public void allertAccept() {
        wd.switchTo().alert().accept();

    }
}
