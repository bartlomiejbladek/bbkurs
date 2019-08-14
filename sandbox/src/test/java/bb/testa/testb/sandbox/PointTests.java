package bb.testa.testb.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testPoint(){
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 5);
        assert p1.distance(p2) == 5 ;

    }
    @Test
    public void testPointdouble(){
        Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(3.0, 5.0);
        assert p1.distance(p2) == 4.47213595499958 ;

    }
    @Test
    public void testPointAssertEquals(){
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 5);
        Assert.assertEquals(p1.distance(p2), 5);
    }
    @Test
    public void testPointAssertFromZero(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
    }
    @Test
    public void testPointAssertMinusPoints(){
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, -2);
        Assert.assertEquals(p1.distance(p2), 3.605551275463989);
    }

}
