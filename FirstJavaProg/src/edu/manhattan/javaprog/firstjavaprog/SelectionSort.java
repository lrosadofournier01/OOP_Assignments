package edu.manhattan.javaprog.firstjavaprog;

public class SelectionSort {
	static int[] nums = {10, 3, 8, 5, 9, 6, 7, 1, 2, 4};

	public static void main(String[] args) {
		int i, j, minNum, minIndex;
		
		for(int k=0; k<nums.length; k++)
			System.out.print(nums[k] + " ");
		System.out.println("");
		
		for(i=0; i<nums.length - 1; i++) {
			minIndex=i;
			minNum=nums[i];
			for(j=i+1; j<nums.length; j++) {
				if(nums[j]<minNum) {
					minNum = nums[j];
					minIndex=j;
				}
			}
			if(!(minIndex==i)) {
				nums[minIndex]=nums[i];
				nums[i]=minNum;				
			}
		}
		for(i=0; i<nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println("");
	}

}
