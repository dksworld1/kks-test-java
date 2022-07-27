package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ExecPythonTest {

	public void test() throws IOException, InterruptedException {
		//String command = "C:\\Users\\dks37\\anaconda3\\envs\\pystudy\\python.exe";  // 명령어
		String command = "C:\\Users\\dks37\\anaconda3\\envs\\oes-cal\\python.exe";  // 명령어		
		String arg1 = "F:\\PycharmProjects\\jpytest\\test\\sys_test.py"; // 인자
		ProcessBuilder builder = new ProcessBuilder(command, arg1);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream(),StandardCharsets.UTF_8.name()));		
		bw.write("aaa내");
		bw.newLine();
		bw.flush();
		
//		process.getOutputStream().write("내이름은 강기순입니다.".getBytes(StandardCharsets.UTF_8));
//		process.getOutputStream().write(System.lineSeparator().getBytes());
//		process.getOutputStream().flush();
		
		
		int exitVal = process.waitFor();  // 자식 프로세스가 종료될 때까지 기다림
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8.name())); // 서브 프로세스가 출력하는 내용을 받기 위해
		String line;
		while ((line = br.readLine()) != null) {
		     System.out.println(">>>  " + line); // 표준출력에 쓴다
		}
		if(exitVal != 0) {
		  // 비정상 종료
		  System.out.println("서브 프로세스가 비정상 종료되었다.");
		}
	}
	
	
	public void test2() throws Exception {
		long start = System.currentTimeMillis();
		//String command = "C:\\Users\\dks37\\anaconda3\\envs\\pystudy\\python.exe";  // 명령어
		String command = "C:\\Users\\dks37\\anaconda3\\envs\\oes-cal\\python.exe";  // 명령어		
		String arg1 = "F:\\PycharmProjects\\jpytest\\test\\sys_test2.py"; // 인자
		ProcessBuilder builder = new ProcessBuilder(command, arg1);
		builder.redirectErrorStream(true);
		Process process = builder.start();
		
		OutputStream out = process.getOutputStream();
		out.write(("내이름은 강기순입니다." + System.lineSeparator()).getBytes(StandardCharsets.UTF_8));
		out.flush();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8.name())); // 서브 프로세스가 출력하는 내용을 받기 위해
		String line;
		int count = 0;
		while ((line = br.readLine()) != null) {
		     if(count % 3000 == 0) System.out.println(">>>  " + line); // 표준출력에 쓴다
		     count++;
		}
		
		int exitVal = process.waitFor();  // 자식 프로세스가 종료될 때까지 기다림
		if(exitVal != 0) {
		  // 비정상 종료
		  System.out.println("서브 프로세스가 비정상 종료되었다.");
		}
		
		System.out.println("complete elapsed: " + (System.currentTimeMillis() - start));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecPythonTest test = new ExecPythonTest();
		try {
			//test.test();
			test.test2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
