package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.AddUserData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() throws InterruptedException {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillAddUserForm(new AddUserData("FirstnTest1", "LastnTest1", "AdresTest1", "1231231231", "emailtest1"));
        app.getContactHelper().submitUpdateUser();
        app.getContactHelper().returnToHomePage();

    }
}
