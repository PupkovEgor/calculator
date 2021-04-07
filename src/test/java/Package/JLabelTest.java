package Package;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

public class JLabelTest {
	
	JLabel l[];
	WinInfo wi;
	
	@Before
	public void test1() {
		l = new JLabel[4];
		wi = new WinInfo();
	}

	@Test
	public void test() {
		l = wi.infoIn(l);
		for (int i =0;i<4;i++) {
		assertNotNull(l[i].getText());
		}
	}

}
