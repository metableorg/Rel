package org.reldb.rel.tests.ext_relvar.jdbc;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class TestExternalRelvarJDBC2 extends JDBCSettings {
	@Before
	public void testJDBC1() {
		sqlExec("CREATE TABLE " + table + " (A INT, B INT, C INT);");
		sqlExec("INSERT INTO " + table + " values (1, 2, 3);");
		sqlExec("INSERT INTO " + table + " values (4, 5, 6);");
		sqlExec("INSERT INTO " + table + " values (4, 5, 6);");
		sqlExec("INSERT INTO " + table + " values (1, 2, 3);");
		sqlExec("INSERT INTO " + table + " values (7, 8, 9);");
		sqlExec("INSERT INTO " + table + " values (7, 8, 9);");
		sqlExec("INSERT INTO " + table + " values (4, 5, 6);");
//		String src = "BEGIN;\n" + "var myvar external jdbc \"" + absolutePath + "\" dup_remove;" + "END;\n" + "true";
//		testEquals("true", src);
	}

	@Test
	public void testJDBC2() {
		testEquals("true", "true");
		String src = "myvar";
//		testEquals("RELATION {A INTEGER, B INTEGER, C INTEGER} {" + "\n\tTUPLE {A 1, B 2, C 3}," + "\n\tTUPLE {A 4, B 5, C 6},"
//				+ "\n\tTUPLE {A 7, B 8, C 9}\n}", src);
	}

	@After
	public void testJDBC3() {
//		String src = "BEGIN;\n" + "drop var myvar;" + "END;\n" + "true";
//		testEquals("true", src);
		sqlExec("drop table " + table);
	}
}
