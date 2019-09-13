package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.Contacts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  private WebDriver wd;

  /*
  @DataProvider
  public Iterator<Object[]> validContactsFromXML() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
    return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

   */

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.json"));
      StringBuilder json = new StringBuilder();
      String line = reader.readLine();
      while (line != null) {
        json.append(line);
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json.toString(), new TypeToken<List<ContactData>>(){}.getType());
      return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }




    @Test (dataProvider = "validContactsFromJson")
  public void testAddUser(ContactData contact) throws Exception {
    Contacts before = app.contact().all();
    app.goTo().homePage();
    app.goTo().addUserPage();
//    File photo = new File("src/test/resources/minion1.png");
//    ContactData contact = new ContactData().withFirstname("FirstnTestBB").withLastname("AAALastnTest").withGroup("test1").withPhoto(photo);
    app.contact().create(contact, true);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo( before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
