import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase {

  @Test(priority = 2)
  public void testCreateGroupLongName(){
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm("name", "header", "footer");
    submitGroupCreation();
    returnToGroupsPage();
    System.out.println("testCreateGroupLongName() passed");
  }
  @Test(priority = 1)
  public void testCreateGroupShortName(){
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm("n", "h", "f");
    submitGroupCreation();
    returnToGroupsPage();
    System.out.println("testCreateGroupShortName() passed");
  }
  @Test(priority = 3, enabled = true)
  public void testCreateGroupEmpty(){
    goToGroupsPage();
    initGroupCreation();
    fillGroupForm("", "", "");
    submitGroupCreation();
    returnToGroupsPage();
    System.out.println("testCreateGroupEmpty() passed");
  }


}
