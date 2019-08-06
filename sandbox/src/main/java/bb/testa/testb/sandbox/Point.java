package bb.testa.testb.sandbox;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point p1, Point p2) {
        double odl;
        double odlx = 0;
        double odly = 0;

        odlx = p1.x - p2.x;
        odly = p1.y - p2.y;
        odl = Math.sqrt((odlx * odlx)+(odly * odly));

        return odl;

    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 5);
        System.out.println("Odległosć pomiędzy punktem p1 ( " + p1.x + " , " + p1.y  + " ) oraz punktem p2 ( " + p2.x + " , "+p2.y + " ) wynosi " + Point.distance(p1, p2));

    }
}
