package test.exception.cause;

public class TestMain {

	public void catchCauseTest() throws Exception {
		try {
			//ExceptionGen.genExCauseA();
			ExceptionGen.genExA();
		} catch (Exception e) {
			Throwable th = e;
			while(th != null) {
				if(th.getMessage().contains("exception A raised.")) {
					throw new ExceptionA("old ex A found and throw new ExceptionA");
				}
				th = e.getCause();
			}
			
			throw new Exception("not found. so statck ex throws.", e);
		} 
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestMain test = new TestMain();
		test.catchCauseTest();
	}

}
