package test.sort;

import java.util.Arrays;

import util.StringUtils;


public class SortTest {

	public void arraySortPerfTest(int len) {
		
		double[] arr = new double[len];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Math.random();
		}
		
		long start = System.currentTimeMillis();
		Arrays.sort(arr);
		System.out.println("len: " + StringUtils.lpad(String.valueOf(len), ' ', 10) + " Array.sort completed in " + (System.currentTimeMillis() - start) + "ms");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortTest test = new SortTest();
//		test.arraySortPerfTest(100000000);
		test.arraySortPerfTest(10000000);
		test.arraySortPerfTest(1000000);
		test.arraySortPerfTest(100000);
		test.arraySortPerfTest(10000);
	}

}
