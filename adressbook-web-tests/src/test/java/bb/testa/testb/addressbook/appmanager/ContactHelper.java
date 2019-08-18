package bb.testa.testb.addressbook.appmanager;

import bb.testa.testb.addressbook.model.AddUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {
    //public WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddUserForm(AddUserData addUserData) {
        type(By.name("firstname"), addUserData.getFirstname());
        type(By.name("lastname"), addUserData.getLastname());
        type(By.name("address"), addUserData.getAddress());
        type(By.name("mobile"), addUserData.getMobile());
        type(By.name("email"), addUserData.getEmail());
    }

    //private void type(By locator, String text) {
        //click(locator);
        //wd.findElement(locator).clear();
        //wd.findElement(locator).sendKeys(text);
    //}

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    //private void click(By locator) {
        //wd.findElement(locator).click();
    //}

    public void submitAddUser() {
        click(By.name("submit"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));

    }
    public void submitUpdateUser(){
        click(By.name("update"));
    };

    public void selectDelationCheckbox() {
        click(By.xpath("//td/input"));
    }


    public void delationConfirmation() {
        click(By.xpath("//input[@value='Delete']"));

    }
}
