package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;


  @Test
  public void testAddUser() throws Exception {
    app.getNavigationHelper().gotoAddUserPage();
    app.getContactHelper().createContact(new ContactData("FirstnTest", "LastnTest", null, null, "emailtest", "test1"), true);
  }
}
