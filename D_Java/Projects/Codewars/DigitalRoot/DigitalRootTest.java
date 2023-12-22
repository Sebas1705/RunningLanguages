package DigitalRoot;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DigitalRootTest {
    @Test
    public void Test1() {
      assertEquals( "Nope!" , 7, DigitalRoot.digital_root(16));
    }      
    @Test
    public void Test2() {
      assertEquals( "Nope!" , 6, DigitalRoot.digital_root(456));
    }
}
