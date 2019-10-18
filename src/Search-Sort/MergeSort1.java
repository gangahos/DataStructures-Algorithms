public class MergeSort1 {
  public void mergesort1 (int[] A, int left, int right) {
    int mid;
    if (left < right) {
      mid = (right - left)/2 + left;
      mergesort1(A, left, mid);
      mergesort1(A, mid+1, right);
      merge(A, left, mid, right);
    }
  }

  public void merge(int[] A, int left, int mid, int right){
    int n1 = mid-left+1;
    int n2 = right-mid;
    int[] L = new int[n1];
    int[] R = new int[n2];

    for(int i = 0; i<n1; i++) {
      L[i] = A[left+i];
    }

    for(int i = 0; i<n2; i++) {
      R[i] = A[mid+1+i];
    }

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    //j starts at n1 and will go till total length of
    // S i.e n1+n2
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = left;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        A[k] = L[i];
        i++;
      } else {
        A[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of S[] if any */
    while (i < n1) {
      A[k++] = L[i++];
    }

    /* Copy remaining elements of S[] if any */
    while (j < n2) {
      A[k++] = R[j++];
    }

  }

  public static void main(String[] args) {
    int[] unSorted = new int[]{12, 11, 13, 5, 6, 99};
    MergeSort1 ms = new MergeSort1();
    ms.mergesort1(unSorted,0,4);

    for (int w = 0; w<unSorted.length; w++) {
      System.out.print(unSorted[w]+" ");
    }

  }


} 
