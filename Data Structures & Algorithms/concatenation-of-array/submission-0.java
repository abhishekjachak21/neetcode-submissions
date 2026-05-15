class Solution {
    public int[] getConcatenation(int[] nums) {
        
    int[] arr3 = new int[nums.length * 2];

    for(int i=0;i<nums.length; i++){
        arr3[i] = nums[i];
        arr3[i + nums.length] = nums[i];
    }

    return arr3;
}
}
