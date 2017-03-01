package sk.toman.util;

import java.io.File;



public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		System.out.println("Main START");
		
		HelpersLog.setLogPath("C:\\\\Test\\");

		/*//Copy File		
		File fileIn = new File("C:\\\\Test\\ttto.txt");
		File fileOut = new File("C:\\\\Test\\tttoCopy.txt");*/

		/*//Copy directory
		File fileIn = new File("C:\\\\Test");
		File fileOut = new File("C:\\\\Test12345");*/
		
		//Copy File LAN	
		//File fileIn = new File("C:\\\\Test\\ttto.txt");
		//File fileOut = new File("\\\\10.64.168.21\\c$\\ttto.txt");
		//	\\Sms9apwebt01slx\c$\ProgramData\Fabasoft\DOCDIR
		//HelpersIO.copyLocalFileOrFolder(fileIn, fileOut);

		/*//Copy SMB file to folder
		String fromFileURL = new String("smb://10.64.168.21/EZZData/PredpisPripomienky/ttto.txt");
		String toFolderURL = new String("smb://10.64.168.21/EZZData/PredpisSucess/");
		//SmbFile fromFile = new SmbFile("smb://10.64.168.21/C\\$/EZZData/PredpisPripomienky/ttto.txt", auth);
		//C\\$/
		//SmbFile toFolder = new SmbFile("\\SMS9APWEBT01SLX\\c$\\EZZData\\PredpisPripomienky\\");

		HelpersIO.copySmbFileToFolder(fromFileURL, "anext", "txena123.", toFolderURL,"anext","txena123.", true);*/
		
		
		/*//Folder to WinZip
		File folder = new File("C:\\\\Test\\folderToZip\\");
		HelpersIO.filesToWinZipArchive(folder, "C:\\\\Test\\", "archiiiiiiiv.zip");*/
		
		
//		//Copy File LAN	
//		File fileIn = new File("C:\\\\Test\\2016_017.pdf");
//		File fileOut = new File("C:\\\\Test\\2016017.txt");
//		HelpersIO.getBase64TextFileFromFile(fileIn, fileOut);
		
		//Mail.sendMail("smtp.gmail.com", null, "tomastomannr@gmail.com", "tomastomannr@gmail.com", "tomastoman11111");
		Mail.generateAndSendEmail();
		System.out.println("Main END");
		}catch(Exception e){	
			System.out.println("Chyba Main: " + e);
		}
	}
}
