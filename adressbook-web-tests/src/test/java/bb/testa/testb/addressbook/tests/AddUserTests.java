package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.AddUserData;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class AddUserTests extends TestBase {
  private WebDriver wd;


  @Test
  public void testAddUser() throws Exception {
    app.getNavigationHelper().gotoAddUserPage();
    app.getContactHelper().fillAddUserForm(new AddUserData("FirstnTest", "LastnTest", "AdresTest", "123123123", "emailtest"));
    app.getContactHelper().submitAddUser();
    app.getContactHelper().returnToHomePage();
  }






}
