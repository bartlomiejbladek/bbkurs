package bb.testa.testb.sandbox;

import org.testng.annotations.Test;

public class SquerTest {
    @Test
    public void testArea(){
        Squer s = new Squer(5);
        assert s.area() == 25;
    }
}
