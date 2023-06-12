package stepDefinations;

import io.cucumber.java.en.When;
import xls.ShineXlsReader;

public class ParamWithExcelsteps {

    @When("^user enter valid cretialas as follows (.+)$")
    public void user_enter_valid_cretialas_as_follows(int rownum) throws Throwable {
    	ShineXlsReader xls=new ShineXlsReader("TestData.xlsx");
    	String name = xls.getCellData("Sheet1", 0, rownum);
    	String password = xls.getCellData("Sheet1", 1, rownum);
    	System.out.println("user entered user name as "+name+" and password as "+password);
    }
}
