package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Easy {


	// my Solution
	public int[] twoSum(int[] nums, int target) {

		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(i != j) {
					if(nums[i] + nums[j] == target) {
						return new int[]{i, j};
					}
				}
			}
		}
		return new int[]{};
	}

	// how to improve
	// Two-pass Hash Table
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int n = nums.length;

		// Build the hash table
		for (int i = 0; i < n; i++) {
			numMap.put(nums[i], i);
		}

		// Find the complement
		for (int i = 0; i < n; i++) {
			int complement = target - nums[i];
			if (numMap.containsKey(complement) && numMap.get(complement) != i) {
				return new int[]{i, numMap.get(complement)};
			}
		}

		return new int[]{}; // No solution found
	}
	// One-pass Hash Table
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int complement = target - nums[i];
			if (numMap.containsKey(complement)) {
				return new int[]{numMap.get(complement), i};
			}
			numMap.put(nums[i], i);
		}

		return new int[]{}; // No solution found
	}

	// my Solution
	public int removeDuplicates(int[] nums) {

		Set<Integer> numSet = new LinkedHashSet<>();

		for (int number : nums) {
			numSet.add(number);
		}

		int index = 0;

		for (int number : numSet) {
			nums[index] = number;
			index++;
		}

		return index;
	}

	// my Solution
	public int removeElement(int[] nums, int val) {

		int countRemovedElements = 0;
		int n = nums.length;
		int i = 0;

		while (i < n - countRemovedElements) {

			if (nums[i] == val) {

				while (i < n - countRemovedElements && nums[n - 1 - countRemovedElements] == val) {
					countRemovedElements++;
				}

				if (i < n - countRemovedElements) {
					int lastIndex = n - 1 - countRemovedElements;

					int tmp = nums[i];
					nums[i] = nums[lastIndex];
					nums[lastIndex] = tmp;

					countRemovedElements++;
				}

			} else {
				i++;
			}
		}

		return n - countRemovedElements;
	}

	// my Solution
	public int binarySearch(int[] nums, int low, int high, int target){

		if (low > high) {
			return low;
		}

		int middle = low + (high - low) / 2;

		if(nums[middle] == target) {
			return middle;
		}else if(nums[middle] > target) {
			return binarySearch(nums, low, middle - 1, target);
		}else {
			return binarySearch(nums, middle + 1, high, target);
		}
	}

	public int searchInsert(int[] nums, int target) { 	

		return binarySearch(nums, 0, nums.length - 1, target);
	}

	// my Solution
	public int[] plusOne(int[] digits) {

		int countLastNines = 0;

		while(countLastNines < digits.length && digits[digits.length - countLastNines - 1] == 9)  {
			digits[digits.length - countLastNines - 1] = 0;
			countLastNines++;
		}

		if(digits.length == countLastNines) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}

		digits[digits.length - 1 - countLastNines] += 1;

		return digits;
	}
}
