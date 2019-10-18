public class InsertionSort {
  public static void insertionSort(Integer[] arrayInt) {
    for (int i = 1; i < arrayInt.length; i++) {
      int valueInserted = arrayInt[i];
      int holePosition = i;

      while (holePosition > 0 && arrayInt[holePosition-1] > valueInserted) {
        arrayInt[holePosition] = arrayInt[holePosition-1];
        holePosition = holePosition - 1;

      }
      arrayInt[holePosition] = valueInserted;
    }
    for (int i = 0; i<arrayInt.length; i++) {
      System.out.println(arrayInt[i]);
    }
  }

  public static void main(String[] args) {
    Integer[] unSorted = new Integer[]{6,9,1,3,10};
    InsertionSort.insertionSort(unSorted);


  }

}


