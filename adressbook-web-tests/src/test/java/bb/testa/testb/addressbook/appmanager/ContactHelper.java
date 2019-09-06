package bb.testa.testb.addressbook.appmanager;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {
    //public WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddUserForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
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

    private void initContactModificationById(int id) {

        //wd.findElement(By.xpath("//a[contains(@href,'edit.php?id="+id + "')]")).click();
        //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id)));
        wd.findElement(By.cssSelector(("a[href='edit.php?id=") + id + "']")).click();

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

    private void selectDelationCheckboxById(int id) {
        wd.findElement(By.cssSelector(("input[value='") + id + "']")).click();
    }

    public void delationConfirmation() {
        click(By.xpath("//input[@value='Delete']"));

    }

    public void create(ContactData contact, boolean creation) {
        fillAddUserForm(contact, creation);
        submitAddUser();
        contactCache = null;
        returnToHomePage();
    }
    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillAddUserForm(contact,false);
        submitUpdateUser();
        contactCache = null;
        returnToHomePage();
    }


    public void toDeletion(int index) {
        selectDelationCheckbox(index);
        delationConfirmation();
    }
    public void toDeletion(ContactData contact) {
        selectDelationCheckboxById(contact.getId());
        delationConfirmation();
        contactCache = null;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//td/input"));
    }

    public int count() {
        return  wd.findElements(By.xpath("//tr[contains(@name,'entry')]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,'entry')]"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts;
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        //List<WebElement> elements = wd.findElements(By.xpath("//tr[contains(@name,'entry')]"));
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            /*
            String lastname = row.findElement(By.xpath(".//td[2]")).getText();
            String firstname = row.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("id"));

             */
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String[] phones = cells.get(5).getText().split("\n");
            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return new Contacts(contactCache);
    }
    /*
    public Set<ContactData> allData() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname = cells.get(2).getText();
            String[] phones = cells.get(5).getText().split("/n");
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]));
        }
        return contacts;
    }

     */
    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).
                withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

    }

}
