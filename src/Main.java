import java.util.Scanner;

public class Main {
    public static void main(String[] args) {//we use static because we want to run the code without making an object of class demo
        System.out.println("Hello world!");
        Scanner input=new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hello "+name);
    }
}