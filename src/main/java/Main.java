import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        BalanceVerificator test = new BalanceVerificator();

        Scanner in = new Scanner(System.in);

        System.out.println("Input only brackets - (, [, {, }, ], )");
        System.out.print("Input: ");
        System.out.println( test.verificator(in.next()) );


    }
}
