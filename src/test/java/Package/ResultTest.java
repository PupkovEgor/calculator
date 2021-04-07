package Package;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ResultTest {

	 String g[];

	@Before
	public void setUp() throws Exception {
		 g = new String[] {"10","10","6","2","1","PROMO15"};
		
	}
//changes 22
	@Test
	public void test() {
		assertEquals(Calculator.sobitie(g, false, false,"Черновая отделка", "Персональный"), "Итого: 9354250,00 руб." );
	}

}
