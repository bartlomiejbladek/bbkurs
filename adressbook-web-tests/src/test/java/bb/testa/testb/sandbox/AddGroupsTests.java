package bb.testa.testb.sandbox;

import org.testng.annotations.*;

public class AddGroupsTests extends TestBase {

  @Test
  public void testAddGroups() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
