class Solution {
    public int maxArea(int[] height) {

     int left = 0, right = height.length-1;
     int maxArea = 0;

     while(left<right){

     //Area = (right-left) * min height

     int area = (right-left) * Math.min(height[left], height[right]);

     maxArea = Math.max(area, maxArea);
    //i was adding extra condition here, chk notes.
     if(height[left]<height[right]) left++;
     else right--;
 
     }

    return maxArea;
    }
}