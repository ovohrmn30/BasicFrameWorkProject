package data;

import utilities.Xls_Reader;

public class DataFiles {
	
	Xls_Reader d = new Xls_Reader("C:\\\\Testing\\\\NikulTest.xlsx");
    
   public String WrongPassword = d.getCellData("Data1", "Password", 2);
   public String WrongEmail = d.getCellData("Data1", "UserName", 3);
   public String EmailWithSpecialChar = d.getCellData("Data1", "UserName", 4);
   public String SpecialCharandWrongEmailPassword = d.getCellData("Data1", "Global Error", 8);
   public String EmptyEmail = d.getCellData("Data1", "Email Error", 8);
   public String EmptyPass = d.getCellData("Data1", "Password Error", 8);

}
