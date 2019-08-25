package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class AddGroupsTests extends TestBase {

  @Test
  public void testAddGroups() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", null));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size() , before.size() +1);

  }

}
