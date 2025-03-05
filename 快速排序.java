// 快速排序、快排
class Solution {
    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pivot = arr[low]; // 此时low闲置下来，可以被使用

        while(low < high){
            while(low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];

            while(low < high && arr[low] <= pivot)  low++;
            arr[high] = arr[low];       
        }

        arr[low] = pivot; //将枢轴元素存放到最终位置
        return low;
    }
}