package com.codingbeginners.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTP_UploadFile {
 
 FTPClient ftp = null;
 
 public void connectFTP(String sFtpServer, String sFtpUserName, String sFtpPassword,int portNo,String localFilePath,String fileName,String ftp_filePath_Replc) throws Exception{
  try {
   
   System.out.println("---FTPUploader---"+sFtpServer+"--"+sFtpUserName+"--"+sFtpPassword);
   ftp = new FTPClient();
   
   
   ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
   int reply;
   
   System.out.println("-------"+ftp.getReplyCode());   
   
   ftp.connect(sFtpServer,portNo);
   reply = ftp.getReplyCode();
   if (!FTPReply.isPositiveCompletion(reply)) {
    ftp.disconnect();
    throw new Exception("Exception in connecting to FTP Server");
   }
   ftp.login(sFtpUserName, sFtpPassword);
   ftp.setFileType(FTP.BINARY_FILE_TYPE);
   ftp.enterLocalPassiveMode();
      
   uploadFile(localFilePath,fileName,ftp_filePath_Replc);

  } 
  
  catch (Exception e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 public void uploadFile(String localFileFullName, String fileName, String sFtpServerDir)
   throws Exception {
  
  System.out.println("---uploadFile---"+localFileFullName+"--"+fileName+"--"+sFtpServerDir);
  try
  (InputStream input = new FileInputStream(new File(localFileFullName)))
  {
  this.ftp.storeFile(sFtpServerDir + fileName, input);
  
  }
  catch(FileNotFoundException fnf)
  {
   System.out.println("File is not found...........Remaing Call Exception flow......");
  
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
  
  final boolean result = new File(localFileFullName).delete();
    System.out.println( "result: |" + result + "|" );
     
    disconnect();

 }

 public void disconnect(){
  
  System.out.println(".........................FTP DICONNECT");
  if (this.ftp.isConnected()) {
   
   try {
    this.ftp.logout();
    this.ftp.disconnect();
   } catch (IOException f) {
    // do nothing as file is already saved to server
   }
  }
 } 
 
}
