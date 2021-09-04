package zuo.level3.class4;

/**
 * @author ： cxyxh
 * @date : 9/4/2021 11:50 AM
 * @describetion :归并排序
 */
public class Code01_MergeSort {


    // 归并排序
    public static void mergeSort1(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }


    // 归并递归
    public static void process(int[] nums, int L, int R) {
        if (R == L) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(nums, L, mid);
        process(nums, mid + 1, R);
        merge(nums, L, mid, R);
    }


    // 合并方法
    public static void merge(int[] nums, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[index++] = nums[p1] <= nums[p1] ? nums[p1++] : nums[p2++];
        }

        while (p1 <= mid) {
            help[index++] = nums[p1++];
        }

        while (p2 <= R) {
            help[index++] = nums[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[L + i] = help[i];
        }
    }


    // 非递归排序
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 步长
        int mergeSize = 1;
        while (mergeSize < N) { // log N
            // 当前左组的，第一个位置
            int L = 0;
            while (L < N) {
                // 如果
                if (mergeSize >= N - L) {
                    break;
                }
                int M = L + mergeSize - 1;
                // 为了防止越界和数组最右边角标做对比
                int R = M + Math.min(mergeSize, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止int溢出
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            //mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

}
