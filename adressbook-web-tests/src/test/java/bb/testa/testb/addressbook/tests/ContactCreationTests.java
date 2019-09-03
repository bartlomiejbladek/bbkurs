package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import java.util.Set;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;


  @Test
  public void testAddUser() throws Exception {
    Set<ContactData> before = app.contact().all();
    app.goTo().addUserPage();
    ContactData contact = new ContactData().withFirstname("FirstnTestBB").withLastname("ZZLastnTest").withGroup("test1");
    app.contact().create(contact, true);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);

  }
}
