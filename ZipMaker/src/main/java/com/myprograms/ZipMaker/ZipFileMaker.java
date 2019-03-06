package com.myprograms.ZipMaker;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ZipFileMaker {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Press 1 to start archiving data");
                System.out.println("Press 2 to exit");
                Scanner scanner = new Scanner(System.in);
                int command = scanner.nextInt();

                if (command == 1) {
                    Scanner dir = new Scanner(System.in);
                    System.out.print("Enter directory: ");
                    String sourceDir = dir.nextLine();
                    System.out.print("Enter the archives saving directory: ");
                    String zipDir = dir.nextLine();

                    if (zipDir.equals(sourceDir)) {
                        throw new IOException();
                    }

                    File zip = new File(zipDir);
                    if (!zip.isDirectory() || zipDir.equals(sourceDir)) {
                        throw new NullPointerException();
                    }

                    String zipAudio = zipDir.concat("audios.zip");
                    String zipImg = zipDir.concat("images.zip");
                    String zipVideo = zipDir.concat("videos.zip");

                    Archiver archiver = new Archiver();
                    archiver.createArchive(sourceDir, zipAudio, zipImg, zipVideo);
                } else if (command == 2) {
                    System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid command entered. Try again:\n");
            } catch (NullPointerException n) {
                System.out.println("Invalid directory entered. Try again:\n");
            } catch (IOException e) {
                System.out.println("The directories are the same. Try again:\n");
            }
        }
    }
}