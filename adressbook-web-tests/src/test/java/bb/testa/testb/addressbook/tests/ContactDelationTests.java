package bb.testa.testb.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDelationTests extends TestBase {

    @Test
    public void testContactDelation() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectDelationCheckbox();
        app.getContactHelper().delationConfirmation();
        app.getNavigationHelper().allertAccept();
        app.getNavigationHelper().gotoHomePage();
    }
}
