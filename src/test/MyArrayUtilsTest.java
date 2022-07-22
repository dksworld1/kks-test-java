package test;

import java.util.Arrays;

import util.ArrayUtils;

public class MyArrayUtilsTest {

	public void simpleTest() {
		try {
			double[] arr = new double[1001];
			for(int i=0; i<arr.length; i++) {
				arr[i] = i;
			}
			
			Double[] arr2 = ArrayUtils.convertParallel(arr, 10);
			System.out.println(arr2.length);
			System.out.println(Arrays.toString(arr2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void benchMark(int length) throws Exception {
		double[] arr = new double[length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		
		long start = 0;
		start = System.currentTimeMillis();
		Double[] arr2 = ArrayUtils.convert(arr);
		System.out.println(String.format("arr2 len: %d, elapsed time: %dms", arr2.length, System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		int threads = 2;
		Double[] arr3 = ArrayUtils.convertParallel(arr, threads);
		System.out.println(String.format("arr2 len: %d, threads: %d, elapsed time: %dms", arr3.length, threads, System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		threads = 10;
		Double[] arr4 = ArrayUtils.convertParallel(arr, threads);
		System.out.println(String.format("arr2 len: %d, threads: %d, elapsed time: %dms", arr4.length, threads, System.currentTimeMillis() - start));
	}
	
	public static void main(String[] args) throws Exception {
		MyArrayUtilsTest test = new MyArrayUtilsTest();
		//test.simpleTest();
		test.benchMark(10000000);
	}

}
