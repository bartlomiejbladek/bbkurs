package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.AddUserData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() throws InterruptedException {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillAddUserForm(new AddUserData("FirstnTest", "LastnTest", null, "123123123", "emailtest", null),false);
        app.getContactHelper().submitUpdateUser();
        app.getContactHelper().returnToHomePage();

    }
}
