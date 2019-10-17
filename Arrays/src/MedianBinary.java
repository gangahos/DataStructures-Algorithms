/*
Finding median of two sorted arrays of same length using Divide and Conquer Logic
The time complexity is O(logn)
 */
public class MedianBinary {
  public double findMedianSortedArrays(int[] a, int[] b, int startIndexA, int endIndexA,
      int startIndexB, int endIndexB) {
    System.out.println("A: "+startIndexA+" "+endIndexA);
    System.out.println("B: "+startIndexB+" "+endIndexB);


    if ((endIndexA - startIndexA < 0) || ((endIndexB - startIndexB < 0))) {
      System.out.println("Invalid Input.");
      return -1;
    }

    if ((endIndexA - startIndexA == 0) && ((endIndexB - startIndexB == 0))) {
      return (a[0] + b[0])/2;
    }

    if ((endIndexA - startIndexA == 1) && ((endIndexB - startIndexB == 1))) {
      System.out.println("here");
      return (1.0*(Math.max(a[startIndexA], b[startIndexB])
          + Math.min(a[endIndexA], b[endIndexB])))/2;
    }

    double m1 = findMedian(a, startIndexA, endIndexA);
    double m2 = findMedian(b, startIndexB, endIndexB);

    System.out.println(m1+" "+m2);

    if (m2 == m1) {
      return m2;
    }

    // since m1 <= median <= m2 narrow down search by eliminating elements less than m1
    // and elements greater than m2
    if (m1 < m2) {
      if ((endIndexA - startIndexA) % 2 == 0) {// we are looking at odd number of elements
        startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
        endIndexB = startIndexB + (endIndexB - startIndexB) / 2;
      } else {
        startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
        endIndexB = startIndexB + (endIndexB - startIndexB) / 2 + 1;
      }
    }

    // since m2 <= median <= m1 narrow down search by eliminating elements less than m2 and
    // elements greater than m1
    else { // m2 < m1
      if ((endIndexB - startIndexB) % 2 == 0) { // we are looking at odd number of elements
       startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
       endIndexA = startIndexA + (endIndexA - startIndexA) / 2;
      } else {
        startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
        endIndexA = startIndexA + (endIndexA - startIndexA) / 2 + 1;
      }
    }
    return findMedianSortedArrays(a, b, startIndexA, endIndexA, startIndexB, endIndexB);
  }

  private double findMedian(int[] array, int startIndex, int endIndex) {
    int indexDiff = (endIndex - startIndex);
    if (indexDiff % 2 == 0) { // we are looking at odd number of elements{
      return array[startIndex + (indexDiff/2)];
    } else{
      return 1.0*((array[startIndex + (indexDiff/2)] + array[startIndex + (indexDiff/2) + 1])/2);
    }
  }


public static void main(String[] args) {

    MedianBinary solution = new MedianBinary();

    System.out.println("Case 1: When arrays have odd number of elements in them.");
    int [] a = {1,2,3,4,5};
    int [] b = {6,7,8,9,10};

    System.out.println("Median: " + solution.findMedianSortedArrays(a, b, 0, a.length-1, 0, b.length-1));

    System.out.println("-----------------");

    System.out.println("Case 2: When arrays have even number of elements in them.");
    int[] c = {1,2,99, 100};
    int[] d = {4,5,101, 102};

    System.out.println("Median: " + solution.findMedianSortedArrays(c, d, 0, c.length-1, 0, d.length-1));
    }
}