public class MissingNumber {
    public int missingNumber(int[] nums) {
        int missingOne = 0;
        int countingTill = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingOne += countingTill;
            countingTill--;
            missingOne -= nums[i];
        }
        return missingOne;
    }

}
