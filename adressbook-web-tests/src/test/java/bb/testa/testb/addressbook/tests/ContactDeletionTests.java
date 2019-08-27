package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws InterruptedException {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().gotoGroupPage();
            if (! app.getGroupHelper().isThereAGroup()){
                app.getNavigationHelper().gotoGroupPage();
                app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
            }
            app.getNavigationHelper().gotoAddUserPage();
            app.getContactHelper().createContact(new ContactData("FirstnTest", "LastnTest", null, null, "emailtest", "test1"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectDelationCheckbox();
        app.getContactHelper().delationConfirmation();
        app.getNavigationHelper().allertAccept();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before-1);
    }
}
