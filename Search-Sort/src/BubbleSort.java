public class BubbleSort {
  public static void bubbleSort(Integer[] arrayInt) {
    boolean swapped;
    for (int j = 0; j<arrayInt.length - 1; j++) {
      swapped = false;
      for (int i = 0; i<arrayInt.length - j - 1; i++) {
        if (arrayInt[i] > arrayInt[i+1]) {
          int temp = arrayInt[i];
          arrayInt[i] = arrayInt[i+1];
          arrayInt[i+1] = temp;
          swapped = true;
        }
      }
      if (swapped == false) {
        break;
      }

    }
    for (int i = 0; i<arrayInt.length; i++) {
      System.out.println(arrayInt[i]);
    }
  }

  public static void main(String[] args) {
    Integer[] unSorted = new Integer[]{6,9,1,3,10};
    BubbleSort.bubbleSort(unSorted);


  }

} 
