package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.Contacts;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

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
    public void testContactModification() throws InterruptedException {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("modFirstnTest").withLastname("modLastnTest")
                .withAddress("modAddress").withMobilePhone("123123123").withEmail("emailtest");
        //app.goTo().homePage();
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo( before.size()));
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));
    }


}
