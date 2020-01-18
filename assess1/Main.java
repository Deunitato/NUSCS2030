public class Main{



    public static void main(String[] args) { 

        Try t = new Try(24000,0.10,0.00125);
        System.out.print(String.format("%.2f",t.compute(13)));
    }

}
