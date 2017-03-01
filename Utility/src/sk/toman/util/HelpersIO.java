package sk.toman.util;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
