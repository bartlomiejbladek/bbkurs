package bb.testa.testb.sandbox;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point x, Point y) {
        double odl = 0;
        odl += Math.pow(x.x - y.x, 2);
        odl += Math.pow(x.y - y.y, 2);
        return Math.sqrt(odl);
    }

    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(4, 5);
        System.out.println(Point.distance(a, b));

    }
}
