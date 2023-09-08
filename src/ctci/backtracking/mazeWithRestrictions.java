package ctci.backtracking;

import java.util.ArrayList;

public class mazeWithRestrictions {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
//        System.out.println(pathWithRest("", maze, 0, 0));/
        System.out.println(pathWithRestBackTracking("", maze, 0, 0));
    }

    static ArrayList<String> pathWithRest(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if (!maze[r][c]) {
            return new ArrayList<String>();
        }
        ArrayList<String> list = new ArrayList<>();
        if (r < maze.length - 1) {
            list.addAll(pathWithRest(p + "V", maze, r + 1, c));
        }
        if (r < maze.length - 1 && c < maze[0].length - 1) {
            list.addAll(pathWithRest(p + "D", maze, r + 1, c + 1));
        }
        if (c < maze[0].length - 1) {
            list.addAll(pathWithRest(p + "H", maze, r, c + 1));
        }
        return list;
    }

    static ArrayList<String> pathWithRestBackTracking(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        if (!maze[r][c]) {
            return new ArrayList<String>();
        }
        maze[r][c] = false;
        ArrayList<String> list = new ArrayList<>();
        if (r < maze.length - 1) {
            list.addAll(pathWithRestBackTracking(p + "D", maze, r + 1, c));
        }
        if (c < maze[0].length - 1 ) {
            list.addAll(pathWithRestBackTracking(p + "R", maze, r, c + 1));
        }
        if (c-1 >= 0 ) {
            list.addAll(pathWithRestBackTracking(p + "L", maze, r, c - 1));
        }
        if (r-1 >= 0 ) {
            list.addAll(pathWithRestBackTracking(p + "U", maze, r - 1, c));
        }
        maze[r][c] = true;
        return list;
    }
}
