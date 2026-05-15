package org.kniit.lab_3;


public class Solution {
    public void duplicateZeros(int[] arr) throws Exception {
        if (arr == null) {
            throw new Exception("Массив не может быть null");
        }

        int n = arr.length;

        if (n < 1 || n > Math.pow(10, 4)) {
            throw new Exception("Ограничение на длину массива. Он должен быть в диапазоне 1 <= arr <= 10 ** 4");
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 || arr[i] > 9) {
                throw new Exception("В массиве должны быть только цифры от 0 до 9");
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = n - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                if ((i + 1) < n) {
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) throws Exception {
        int MAX_SIZE = (int) Math.pow(10, 3);
        if (nums1 == null || nums2 == null) {
            throw new Exception("Массив не может быть null");
        }
        if ((m < 0 || m > 200) || (n < 0 || n > 200)) {
            throw new Exception("m и n должны быть в диапазоне 0 <= m, n <= 200");
        }
        if (m + n < 1 || m + n > 200) {
            throw new Exception("Общая длина массива должна быть в диапазоне 1 <= m + n <= 200");
        }
        if (nums1.length != m + n) {
            throw new Exception("Длина nums1 должна быть m + n");
        }
        if (nums2.length != n) {
            throw new Exception("Длина nums2 должна быть n");
        }

        for (int i = 0; i < m; i++) {
            if (nums1[i] < -MAX_SIZE || nums1[i] > MAX_SIZE) {
                throw new Exception("элементы nums1 должны быть в диапазоне -1000 <= x <= 1000");
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums2[j] < -MAX_SIZE || nums2[j] > MAX_SIZE) {
                throw new Exception("элементы nums2 должны быть в диапазоне -1000 <= x <= 1000");
            }
        }

        int index1 = m - 1;
        int index2 = n -1;
        int index = m + n - 1;

        while (index >= 0 && index2 >= 0) {
            if (index1 >=0 && nums1[index1] > nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }
    }
}
