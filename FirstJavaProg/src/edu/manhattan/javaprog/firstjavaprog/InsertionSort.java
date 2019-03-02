package edu.manhattan.javaprog.firstjavaprog;

public class InsertionSort {
	
	static int[] nums = {10, 3, 8, 5, 9, 6, 7, 1, 2, 4};
	public static void main(String[] args) {
		//int[] nums2 = new int[10];
		int i, j;
		for(i=0; i<nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println("");
		//nums2[0] = nums[0];
		for(i=1; i<nums.length; i++) {
			//nums2[i] = nums[i];
			for(j=i-1; j>=0; j--) {
				if(nums[j]>nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		for(i=0; i<nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println("");
	}

}
