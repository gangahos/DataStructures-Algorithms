public class BinarySearch {
  public static int binarySearch(int intArray[], int key) {
    int left = 0;
    int right = intArray.length - 1;
    int mid;
    while (left <= right) {
      mid = (left+right)/2;
      if (key == intArray[mid]) {
        return mid;
      } else if (key > intArray[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  public static int binarySearchRecurrsive(int intArray[], int key, int left, int right) {
    if (left <= right) {
      int mid = (right - left)/2 + left;
      if (key == intArray[mid]) {
        return mid;
      } else if (key > intArray[mid]) {
        return binarySearchRecurrsive(intArray, key, mid+1, right);
      } else {
        return binarySearchRecurrsive(intArray, key, left, mid-1);
      }
    }
    return -1;
  }

  public static int findSameIndex(int intArray[]) {
    int left = 0;
    int right = intArray.length - 1;
    int mid;
    while (left <= right) {
      mid = (right-left)/2 + left;
      if (mid == intArray[mid]) {
        return mid;
      } else if (mid > intArray[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }



  public static void main(String args[]) {
    int intArray[] = new int[]{4,6,8,12,15};
    int[] A = new int[]{-2, 0, 1, 2, 4};
    System.out.println(BinarySearch.binarySearch(intArray,15));
    System.out.println(BinarySearch.binarySearchRecurrsive(intArray,15,0,4));
    System.out.println(BinarySearch.findSameIndex(A));


  }
}
