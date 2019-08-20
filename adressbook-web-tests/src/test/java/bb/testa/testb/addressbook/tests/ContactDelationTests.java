package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.AddUserData;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class ContactDelationTests extends TestBase {

    @Test
    public void testContactDelation() throws InterruptedException {
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
        app.getContactHelper().selectDelationCheckbox();
        app.getContactHelper().delationConfirmation();
        app.getNavigationHelper().allertAccept();
        app.getNavigationHelper().gotoHomePage();
    }
}
