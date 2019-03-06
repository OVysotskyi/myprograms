package com.myprograms.ThreadPoolAndMD5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String fileName = "E:\\md5.txt";

    public void deleteExistingFile() {
        File txtFile = new File(fileName);

        if (txtFile.exists()) {
            txtFile.delete();
        }
    }

    public synchronized void createTxtFile(String md5) throws IOException {
        File txtFile = new File(fileName);

        if (!txtFile.exists()) {
            txtFile.createNewFile();
        }

        if (txtFile.canWrite()) {
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName, true));

            bWriter.write(md5 + "\r\n");
            System.out.println("MD5 added to file!");
            bWriter.close();
        }
    }
}