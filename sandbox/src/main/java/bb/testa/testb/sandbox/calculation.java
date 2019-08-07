package bb.testa.testb.sandbox;

public class calculation {

    private Point p1;
    private Point p2;


    public calculation (Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public double distanceMethod (){
        double odl;
        double odlx = 0;
        double odly = 0;

        odlx = this.p1.x - this.p2.x;
        odly = this.p1.y - this.p2.y;
        odl = Math.sqrt((odlx * odlx)+(odly * odly));
        return odl;

    }

}
