package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;


  @Test
  public void testAddUser() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddUserPage();
      ContactData contact = new ContactData("FirstnTest", "LastnTest", null, "123123123", "emailtest", null);
      app.getContactHelper().createContact(new ContactData("FirstnTest", "LastnTest", null, null, "emailtest", "test1"), true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max = 0;
    for (ContactData c : after){
        if (c.getId() > max){
            max = c.getId();
        }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));


  }
}
