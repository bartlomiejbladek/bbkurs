package bb.testa.testb.sandbox;

import org.testng.annotations.*;


public class testGroupDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
