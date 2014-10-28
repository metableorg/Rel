package ca.mb.armchair.rel3.plugins.tests.CSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ca.mb.armchair.rel3.tests.BaseOfTest;

public class TestExternalRelvarCSV2 extends BaseOfTest {
	
	private final String path = "Database"+File.separator+"test.csv";
	private File file = new File(path);
	
	@Before
	public void testCSV1() {
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			fw.write("A,B,C\n" + "1,2,3\n" + "4,5,6\n" + "4,5,6\n" + "1,2,3\n" + "7,8,9\n" + "7,8,9\n" + "4,5,6\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String src = 
				"BEGIN;\n" +
						"var myvar external csv \"" + file.getAbsolutePath() + "\" dup_remove;" +
				"END;\n" +
				"true";
		testEquals("true", src);
	}
	
	@Test
	public void testCSV2() {
		String src = "myvar";		
		testEquals(	"RELATION {A CHARACTER, B CHARACTER, C CHARACTER} {" +
					"\n\tTUPLE {A \"1\", B \"2\", C \"3\"}," +
					"\n\tTUPLE {A \"4\", B \"5\", C \"6\"}," +
					"\n\tTUPLE {A \"7\", B \"8\", C \"9\"}\n}", src);
	}
	
	@After
	public void testCSV3() {
		String src = 
				"BEGIN;\n" +
						"drop var myvar;" +
				"END;\n" +
				"true";
		file.delete();
		testEquals("true", src);
	}
}
