/**
 * This is divide and conquer approach.
 * This is from leetcode.
 * We can use Kadane's algorithm and do in o(n) time
 */
public class MaximumSubArray {
  public int crossSum(int[] nums, int left, int right, int p) {
    if (left == right) return nums[left];

    int leftSubsum = Integer.MIN_VALUE;
    int currSum = 0;
    for(int i = p; i > left - 1; --i) {
      currSum += nums[i];
      leftSubsum = Math.max(leftSubsum, currSum);
    }

    int rightSubsum = Integer.MIN_VALUE;
    currSum = 0;
    for(int i = p + 1; i < right + 1; ++i) {
      currSum += nums[i];
      rightSubsum = Math.max(rightSubsum, currSum);
    }

    return leftSubsum + rightSubsum;
  }

  public int helper(int[] nums, int left, int right) {
    if (left == right) return nums[left];

    int p = (left + right) / 2;

    int leftSum = helper(nums, left, p);
    int rightSum = helper(nums, p + 1, right);
    int crossSum = crossSum(nums, left, right, p);

    return Math.max(Math.max(leftSum, rightSum), crossSum);
  }

  public int maxSubArray(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  /*
  Kadane's algorithm, Using start and end variables to track the
  subarray.
   */
  public int kadane(int[] A) {
    int maxSoFar = A[0];
    int maxEndingHere = A[0];
    int start = 0;
    int end = 0;
    int s = 0;

    for (int i = 1; i < A.length; i++) {
      maxEndingHere = maxEndingHere + A[i];

      // update the maximum sum of subarray ending at i
      if (maxEndingHere < A[i]) {
        maxEndingHere = A[i];
        s = i;
      }


      // update result if current sub-array sum is found to be greater
      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
        start = s;
        end = i;
      }


    }
    System.out.println("Array : "+start+" "+end);
    return maxSoFar;
  }

  public static void main(String[] args) {
    int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
    //int[] A = { -8, -3, -6, -2, -5, -4 };
    MaximumSubArray maximumSubArray = new MaximumSubArray();

    System.out.println("The sum of contiguous subarray with the " +
        "largest sum is " + maximumSubArray.maxSubArray(A));
  }


}