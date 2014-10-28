package ca.mb.armchair.rel3.plugins.tests.XLS;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.mb.armchair.rel3.exceptions.ExceptionSemantic;
import ca.mb.armchair.rel3.tests.BaseOfTest;

public class TestExceptionsRelvarXLSX extends BaseOfTest {
	
	private final String path = "Database"+File.separator+"test.xlsx";
	private File file = new File(path);
	private File NonExistingFile = new File("Database"+File.separator+"test2.xlsx");
	
	@Before
	public void testXLSX1() {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			workbook.createSheet();
			file.createNewFile();
			FileOutputStream out = new FileOutputStream(file);
		    workbook.write(out);
		    out.close();
			NonExistingFile.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String src = 
				"BEGIN;\n" +
						"var myvar external xls \"" + file.getAbsolutePath() + "\" dup_remove;" +
				"END;\n" +
				"true";
		testEquals("true", src);
	}
	
	@Test //Relvar created from empty file
	public void testXLSX2() {
		String src = "myvar";		
		testEquals(	"RELATION {} {\n}", src);
	}
	
	@Test(expected = ExceptionSemantic.class)
	public void testXLSX3() { //Calling relvar after manually deleting file
		file.delete();
		String src = "myvar";		
		testEvaluate(src);
	}
	
	@Test(expected = ExceptionSemantic.class)
	public void testXLSX4() { //Creating relvar from non-existing file
		String src = 
				"BEGIN;\n" +
						"var brokenVAR external xls \"" + NonExistingFile.getAbsolutePath() + "\" dup_remove;" +
				"END;\n";
		testEvaluate(src);
	}
	
	@Test(expected = ExceptionSemantic.class)
	public void testXLSX5() { //Creating relvar with non-identified duplicate handling method
		String src = 
				"BEGIN;\n" +
						"var brokenVAR external xls \"" + file.getAbsolutePath() + "\" something;" +
				"END;\n";
		testEvaluate(src);
	}
	
	@After
	public void testXLSX10() { //Drop relvar and delete test file
		String src = 
				"BEGIN;\n" +
						"drop var myvar;" +
				"END;\n" +
				"true";
		file.delete();
		testEquals("true", src);
	}
}
