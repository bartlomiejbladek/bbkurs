package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;


  @Test
  public void testAddUser() throws Exception {
    List<ContactData> before = app.contact().list();
    app.goTo().addUserPage();
    ContactData contact = new ContactData().withFirstname("FirstnTestBB").withLastname("LastnTest").withGroup("test1");
    app.contact().create(contact, true);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byID = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);

  }
}
