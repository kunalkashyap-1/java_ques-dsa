public class pattern {
    public static void main(String[] args) {
        pattern1(7);
        System.out.println();
        pattern2(7);
        pattern3(5);
        pattern4(5);
    }

    static void pattern1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int i = 1; i < 2*n; i++) {
            int totalCol=i>n?2*n-i:i;
            for (int k = 0; k < n - totalCol; k++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= totalCol; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
