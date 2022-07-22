package task;

import java.util.concurrent.Callable;

public class DoubleArrayCopyTask implements Callable<Exception> {

	private double[] src;
	private Double[] dest;
	private int start;
	private int end;
	
	public DoubleArrayCopyTask(double[] src, Double[] dest, int start, int end) {
		this.src = src;
		this.dest = dest;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public Exception call() throws Exception {
		
		try {
			for(int i=start; i<end; i++) {
				this.dest[i] = this.src[i];
			}	
		} catch (Exception e) {
			return new Exception(String.format("error at DoubleArrayCopyTask: src length=%d, dest length=%d, start=%d, end=%d", src.length, dest.length, start, end));
		}
	
//		System.out.println(String.format("Completed DoubleArrayCopyTask: src length=%d, dest length=%d, start=%d, end=%d", src.length, dest.length, start, end));
		return null;
		
	}
	
}
