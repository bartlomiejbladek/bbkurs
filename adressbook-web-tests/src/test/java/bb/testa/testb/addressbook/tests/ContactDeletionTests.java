package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().toDeletion(index);
        app.goTo().acceptDeletion();
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}
