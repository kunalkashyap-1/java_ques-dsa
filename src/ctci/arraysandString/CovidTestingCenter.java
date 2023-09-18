package ctci.arraysandString;

public class CovidTestingCenter {
    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        int[] rooms = {1, 2, 3, 4, 7, 9};

        System.out.println(maxMiNCount(n, k, rooms));
    }

    static int maxMiNCount(int n, int k, int[] rooms) {
        int result = -1;
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 1;
            int currentRoom = rooms[0];

            // Try to set up rooms with at least the mid distance
            for (int room : rooms) {
                if (room - currentRoom >= mid) {
                    count++;
                    currentRoom = room;
                }
            }

            // If we can set up at least K rooms, update the result and move left
            if (count >= k) {
                result = mid;
                left = mid + 1;
            } else {
                // Otherwise, move right to decrease the minimum distance
                right = mid - 1;
            }
        }

        return result;
    }
}
