package DSA_sheet.arrays;

public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(sort(arr, 0, arr.length-1));
    }

    static int sort(int[] arr, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = (start + end) / 2;
            count += sort(arr, start, mid);
            count += sort(arr, mid + 1, end);

            count += merge(arr, start, mid, end);
        }
        return count;
    }

    static int merge(int[] arr, int start, int mid, int end) {
        int count = 0;
        int[] temp = new int[end - start + 1];
        int left = start;
        int right = mid + 1;
        int k = 0;

        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                count += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (right <= end) {
            temp[k++] = arr[right++];
        }

        for (left = 0; left < temp.length; left++) {
            arr[left + start] = temp[left];
        }
        return count;
    }
}
