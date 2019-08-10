package bb.testa.testb.sandbox;

public class BbFirstProgram1 {

    public static void main(String[] args) {
        hello("Bartek");
        hello("World");

        Squer s = new Squer(5);
        Rectangule r = new Rectangule(2,3);
        System.out.println("wynik " + s.l + "=" +s.area());
        System.out.println("prostokat ma pole = "+r.area() );


    }

    public static void hello(String somebody) {
        System.out.println("Hello " + somebody + " !!!");
    }


}