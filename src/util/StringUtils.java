package util;

public class StringUtils {
	public static String lpad(String origin, char ch, int len) {
		if(origin.length() >= len) {
			return origin; 
		}
		
		int len2 = len - origin.length();
		StringBuffer sb = new StringBuffer();
		while(sb.length() < len2) {
			sb.append(ch);
		}
		
		return sb.append(origin).toString();
		
	}
}
