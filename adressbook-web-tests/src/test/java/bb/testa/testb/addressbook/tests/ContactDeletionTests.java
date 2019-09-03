package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        app.goTo().homePage();
        if (app.contact().list().size()==0){
            app.goTo().groupPage();
            if (app.group().list().size()==0){
                app.goTo().groupPage();
                app.group().create(new GroupData().withName("test1"));
            }
            app.goTo().addUserPage();
            app.contact().create(new ContactData().withFirstname("FirstnTest").withLastname("LastnTest"), true);
        }
    }


    @Test
    public void testContactDeletion() throws InterruptedException {

        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        int index = before.size() - 1;
        app.contact().toDeletion(deletedContact);
        app.goTo().acceptDeletion();
        Set<ContactData> after = app.contact().all();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }


}
