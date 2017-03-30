package com.codingbeginners.ftp;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FTP_MainMethod {


 public void provideFTP_ServerDetails() throws Exception {

 String sFtpServer="x.x.x.x";
 String sftpUserName="abc";
 String sftpPassword="abc";
 int iPortNo=44;
 String sLocalFilePath="C:\\Users\\nilesh_vispute\\Desktop\\lCodingBeginners_FTP.wsdl";
 String sFileName="nilesh.wsdl";
 String sFtpFileStoreDirectory="/home/xxx/nil";
 FTP_UploadFile ftpUploader = new FTP_UploadFile();
 
ftpUploader.connectFTP(sFtpServer,sftpUserName,sftpPassword,iPortNo,sLocalFilePath,sFileName,sFtpFileStoreDirectory);
      
 }
 public static void main(String[] args) throws Exception {
  
  FTP_MainMethod ftp_Main=new FTP_MainMethod();

 ftp_Main.provideFTP_ServerDetails();
 }
 
}


