package test.string;

import java.text.MessageFormat;

public class MessageFormatTest {

	public static void main(String[] args) {
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

}
