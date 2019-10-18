public class QuickSort {

  public static void quicSort(int[] arr, int p, int r) {
    if (p < r) {
      int q = partition(arr, p, r);
      quicSort(arr,p,q-1);
      quicSort(arr,q+1,r);
    }
  }

  public static int partition(int[] arr, int p, int r) {
    int x = arr[r];
    int i = p - 1;

    for (int j = p; j<r; j++) {
      if(arr[j] <= x) {
        i = i + 1;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    //Put the pivot element in its proper index.
    i = i + 1;
    int temp = arr[r];
    arr[r] = arr[i];
    arr[i] = temp;
    return i;
  }

  public static void quicSort1(int[] arr, int p, int r) {
    if (p < r) {
      int q = hoarePartition(arr, p, r);
      quicSort(arr,p,q-1);
      quicSort(arr,q+1,r);
    }
  }


  public static int hoarePartition(int[] A, int p, int r) {
    int pivot = A[p];
    int i = p-1;
    int j = r+1;
    while (true) {
      do {
        j--;
      }while(A[j] >= pivot);
      do {
        i++;
      }while(A[i] <= pivot);
      if (i < j) {
        int swap = A[i];
        A[i] = A[j];
        A[j] = swap;
      }
      else return j;
    }
  }

  public static void printArray(int[] A) {
    for (int w = 0; w<A.length; w++) {
      System.out.print(A[w]+" ");
    }

  }


  public static void main(String[] args) {
    int[] unSorted = new int[]{6,9,1,3,10,2};
    QuickSort.quicSort1(unSorted,0,5);
    QuickSort.printArray(unSorted);


  }

} 
