package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import task.DoubleArrayCopyTask;

public class ArrayUtils {
	public static Double[] convertParallel(double[] src, int threads) throws Exception {
		Double[] copy = new Double[src.length];
		
		if(src.length == 0) {
			return copy;
		}
		
		if(threads < 1) {
			return ArrayUtils.convert(src);
		}
		
		//방식1. 스레드 만큼의 리스트에 하나씩 넣기 
//		List<List<Integer>> idxGroup = new ArrayList<>();
//		for(int i=0; i<threads; i++) {
//			idxGroup.add(new ArrayList<Integer>());
//		}		
//		int cursor = 0;
//		for(int i=0; i<data.length; i++) {
//			if(cursor == threads) {
//				cursor = 0;
//			}
//			idxGroup.get(cursor).add(i);
//			cursor++;
//		}
		
		//방식2. 인터벌을 구해서 시작, 끝 인덱스로 테스크 생성방식
		int interval = src.length / threads;
		interval++;
		System.out.println("interval=" + interval);
		
		List<Integer> list = new ArrayList<>();
		int a = 0;
		while(true) {
			if(a >= src.length) {
				list.add(src.length);
				break;
			}
			list.add(a);
			a += interval;
		}
		System.out.println("print interval list");
		System.out.println(list);
		
		List<DoubleArrayCopyTask> taskList = new ArrayList<>();
		for(int i=0; i<list.size()-1; i++) {			
			int start = list.get(i);			
			int end = list.get(i+1);
			taskList.add(new DoubleArrayCopyTask(src, copy, start, end));
		}
		
		List<Future<Exception>> futureList = new ArrayList<>(); 
		ExecutorService es = Executors.newFixedThreadPool(threads);
		for(DoubleArrayCopyTask task : taskList) {
			futureList.add(es.submit(task));
		}
		
		es.shutdown();
		while(!es.isTerminated()) {			
		}
		
		for(Future<Exception> future : futureList) {
			Exception e = future.get(); 
			if(e != null) {
				throw new Exception("convertParallel failed. cause: " + e.getMessage(), e);
			}
		}
		
		return copy;
	}
	
	public static Double[] convert(double[] src, int start, int end) {
		if(start >= end) {
			throw new RuntimeException("start >= end");
		}
		
		Double[] dest = new Double[end - start];
		int destIdx = 0;
		for(int i=start; i<end; i++) {
			dest[destIdx] = src[i];
			destIdx++;
		}
		
		return dest;
	}
	
	public static Double[] convert(double[] src) {
		Double[] dest = new Double[src.length];
		for(int i=0; i<src.length; i++) {
			dest[i] = src[i];
		}		
		return dest;
	}

}
