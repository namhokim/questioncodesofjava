package com.naver.cafe.javachobostudy.whrlehd88;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FtpUploader {
    public static void main(String[] args) throws IOException {
        FTPClient ftp = new FTPClient();
        boolean error = false;
        try {
            int reply;
            final String server = "ftp.example.com";
            ftp.connect(server);
            System.out.println("Connected to " + server + ".");
            System.out.print(ftp.getReplyString());

            // After connection attempt, you should check the reply code to verify
            // success.
            reply = ftp.getReplyCode();

            if(!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.err.println("FTP server refused connection.");
                System.exit(1);
            }
            String localFileFullName = "file";
            reply = uploadFile(ftp, localFileFullName);
            if(!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.err.println("FTP server refused upload.");
                System.exit(1);
            }
            ftp.logout();
        } catch(IOException e) {
            error = true;
            e.printStackTrace();
        } finally {
            if(ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch(IOException ioe) {
                    // do nothing
                }
            }
            System.exit(error ? 1 : 0);
        }
    }

    private static int uploadFile(FTPClient ftp, String localFileFullName) throws IOException {

        final File file = new File(localFileFullName);
        try(InputStream input = new FileInputStream(file)){
            ftp.storeFile(file.getName(), input);
            return ftp.getReplyCode();
        }
    }
}
