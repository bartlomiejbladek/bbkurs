package bb.testa.testb.addressbook.appmanager;

import bb.testa.testb.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactHelper extends HelperBase {
    //public WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddUserForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());

        if (creation){
            new Select (wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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

    public void createContact(ContactData contact, boolean creation) {
        fillAddUserForm(contact, creation);
        submitAddUser();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//td/input"));
    }

    public int getContactCount() {
        return  wd.findElements(By.xpath("//tr[contains(@name,'entry')]")).size();
    }
}
