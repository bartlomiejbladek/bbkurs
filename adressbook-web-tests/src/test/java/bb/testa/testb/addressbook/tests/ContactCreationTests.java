package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.Contacts;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;


  @Test
  public void testAddUser() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().addUserPage();
    ContactData contact = new ContactData().withFirstname("FirstnTestBB").withLastname("ZZLastnTest").withGroup("test1");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo( before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
}
