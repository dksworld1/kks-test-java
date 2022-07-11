package test.exception.cause;

public class ExceptionGen {
	public static void genExCauseA() throws Exception {
		try {
			throw new ExceptionA("exception A raised.");
		} catch (Exception e) {
			throw new Exception("ex a after me raised.", e);
		}
	}
	
	public static void genExA() throws Exception {
		throw new ExceptionA("exception AAAAAA.");
	}
}
