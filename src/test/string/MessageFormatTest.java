package test.string;

import java.text.MessageFormat;

public class MessageFormatTest {

	public void test() {
		String format = "my name is {0} and my age is {1} and stress guage is upto {2} and say hello to the {3}";
		
		
		System.out.println(MessageFormat.format(format, "kks", 30, 100, "world"));
	}
	
	public void test2() {
		// TODO Auto-generated method stub
		String name = "kks";
		int address = 123456;
		double cost = 12.34567;
		
		String pattern = "name={0}, address={1}, cost={2}";
		String pattern2 = "name=%s, address=%d, codst=%.2f";
		
		//{-1} {name} -> error
		String pattern3 = "name={0}, address={1}, cost={2}, name={0}, address={1}, cost={2}";
		
		
		System.out.println(String.format(pattern2, name, address, cost));
		System.out.println(MessageFormat.format(pattern, name, address, cost));
		System.out.println(MessageFormat.format(pattern3, name, address, cost));
	}
	
	public static void main(String[] args) {
		MessageFormatTest test = new MessageFormatTest();
		test.test();
	}

}
