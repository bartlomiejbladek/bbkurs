package bb.testa.testb.addressbook.appmanager;

import bb.testa.testb.addressbook.model.AddUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper {
    private FirefoxDriver wd;

    public ContactHelper(FirefoxDriver wd) {
        this.wd = wd;
    }

    public void fillAddUserForm(AddUserData addUserData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(addUserData.getFirstname());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(addUserData.getLastname());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(addUserData.getAddress());
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(addUserData.getMobile());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(addUserData.getEmail());
    }
    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void submitAddUser() {
        wd.findElement(By.name("submit")).click();
    }

    public void initContactModification() {
        wd.findElement(By.xpath("//img[@alt='Edit']")).click();

    }
    public void submitUpdateUser(){
        wd.findElement(By.name("update")).click();
    };

    public void selectDelationCheckbox() {
        wd.findElement(By.xpath("//td/input")).click();
    }


    public void delationConfirmation() {
        wd.findElement(By.xpath("//input[@value='Delete']")).click();

    }
}
