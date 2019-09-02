package bb.testa.testb.addressbook.appmanager;

import bb.testa.testb.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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

    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();

    }
    public void submitUpdateUser(){
        click(By.name("update"));
    };

    public void selectDelationCheckbox(int index) {
        wd.findElements(By.xpath("//td/input")).get(index).click();
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

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,'entry')]"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactData contact = new ContactData(id, firstname, lastname, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
