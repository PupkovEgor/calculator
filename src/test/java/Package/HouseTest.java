package Package;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class HouseTest {
	Otdelka otdelka;
	@Before
	public void before() {
		otdelka = new House();	
	}	
	@Test
	public void test() {
		double testValue1 = otdelka.OtdelkaPrice("Нет", 20, 1);
		double testValue2 = otdelka.OtdelkaPrice("Черновая отделка", 20, 1);
		double testValue3 = otdelka.OtdelkaPrice("Под ключ", 20, 1);	
		assertEquals("0.0",Double.toString(testValue1));
		assertEquals("100000.0",Double.toString(testValue2));
		assertEquals("200000.0",Double.toString(testValue3));
	}
}
