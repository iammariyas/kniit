package org.kniit.lab_3;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void withoutZero() throws Exception {
        int[] arr = {1, 1, 1, 1, 1};
        int[] result = {1, 1, 1, 1, 1};
        solution.duplicateZeros(arr);
        Assert.assertArrayEquals(result, arr);
    }

    @Test
    public void mixArrayTest() throws Exception {
        int[] arr = {0, 1, 2, 3, 4, 0};
        int[] res = {0, 0, 1, 2, 3, 4};
        solution.duplicateZeros(arr);
        Assert.assertArrayEquals(res, arr);
    }

    @Test
    public void normalArrayTest() throws Exception {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        int[] res = {1, 0, 0, 2, 3, 0, 0, 4};
        solution.duplicateZeros(arr);
        Assert.assertArrayEquals(res, arr);
    }

    @Test
    public void allZerosTest() throws Exception {
        int[] arr = {0, 0, 0, 0, 0};
        int[] result = {0, 0, 0, 0, 0};
        solution.duplicateZeros(arr);
        Assert.assertArrayEquals(result, arr);
    }

    @Test
    public void singleZeroTest() throws Exception {
        int[] arr = {0};
        int[] res = {0};
        solution.duplicateZeros(arr);
        Assert.assertArrayEquals(res, arr);
    }
    @Test
    public void emptyArrayTest() {
        int[] arr = {};
        Exception e = Assertions.assertThrows(Exception.class, () -> solution.duplicateZeros(arr));
        Assertions.assertEquals(
                "Ограничение на длину массива. Он должен быть в диапазоне 1 <= arr <= 10 ** 4",
                e.getMessage()
        );
    }

    @Test
    public void nullArrayTest() {
        int[] arr = null;
        Exception e = Assertions.assertThrows(Exception.class, () -> solution.duplicateZeros(arr));
        Assertions.assertEquals(
                "Массив не может быть null",
                e.getMessage()
        );
    }

    @Test
    public void bigArrayLenTest() {
        int SIZE = (int) (Math.pow(10, 4) + 1);
        int[] arr = new int[SIZE];
        Exception e = Assertions.assertThrows(Exception.class, () -> solution.duplicateZeros(arr));
        Assertions.assertEquals(
                "Ограничение на длину массива. Он должен быть в диапазоне 1 <= arr <= 10 ** 4",
                e.getMessage()
        );
    }

    @Test
    public void moreValueTest() {
        int[] arr = {1, 10, 2};
        Exception e = Assertions.assertThrows(Exception.class, () -> solution.duplicateZeros(arr));
        Assertions.assertEquals(
                "В массиве должны быть только цифры от 0 до 9",
                e.getMessage()
        );
    }

    @Test
    public void negativeDigitTest() {
        int[] arr = {1, -1, 2};
        Exception e = Assertions.assertThrows(Exception.class, () -> solution.duplicateZeros(arr));
        Assertions.assertEquals(
                "В массиве должны быть только цифры от 0 до 9",
                e.getMessage()
        );
    }

    // тесты для второй задачи
    @Test
    public void validMergeTest() throws Exception {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int[] res = {1, 2, 2, 3, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(res, nums1);
    }

    @Test
    public void allElFromFirstTest() throws Exception {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        int[] res = {1, 2, 3, 4, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(res, nums1);
    }

    @Test
    public void allElFromSecondTest() throws Exception {
        int[] nums1 = {10, 20, 30, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        int[] res = {4, 5, 6, 10, 20, 30};
        solution.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(res, nums1);
    }

    @Test
    public void arrayIsEmptySecondTest() throws Exception {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        int[] res = {1, 2, 3};
        solution.merge(nums1, 3, nums2, 0);
        Assert.assertArrayEquals(res, nums1);
    }

    @Test
    public void arrayIsEmptyFirstTest() throws Exception {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int[] res = {1};
        solution.merge(nums1, 0, nums2, 1);
        Assert.assertArrayEquals(res, nums1);
    }

    @Test
    public void withNegativeDigitTest() throws Exception {
        int[] nums1 = {-3, -1, 2, 0, 0, 0};
        int[] nums2 = {-2, 0, 4};
        int[] res = {-3, -2, -1, 0, 2, 4};
        solution.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(res, nums1);
    }

    @Test
    public void allNegativeTest() throws Exception {
        int[] nums1 = {-10, -8, -5, 0, 0, 0};
        int[] nums2 = {-9, -7, -6};
        int[] res = {-10, -9, -8, -7, -6, -5};
        solution.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(res, nums1);
    }

    @Test
    public void arrIsZeroTest() throws Exception {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {};
        int[] expected = {1, 2, 3};
        solution.merge(nums1, 3, nums2, 0);
        Assert.assertArrayEquals(expected, nums1);
    }

    @Test
    public void WithDuplicatesTest() throws Exception {
        int[] nums1 = {1, 1, 1, 0, 0, 0};
        int[] nums2 = {1, 1, 1};
        int[] expected = {1, 1, 1, 1, 1, 1};
        solution.merge(nums1, 3, nums2, 3);
        Assert.assertArrayEquals(expected, nums1);
    }

    @Test
    public void nullNums1Test() {
        int[] nums2 = {1, 2, 3};
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(null, 3, nums2, 3));
        Assertions.assertEquals(
                "Массив не может быть null",
                e.getMessage()
        );
    }

    @Test
    public void nullNums2Test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 3, null, 3));
        Assertions.assertEquals(
                "Массив не может быть null",
                e.getMessage()
        );
    }

    @Test
    public void bothNullTest() {
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(null, 3, null, 3));
        Assertions.assertEquals(
                "Массив не может быть null",
                e.getMessage()
        );
    }

    @Test
    public void invalidNums1LenTest() {
        int[] nums1 = {1, 2, 3};  // длина 3, а должна быть m + n = 6
        int[] nums2 = {2, 5, 6};
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 3, nums2, 3));
        Assertions.assertEquals(
                "Длина nums1 должна быть m + n",
                e.getMessage()
        );
    }

    @Test
    public void invalidNums2LenTest() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5};  // длина 2, а должна быть n = 3
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 3, nums2, 3));
        Assertions.assertEquals(
                "Длина nums2 должна быть n",
                e.getMessage()
        );
    }

    @Test
    public void negativeMTest() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, -1, nums2, 3));
        Assertions.assertEquals(
                "m и n должны быть в диапазоне 0 <= m, n <= 200",
                e.getMessage()
        );
    }

    @Test
    public void negativeNTest() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 3, nums2, -1));
        Assertions.assertEquals(
                "m и n должны быть в диапазоне 0 <= m, n <= 200",
                e.getMessage()
        );
    }

    @Test
    public void totalLenTooLargeTest() {
        int[] nums1 = new int[300];
        int[] nums2 = new int[100];
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 200, nums2, 100));
        Assertions.assertEquals(
                "Общая длина массива должна быть в диапазоне 1 <= m + n <= 200",
                e.getMessage()
        );
    }

    @Test
    public void arrayEmptyTest() throws Exception {
        int[] nums1 = new int[0];
        int[] nums2 = new int[0];
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 200, nums2, 100));
        Assertions.assertEquals(
                "Общая длина массива должна быть в диапазоне 1 <= m + n <= 200",
                e.getMessage()
        );
    }

    @Test
    public void nums1ValueSmallTest() {
        int[] nums1 = {-1001, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 3, nums2, 3));
        Assertions.assertEquals(
                "элементы nums1 должны быть в диапазоне -1000 <= x <= 1000",
                e.getMessage()
        );
    }

    @Test
    public void nums2ValueSmallTest() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {-1001, 5, 6};
        Exception e = Assertions.assertThrows(Exception.class, () ->
                solution.merge(nums1, 3, nums2, 3));
        Assertions.assertEquals(
                "элементы nums2 должны быть в диапазоне -1000 <= x <= 1000",
                e.getMessage()
        );
    }

}
