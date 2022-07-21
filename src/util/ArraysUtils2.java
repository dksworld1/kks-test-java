package util;

import java.util.Arrays;

public class ArraysUtils2 {

	public static int[] concat(int[] arr1, int[] arr2) {
		
		int[] dest = new int[arr1.length + arr2.length];
		
		System.arraycopy(arr1, 0, dest, 0, arr1.length);
		System.arraycopy(arr2, 0, dest, arr1.length, arr2.length);
				
		return dest;
		
	}
	
	public static void concatTest() {
		int[] arr1 = new int[] {1,2,3};
		int[] arr2 = new int[] {4,5};
		int[] arr3 = new int[] {6,7,8,9};
		
	    int[] rst = concat(concat(arr1, arr2), arr3);
	    
	    System.out.println(Arrays.toString(rst));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		concatTest();
	}

}
