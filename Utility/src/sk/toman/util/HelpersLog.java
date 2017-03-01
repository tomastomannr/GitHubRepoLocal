package sk.toman.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpersLog {
	
	public static String logPath;

	public static void setLogPath(String logPathIn){
		logPath = logPathIn;
	}
	
	public static String getLogPath(){
		return logPath;
	}
	
	public static void writeErrToLogFile(Exception ex) throws IOException{
		System.out.println("writeErrToLogFile START");
		
		DateFormat dateFormatFileName = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();	

		File logFile = new File(logPath+"log_"+dateFormatFileName.format(date)+".txt");
		
		DateFormat dateFormatLogTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		FileWriter fw = new FileWriter(logFile, true);
		String lineSeparator = System.getProperty("line.separator");
		fw.write(lineSeparator + dateFormatLogTime.format(date) + " ERROR - " + ex.getMessage());
		fw.close();
		
		System.out.println("writeErrToLogFile END");

	}
}
