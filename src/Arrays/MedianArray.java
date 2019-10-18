import java.util.Arrays;

public class MedianArray {
  public static void solution(int[] nums) {
    Arrays.sort(nums);
    if (nums.length%2 != 0) {
      System.out.println(nums[nums.length/2]);
    } else {
      int mid = nums.length/2;
      double median = (double)(nums[(mid)] + nums[(mid-1)]) / 2.0;
      System.out.println(median);
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[]{4,3,7,10,2,5};
    MedianArray.solution(nums);
  }

}
