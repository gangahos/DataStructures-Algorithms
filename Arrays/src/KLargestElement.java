import java.util.Random;

/**
 * Finding the Kth kth largest element using Divide Conquer Logic.
 * Since we analyse only one half of the side, time complexity is
 * O(n)
 */

public class KLargestElement {
  public int findKthLargest(int[] arr, int left, int right, int k) {
    int n = arr.length;


    Random rand = new Random(0); //random pivot generator

    while (left <= right) {
      int randPivotpos = rand.nextInt(right - left + 1) + left;
      int pivotIndex = partition(arr, left, right, randPivotpos);
      System.out.println(pivotIndex);

      if (pivotIndex == n - k) {
        return arr[pivotIndex];
      } else if (pivotIndex > n - k) {
        //kth largest element must be in left side of the array
        //return findKthLargest(arr, left, pivotIndex - 1, k);
        right = pivotIndex - 1;
      } else {
        //return findKthLargest(arr, pivotIndex + 1, right, k);
        left = pivotIndex + 1;
      }
    }
    return -1;
  }

  public int partition(int[] arr, int left, int right, int randPivot) {
    // Grab the value at the pivot index we passed in
    int pivotValue = arr[randPivot];

    /*We keep track of the tail index of this section. We will
    need this later */
    int lesserItems = left;

    //Swap with element at the last index of the array
    swap(arr, randPivot, right);

    //Arrange the elements

    for (int j = left; j < right; j++) {
      if (arr[j] <= pivotValue) {
        swap(arr, j, lesserItems);
        lesserItems++;

      }
    }
    swap(arr, right, lesserItems);
    return lesserItems;
  }

  private void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{12, 3, 5, 7, 4, 19, 26};
    int k = 1;
    KLargestElement kLargestElement = new KLargestElement();
    System.out.print( "K'th largest element is " +
        kLargestElement.findKthLargest(arr, 0, arr.length - 1, k) );
  }
}

