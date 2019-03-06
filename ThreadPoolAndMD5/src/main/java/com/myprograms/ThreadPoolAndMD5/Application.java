package com.myprograms.ThreadPoolAndMD5;

public class Application {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.deleteExistingFile();

        URLReader urlReader = new URLReader();
        urlReader.processingUrlFromFile("E:\\geekhub\\hw12\\src\\main\\resources\\urls.txt");
    }
}