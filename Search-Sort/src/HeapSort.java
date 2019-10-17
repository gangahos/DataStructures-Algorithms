public class HeapSort {

  public static void heapSort(int[] nums) {
    int size = nums.length;
    //First build the heap
    //We iterate from first non leaf node go down to root
    // i.e 0th index
    for (int i = size/2-1; i>=0; i--) {
      heapify_down(nums, size, i);
      //heapifyIterative(nums, size, i);
    }

    //Now sort the array. The max element is at the root
    //swap it with the last element.
    //Now last element is at the root, so heapify the rooti.e 0th index
    for (int i = size-1; i>=0; i--) {
      int temp = nums[i];
      nums[i] = nums[0];
      nums[0] = temp;
      // max element is always at the root, need to heapify the root
      heapify_down(nums, i, 0);
      //heapifyIterative(nums, i, 0);

    }
  }

  public static void heapifyIterative(int[] arr, int size, int index) {
    while (index < size ) {
      int largest = index;
      int left = 2 * index + 1;
      int right = 2 * index + 2;

      if (left < size && arr[left] > arr[largest]) {
        largest = left;
      }

      if (right < size && arr[right] > arr[largest]) {
        largest = right;
      }

      if (largest != index) {
        int swap = arr[index];
        arr[index] = arr[largest];
        arr[largest] = swap;
        index = largest;
      } else {
        return;
      }
    }

  }

  public static void heapify_down(int[] arr, int size, int index) {
    int largest = index;
    int left = 2*index + 1;
    int right = 2*index + 2;

    if(left<size && arr[left] > arr[largest]) {
      largest = left;
    }

    if(right<size && arr[right] > arr[largest]) {
      largest = right;
    }

    if (largest != index) {
      int swap = arr[index];
      arr[index] = arr[largest];
      arr[largest] = swap;
      heapify_down(arr, size, largest);
    }

  }


  public static void main(String[] args) {
    //int[] unSorted = new int[]{12, 11, 13, 5, 6, 99, 5};
    int[] unSorted = new int[]{5,13,2,25,7,17,20,8,4};

    HeapSort hs = new HeapSort();
    hs.heapSort(unSorted);

    for (int w = 0; w < unSorted.length; w++) {
      System.out.print(unSorted[w] + " ");
    }
  }

}
