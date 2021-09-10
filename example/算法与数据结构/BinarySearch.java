package com.github.hcsp.reflection;

/**
 * @author Zhaofeng Zhou
 * @date 2021/9/8/008 10:51
 */
public class BinarySearch {

    private static int search(int[] arrays, int key) {
        int start = 0;
        int end = arrays.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (key > arrays[mid]) {
                start = mid + 1;
            } else if (key < arrays[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -(start + 1);
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 4, 6, 8, 9, 10, 45, 56};
        System.out.println(search(arrays, 56));
        System.out.println(search(arrays, 6));
        System.out.println(search(arrays, 100));
    }

}
