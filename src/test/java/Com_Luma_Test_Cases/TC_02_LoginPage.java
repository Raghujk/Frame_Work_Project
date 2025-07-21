package Com_Luma_Test_Cases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com_Luma_Utilites.XL_Utiles;
import Com_Luma__Page_Objects.LUMA_LoginPage;

public class TC_02_LoginPage extends LUMA_BaseClass {
	
	public LUMA_LoginPage LP;
	@Test(dataProvider = "Luma_Data")
	public void LumaLoginPage(String Email , String pass) throws InterruptedException {
		
		LP=new LUMA_LoginPage(driver);
		LP.ClickOnSignin();
		LP.setEmail(Email);
		Thread.sleep(1000);
		LP.setpassword(pass);
		Thread.sleep(2000);
		LP.clicksigninbtn();
		LP.clearEmail();
		LP.clearpassword();
		
	}
	@DataProvider(name="Luma_Data")
	String [] []getData() throws IOException{
		//String Path=System.getProperty("user.dir")+"\\Com_Luma_Test_Data\\"+"Luma_Data.xlsx";
		String Path = "C:\\Users\\admin\\eclipse-workspace\\Frame_Work_Project\\src\\test\\java\\Com_Luma_Test_Data\\Luma_Data.xlsx";
		int rownum =XL_Utiles.GetRowCount(Path, "Sheet1");
		int cellnum =XL_Utiles.GetCellCount(Path, "Sheet1", 1);
		
		String LoginData [][] = new String[rownum][cellnum];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<cellnum;j++) {
				LoginData[i-1][j] =XL_Utiles.GetCellData(Path, "Sheet1", i , j);
				
			}
		}
		return LoginData;
	}

}
