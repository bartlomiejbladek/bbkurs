package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.Contacts;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.db().contacts().size() == 0) {
            app.goTo().groupPage();
            if (app.db().groups().size() == 0) {
                app.goTo().groupPage();
                app.group().create(new GroupData().withName("test1"));
            }
            app.goTo().addUserPage();
            app.contact().create(new ContactData().withFirstname("FirstnTest").withLastname("LastnTest"), true);
        }
    }


    @Test
    public void testContactDeletion() throws InterruptedException {

        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        int index = before.size() - 1;
        app.contact().toDeletion(deletedContact);
        app.goTo().acceptDeletion();
        assertThat(app.contact().count(), equalTo( before.size() - 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(deletedContact)));
        VerifyContactListInUi();
    }


}
