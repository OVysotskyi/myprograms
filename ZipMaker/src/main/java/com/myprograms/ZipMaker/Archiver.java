package com.myprograms.ZipMaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archiver {
    public void createArchive(String sourceDir,
                              String zipAudio,
                              String zipImg,
                              String zipVideo) {
        try (ZipOutputStream audiosZip = new ZipOutputStream(new FileOutputStream(zipAudio));
             ZipOutputStream imagesZip = new ZipOutputStream(new FileOutputStream(zipImg));
             ZipOutputStream videosZip = new ZipOutputStream(new FileOutputStream(zipVideo))) {

            File fileSource = new File(sourceDir);

            checkingFiles(audiosZip, imagesZip, videosZip, fileSource);

            System.out.println("Zip file created!\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String getFileExtension(String fileName) {
        int index = fileName.indexOf('.');
        return index == -1 ? "" : fileName.substring(index);
    }

    private void checkingFiles(ZipOutputStream audiosZip,
                               ZipOutputStream imagesZip,
                               ZipOutputStream videosZip,
                               File fileSource) throws IOException {
        for (File file : fileSource.listFiles()) {
            String fileExtension = getFileExtension(file.getName());

            if (fileExtension.equals(".mp3")
                    || fileExtension.equals(".wav")
                    || fileExtension.equals(".wma")) {
                addFilesToArchive(file, audiosZip);
            } else if (fileExtension.equals(".jpeg")
                    || fileExtension.equals(".jpg")
                    || fileExtension.equals(".gif")
                    || fileExtension.equals(".png")) {
                addFilesToArchive(file, imagesZip);
            } else if (fileExtension.equals(".avi")
                    || fileExtension.equals(".mp4")
                    || fileExtension.equals(".flv")) {

                addFilesToArchive(file, videosZip);
            } else if (file.isDirectory()) {
                if (file.listFiles().length == 0) {
                    addFilesToArchive(file, imagesZip);
                    addFilesToArchive(file, videosZip);
                    addFilesToArchive(file, audiosZip);
                }
                checkingFiles(audiosZip, imagesZip, videosZip, file);
            }
        }
    }

    private void addFilesToArchive(File file, ZipOutputStream zout) throws IOException {
        if (file.isDirectory() && file.listFiles().length == 0) {
            String name = file.getPath();
            name = name.endsWith("\\") ? name : name + "\\";

            zout.putNextEntry(new ZipEntry(name));
        } else {
            try (FileInputStream fis = new FileInputStream(file)) {
                zout.putNextEntry(new ZipEntry(file.getPath()));
                byte[] buffer = new byte[fis.available()];
                int length;

                while ((length = fis.read(buffer)) > 0) {
                    zout.write(buffer, 0, length);
                }
                zout.closeEntry();
            }
        }
    }
}