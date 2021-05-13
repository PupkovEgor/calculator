package Package;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SummerHouseTest {
SummerHouse dom;

@Before
public void before() {
dom = new SummerHouse();
dom.setKolE(4);
dom.setLenght(3);
}


@Test
public void test() {
assertEquals("4",Integer.toString(dom.getKolE()));
assertEquals("3.0", Double.toString(dom.getLenght()));
}

}