package bb.testa.testb.addressbook.tests;

import bb.testa.testb.addressbook.model.GroupData;
import bb.testa.testb.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().list().size()==0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("edit2test3");
        app.group().modify(group);
        Groups after = app.group().all();
        assertThat(after.size() , equalTo(before.size()));

        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    }

}
