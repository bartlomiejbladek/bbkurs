package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.GroupData;
import org.testng.annotations.*;

public class AddGroupsTests extends TestBase {

  @Test
  public void testAddGroups() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
  }

}
