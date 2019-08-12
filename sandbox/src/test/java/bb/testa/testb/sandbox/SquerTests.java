package bb.testa.testb.sandbox;

import org.testng.annotations.Test;

public class SquerTests {

    @Test
    public void firstAreaTest(){
        Squer s = new Squer(5);
        assert s.area() == 25;
    }
}
