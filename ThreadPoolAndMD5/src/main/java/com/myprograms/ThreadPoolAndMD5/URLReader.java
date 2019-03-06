package com.myprograms.ThreadPoolAndMD5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class URLReader {
    public void processingUrlFromFile(String fileAddress) {
        try (FileInputStream fis = new FileInputStream(fileAddress)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String strLine;

            ExecutorService executor = Executors.newFixedThreadPool(5);

            while ((strLine = br.readLine()) != null) {
                URL url = new URL(strLine);
                executor.execute(() -> {
                    try {
                        FileManager fileManager = new FileManager();
                        fileManager.createTxtFile(contentToMD5(url));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            executor.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String contentToMD5(URL url) throws IOException {
        String md5;
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");

        try (InputStreamReader is = new InputStreamReader(con.getInputStream());
             BufferedReader br = new BufferedReader(is)) {

            String input;
            StringBuilder stringBuilder = new StringBuilder();

            while ((input = br.readLine()) != null) {
                stringBuilder.append(input);
            }

            MD5Custom md5Custom = new MD5Custom();
            md5 = md5Custom.stringToMD5(stringBuilder.toString());

            System.out.println(url + " - " + md5);
        }

        return md5;
    }
}