package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.ContactData;
import bb.testa.testb.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Task13testContactDetails extends TestBase {

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
    public void testTask13ContactDetails() throws InterruptedException {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        String contactDataFromDetailsPage = app.contact().infoFromDetailsPage(contact);

        assertThat(mergeEditData(contactInfoFromEditForm), equalTo(cleanDetailsPageData(contactDataFromDetailsPage)));

    }
    private String mergeEditData(ContactData contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),
                contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
                contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(Task13testContactDetails::cleanedEditFormData)
                .collect(Collectors.joining(""));
    }

    public static String cleanedEditFormData(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public static String cleanDetailsPageData(String phone) {
        return phone.replaceAll("\\s", "")
                .replaceAll("\n", "")
                .replaceAll("[-()]", "")
                .replaceAll("H:", "")
                .replaceAll("M:", "")
                .replaceAll("W:", "");
    }
}
