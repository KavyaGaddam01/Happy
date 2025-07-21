package Demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream("C:\\Users\\QSP\\Documents\\M78.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Demo");
		
            int rowCount = sh.getLastRowNum();
		
            System.out.println(rowCount);
		wb.close();
		
	}

}
