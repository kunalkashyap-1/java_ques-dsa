package ctci.reccursion;

import java.util.Arrays;

public class sort_recc {
    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 2, 89, 7, 9};
//        bubble_recc(arr, 0, arr.length - 1);
//        select_recc(arr,0, arr.length,0);
//        System.out.println(Arrays.toString(merge_recc(arr)));
        merge_reccInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }

    static void bubble_recc(int[] arr, int n, int i) {
        if (i == 1) return;
        if (n < i) {
            if (arr[n] > arr[n + 1]) {
                int temp = arr[n];
                arr[n] = arr[n + 1];
                arr[n + 1] = temp;
            }
            bubble_recc(arr, n + 1, i);
        } else {
            bubble_recc(arr, 0, --i);
        }
    }

    static void select_recc(int[] arr, int p, int l, int max) {
        if(l == 0) return;
        if(p<l){
            if(arr[p] > arr[max]){
                select_recc(arr,p+1,l,p);
            }else{
                select_recc(arr,p+1,l,max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[l-1];
            arr[l-1] = temp;
            select_recc(arr,0,l-1,0);
        }
    }

    static int[] merge_recc(int[] arr){
        if(arr.length == 1) return arr;

        int mid = arr.length/2;
        int[] left = merge_recc(Arrays.copyOfRange(arr,0,mid));
        int[] right = merge_recc(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    static int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length +right.length];
        int i=0,j=0,k=0;

        while(i<left.length && j< right.length){
            if(left[i]<right[j]){
                merged[k] = left[i];
                i++;
            }else{
                merged[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length){
            merged[k] = left[i];
            i++;
            k++;
        }

        while(j< right.length){
            merged[k] =right[j];
            j++;
            k++;
        }
        return merged;
    }

    static void merge_reccInPlace(int[] arr, int s, int e){
        if(e-s == 1) return;

        int mid = (s+e)/2;
        merge_reccInPlace(arr,s,mid);
        merge_reccInPlace(arr,mid,e);

        mergeInPlace(arr,s,mid,e);
    }

    static void mergeInPlace(int[] arr,int s, int mid, int e){
        int[] merged = new int[e-s];
        int i=s,j=mid,k=0;

        while(i<mid && j< e){
            if(arr[i]<arr[j]){
                merged[k] = arr[i];
                i++;
            }else{
                merged[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<mid){
            merged[k] = arr[i];
            i++;
            k++;
        }

        while(j< e){
            merged[k] =arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < merged.length; l++) {
            arr[s+l] = merged[l];
        }
    }
}
