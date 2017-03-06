package sk.toman.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;


public class HelpersIO {

	public static void copyLocalFileOrFolder(File source, File destination) throws Exception     {
		if(source.exists()){
			if(source.isDirectory()){
				if(!destination.exists()){
					destination.mkdirs();
				}
				
				String files[] = source.list();
				
				for(String file : files){
					File srcFile = new File(source, file);
					File desFile = new File(destination, file);
					
					copyLocalFileOrFolder(srcFile, desFile);
				}				
			}else{
				FileInputStream fInStream = null;
				FileOutputStream fOutStream = null;
				
				try{
					fInStream = new FileInputStream(source);
					fOutStream = new FileOutputStream(destination);
				
					byte[] buffer = new byte[1024];
					int length;
			        while ((length = fInStream.read(buffer)) > 0) {
			        	fOutStream.write(buffer, 0, length);
			        }		        
			        
				}catch (Exception ex) {
					HelpersLog.writeErrToLogFile(ex);
					throw ex;
				}
				finally{
					fInStream.close();
					fOutStream.close();
				}
			}			
		}
	}
	
	public static void copySmbFileToFolder(String fromFileURL, String fromUserNameNTLM, String fromUserPassNTLM, String toFolderURL, String toUserNameNTLM, String toUserPassNTLM, boolean deleteFile) throws Exception {
		SmbFile fromFile = new SmbFile(fromFileURL, new NtlmPasswordAuthentication(fromUserNameNTLM+":"+fromUserPassNTLM));
		SmbFile toFolder = new SmbFile(toFolderURL, new NtlmPasswordAuthentication(toUserNameNTLM+":"+toUserPassNTLM));
		try {
			if (toFolder!=null) {
				try {
					fromFile.copyTo(toFolder);	
				}
				catch(Exception e) {
					HelpersLog.writeErrToLogFile(e);
				}
				if (deleteFile) {
					try {
						fromFile.delete();	
					}
					catch(Exception e) {
						HelpersLog.writeErrToLogFile(e);
					}
				}
			}			
		} catch (Exception e) {
			HelpersLog.writeErrToLogFile(e);
		}
	}
	
	public static String getBase64StringFromFile(File source){
		String strDataBase64 = "";
		try {
			byte[] dataBase64 = Base64.getEncoder().encode(HelpersIO.getByteArrayFromFile(source));
			strDataBase64 = new String(dataBase64);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strDataBase64;
	}
	
	public static void getBase64TextFileFromFile(File source, File destination){
		try {
			byte[] dataBase64 = Base64.getEncoder().encode(HelpersIO.getByteArrayFromFile(source));
			String strDataBase64 = new String(dataBase64);

			BufferedWriter bw = new BufferedWriter(new PrintWriter(destination));
			bw.write(strDataBase64);
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static byte[] getByteArrayFromFile(File source) throws Exception     {
		byte[] data = null;
		if(source.exists()){				
			try{			        
				Path p = Paths.get(source.getAbsolutePath());
				data = Files.readAllBytes(p);			        
			}catch (Exception ex) {
				HelpersLog.writeErrToLogFile(ex);
				throw ex;
			}		
		}
		return data;
	}
	
	public static void fileToSha256(){
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
		
        FileInputStream fis = new FileInputStream("c:\\log.txt");

        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        };
        byte[] mdbytes = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());

       //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
    	}

    	System.out.println("Hex format : " + hexString.toString());
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public static void filesToWinZipArchive(File folder, String pathToWinZip, String winZipNameWithExt) throws Exception {		
		
		List<File> fileList = Arrays.asList(folder.listFiles());//new ArrayList <File>();
		File zipfile = new File(pathToWinZip+winZipNameWithExt);
			
	    byte[] buf = new byte[1024];
	    try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
			FileInputStream in = null;
			
	        for(int i=0; i<fileList.size(); i++) {
	            in = new FileInputStream(fileList.get(i).getPath());
	            out.putNextEntry(new ZipEntry(fileList.get(i).getName()));

	            int len;
	            while((len = in.read(buf)) > 0) {
	                out.write(buf, 0, len);
	            }
	        }
            out.closeEntry();
            in.close();
    		out.close();
	    } catch (Exception ex) {
	    	
	    }
	}
}
