package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.GroupData;
import bb.testa.testb.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size()==0){
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupDeletion() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    assertThat(app.group().count(), equalTo( before.size() - 1));
    Groups after = app.group().all();
    assertThat(after.size() , equalTo(before.size() - 1));

    assertThat(after, equalTo(before.withOut(deletedGroup)));
  }

}
