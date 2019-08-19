package bb.testa.testb.addressbook.appmanager;

import bb.testa.testb.addressbook.model.AddUserData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {
    //public WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddUserForm(AddUserData addUserData, boolean creation) {
        type(By.name("firstname"), addUserData.getFirstname());
        type(By.name("lastname"), addUserData.getLastname());
        type(By.name("address"), addUserData.getAddress());
        type(By.name("mobile"), addUserData.getMobile());
        type(By.name("email"), addUserData.getEmail());

        if (creation){
            new Select (wd.findElement(By.name("new_group"))).selectByVisibleText(addUserData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }





    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

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
