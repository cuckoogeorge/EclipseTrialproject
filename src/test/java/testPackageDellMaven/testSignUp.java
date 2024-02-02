package testPackageDellMaven;

import java.io.IOException;

import org.testng.annotations.Test;

import basePackageDellMaven.BaseClass;
import pagePackageDellMaven.pageSignUp;
import utilities.Excelutils;

public class testSignUp extends BaseClass {
	@Test
	public void f() throws IOException, InterruptedException {

		pageSignUp ob = new pageSignUp(dr);
		ob.signUplinkHover();
		ob.signInButtonClick();
		/* Reading values from excel sheet and setting the values in SignUp Page */
		String xlName = "/Users/cuckoogeorge/Desktop/DellData.xlsx";
		String Sheet = "Sheet1";

		int rowCount = Excelutils.getRowCount(xlName, Sheet);
		for (int i = 1; i <= rowCount; i++) {
			String email = Excelutils.getCellValue(xlName, Sheet, i, 0);
			String password = Excelutils.getCellValue(xlName, Sheet, i, 1);
			ob.setValuesforSignInPage(email, password);
			Thread.sleep(2000);
		}
	}
}
