package ctci.backtracking;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count_daig(4, 4));
//        path("",4,4);
        path_diag("",4,4);
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);

        return left + right;
    }

    static int count_daig(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int down = count(r - 1, c);
        int diag = count(r - 1, c - 1);
        int right = count(r, c - 1);

        return down + diag + right;
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            path(p + "D", r - 1, c);
        }
        if (c > 1) {
            path(p + "R", r, c - 1);
        }
    }

    static void path_diag(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            path_diag(p + "V", r - 1, c);
        }
        if (r > 1 && c > 1) {
            path_diag(p + "D", r - 1, c - 1);
        }
        if (c > 1) {
            path_diag(p + "H", r, c - 1);
        }
    }
}
