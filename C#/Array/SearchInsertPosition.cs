/*
35. Search Insert Position
Link: https://leetcode.com/problems/search-insert-position/

Given a sorted array of distinct integers and a target value, return the
index if the target is found. If not, return the index where it would be
if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
*/

public class Solution {
    public int SearchInsert(int[] nums, int target) {
        // Initialize lower and upper boundary
        int l = 0;
        int r = nums.Length - 1;

        // Loop between lower and upper until l = r
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) 
                r = mid;
            else 
                l = mid + 1;
        }

        return nums[l] >= target ? l : l + 1; 
    }
}