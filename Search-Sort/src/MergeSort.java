public class MergeSort {

  public static void mergeSort(int[] A, int p, int r) {
    int q;
    if (p < r)
    {
      // Find the middle point
      q = (p+r)/2;

      // Sort first and second halves
      mergeSort(A, p, q);
      mergeSort(A , q+1, r);

      // Merge the sorted halves
      merge(A, p, q, r);
    }
  }

  // Merges two subarrays of arr[].
  // First subarray is arr[l..m]
  // Second subarray is arr[m+1..r]

  public static void merge(int[] A, int p, int q, int r) {
    int[] S = new int[A.length];

    //System.out.println("here "+"p : "+p+"q: "+q+"r: "+r);
    // Find sizes of two subarrays to be merged
    int n1 = q - p + 1;
    int n2 = r - q;


    //Using one spare array, total elements will be n1+n2
    for (int i=0; i<n1; ++i)
      S[i] = A[p + i];
    for (int j=0; j<n2; ++j)
      S[j+n1] = A[q+j+1];


    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    //j starts at n1 and will go till total length of
    // S i.e n1+n2
    int i = 0, j = n1;

    // Initial index of merged subarry array
    int k = p;
    while (i < n1 && j < (n2+n1)) {
      if (S[i] <= S[j]) {
        A[k] = S[i];
        i++;
      } else {
        A[k] = S[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of S[] if any */
    while (i < n1) {
      A[k] = S[i];
      i++;
      k++;
    }

    /* Copy remaining elements of S[] if any */
    while (j < (n2+n1)) {
      A[k] = S[j];
      j++;
      k++;
    }


    for (int w = 0; w<A.length; w++) {
      System.out.print(A[w]+" ");
    }

  }

  public static void main(String[] args) {
    int[] unSorted = new int[]{12, 11, 13, 5, 6, 99};
    MergeSort.mergeSort(unSorted,0,4);



  }


} 
