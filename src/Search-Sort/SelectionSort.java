public class SelectionSort {
  public static void selectionSort(Integer[] arrayInt) {
    for (int i = 0; i<arrayInt.length - 1; i++) {
      int minIndex = i;
      //find the minimum element and then swap
      for (int j = i+1; j<arrayInt.length; j++) {
        if (arrayInt[j] < arrayInt[minIndex]) {
          minIndex = j;
        }
      }
        //Since i has to have the lesser value, swap
        int temp = arrayInt[minIndex];
        arrayInt[minIndex] = arrayInt[i];
        arrayInt[i] = temp;

    }
    for (int i = 0; i<arrayInt.length; i++) {
      System.out.println(arrayInt[i]);
    }
  }

  public static void main(String[] args) {
    Integer[] unSorted = new Integer[]{64,25,12,22,11};
    SelectionSort.selectionSort(unSorted);
  }

}

