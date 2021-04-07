package Package;

import static org.junit.Assert.*;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;



public class MainVisibleTest {
	
	Calculator tester = new Calculator();
	
	JButton testknopka;
	
	@Before
	public void testButton() {
	testknopka = tester.buttonCreate();
	}

	@Test
	public void test() {
	assertTrue(testknopka.getText() == "Выход");
	
	}

}
