public class MySorts {

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int tempDate = arr[i];
                int j;
                for (j = i - 1; j >= 0 && arr[j] > tempDate; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = tempDate;
            }
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0, j = 0, minLocal = 0; i < arr.length; i++) {
            minLocal = i;
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minLocal]) {
                    minLocal = j;
                }
            }
            if (minLocal != i) {
                int tempDate = arr[i];
                arr[i] = arr[minLocal];
                arr[minLocal] = tempDate;
            }
        }
    }

    public static void quickSort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr) {
        mergeSortRecursive(arr, 0, arr.length);
    }


    // merge method
    // merge two sorted portions of given array arr, namely, from start to middle
    // and from middle + 1 to end into one sorted portion, namely, from start to end
    private static void merge(int[] arr, int start, int middle, int end) {
        int[] sorted = new int[end - start + 1];
        int i = start, j = middle;
        int k = 0;
        while (i < middle && j < end)
            if (arr[i] < arr[j])
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        while (i < middle)
            sorted[k++] = arr[i++];
        while (j < end)
            sorted[k++] = arr[j++];
        for (int v = 0; v < k; v++)
            arr[start + v] = sorted[v];
    }

    // merge sort recursive version
    // sort the portion of giving array arr, from begin to end
    private static void mergeSortRecursive(int[] arr, int begin, int end) {
        if (begin + 1 < end) {
            int mid = (begin + end) / 2;
            mergeSortRecursive(arr, begin, mid);
            mergeSortRecursive(arr, mid, end);
            merge(arr, begin, mid, end);
        }
    }

    // find pivot point for quick sort
    private static int pivot(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int pos = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (arr[i] <= pivot) {
                pos++;
                if (i != pos) {
                    int tem;
                    tem = arr[pos];
                    arr[pos] = arr[i];
                    arr[i] = tem;
                }
            }
        }
        int tem2;
        tem2 = arr[pos];
        arr[pos] = arr[begin];
        arr[begin] = tem2;
        return pos;
    }

    // quick sort recursive version
    // sort the portion of giving array arr, from begin to end
    private static void quickSortRecursive(int[] arr, int begin, int end) {
        if (begin < end) {
            int pos = pivot(arr, begin, end);
            quickSortRecursive(arr, begin, pos - 1);
            quickSortRecursive(arr, pos + 1, end);
        }
    }

}
