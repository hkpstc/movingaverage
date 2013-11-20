package cmd;

import java.io.IOException;

public class CMD { 
	public static  void runCMD(String command) {

		Process process = null;
		try {
			process = Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void runCMD(String[] commands){
		
		
		for (int commandNumber=0 ;commandNumber<commands.length;commandNumber++){
			System.out.println(commands[commandNumber]);
			runCMD( commands[commandNumber]);
			
		}
	}
	
	public static void PrintCMD(String[] commands){
		
		
		for (int commandNumber=0 ;commandNumber<commands.length;commandNumber++){
			System.out.println(commands[commandNumber]);			
		}
	}
}
