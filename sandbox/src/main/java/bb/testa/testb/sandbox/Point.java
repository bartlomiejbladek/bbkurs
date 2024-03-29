package bb.testa.testb.sandbox;

import java.sql.SQLOutput;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p2) {

        double odl;
        double odlx = 0;
        double odly = 0;

        odlx = this.x - p2.x;
        odly = this.y - p2.y;
        odl = Math.sqrt((odlx * odlx)+(odly * odly));

        return odl;

    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(-1, -2);
        p1.distance(p2);
        //calculation calc = new calculation(p1,p2);
        //calc.distanceMethod();
        //System.out.println("The distance between point p1 ( " + p1.x + " , " + p1.y  + " ) and point p2 ( " + p2.x + " , "+p2.y + " ) equals " + Point.distance(p1, p2));
        System.out.println("The distance between this points, calculated from method, also equals " + p1.distance(p2));

    }
}
