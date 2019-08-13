package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.tests.TestBase;
import org.testng.annotations.*;


public class testGroupDeletion extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.gotoGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage();
  }

}
