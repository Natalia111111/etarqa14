package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateGroupTest extends TestBase {

  @Test(priority = 2)
  public void testCreateGroupLongName(){
    app.goToGroupsPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("name", "header", "footer"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    int after = app.getGroupHelper().getGroupCount();
   // System.out.println("testCreateGroupLongName() passed");
    Assert.assertEquals(after, before+1);
  }
  @Test(priority = 1)
  public void testCreateGroupShortName(){
    app.goToGroupsPage();
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("n", "h", "f"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    int after = app.getGroupHelper().getGroupCount();
    System.out.println("testCreateGroupShortName() passed");
    Assert.assertEquals(after, before+1);
  }
  @Test(priority = 3, enabled = false)
  public void testCreateGroupEmpty(){
    app.goToGroupsPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    System.out.println("testCreateGroupEmpty() passed");
  }


}
