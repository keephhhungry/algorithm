package zuo.level3.class5;

/**
 * @author ： cxyxh
 * @date : 9/5/2021 4:58 PM
 * @describetion :快速排序
 */
public class Code02_PartitionAndQuickSort {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // arr[L..R]上，以arr[R]位置的数做划分值
    // <= X > X
    // <= X X
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        // 小于区的边界
        int lessEqual = L - 1;
        int index = L;
        // 如果index 小于有边界
        while (index < R) {
            // 如果当前值小于等于最右侧的值
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            // 对比角标右移
            index++;
        }
        // 把最右侧的数与小于区的下一个数做交换
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }


    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    // <arr[R] ==arr[R] > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L >= R) {
            return new int[]{-1, -1};
        }
        // 小于区右边界
        int less = L - 1;
        // 大于区左边界(由于最后一个数字是拿来比较的，所以大于区的边界是R，而不是R-1)
        int more = R;
        int index = L;

        // 移动角标撞上大于区左边界的时候，循环停止
        while (index < more) {
            // 如果当前值和比较值相等，那么index++
            if (arr[index] == arr[R]) {
                index++;
                // 如果当前值 小于 比较值 那么当前值和小于区的下一个数做交换。index++
            } else if (arr[index] < arr[R]) {
                //swap(arr, less + 1, index);
                //less++;
                //index++;
                swap(arr, index++, ++less);
                // 如果当前值 大于 比较值 那么当前值和 大于区的下一个数做交换。
            } else {
                swap(arr, index, --more);
            }
        }
        // 最后交换最右侧的比较值
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    // 快速排序1.0 一次搞定一个数字
    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(arr, L, R);
        process1(arr, L, M);
        process1(arr, M + 1, L);
    }


    // 快速排序2.0 一次搞定一个区间的数组
    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    // arr[L...R] 排有序
    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = netherlandsFlag(arr, L, R);
        process1(arr, L, equalArea[0]);
        process1(arr, equalArea[1] + 1, R);
    }


    // 快速排序3.0 也就是市面上普遍意义上的快速排序(上面的1.0，2.0只是为了帮助理解，循序渐进)
    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    // 比较的数字随机选择
    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // 通过交换的方式随机选择最右侧的比较数字
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
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
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }
}
