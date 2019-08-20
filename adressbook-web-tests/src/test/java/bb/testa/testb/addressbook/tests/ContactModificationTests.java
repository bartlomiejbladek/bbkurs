package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.AddUserData;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() throws InterruptedException {


        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoGroupPage();
            if (! app.getGroupHelper().isThereAGroup()){
                app.getNavigationHelper().gotoGroupPage();
                app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
            }
            app.getNavigationHelper().gotoAddUserPage();
            app.getContactHelper().createContact(new AddUserData("FirstnTest", "LastnTest", null, null, "emailtest", "test1"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillAddUserForm(new AddUserData("FirstnTest", "LastnTest", null, "123123123", "emailtest", null),false);
        app.getContactHelper().submitUpdateUser();
        app.getContactHelper().returnToHomePage();

    }
}
