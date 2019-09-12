package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.Contacts;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;


  @Test
  public void testAddUser() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().addUserPage();
    File photo = new File("src/test/resources/minion1.png");
    ContactData contact = new ContactData().withFirstname("FirstnTestBB").withLastname("AAALastnTest").withGroup("test1").withPhoto(photo);
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo( before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
