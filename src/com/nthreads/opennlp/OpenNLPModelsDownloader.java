package com.nthreads.opennlp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class OpenNLPModelsDownloader {
    public static void main(String[] args) {

        if(args.length == 0) {
            args = new String[]{"en-ner-person.bin", "en-ner-location.bin", "en-ner-date.bin"};
        }

        System.out.println("Downloading models!");

        try {
            new OpenNLPModelsDownloader().execute(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void execute(String[] args) throws IOException {

        File file = new File("../../../../models");
        Path configDirectoryPath = file.toPath();
        if (!Files.exists(configDirectoryPath)) {
            Files.createDirectories(configDirectoryPath);
        }

        String baseUrl = "http://opennlp.sourceforge.net/models-1.5/";
        for (String arg : args) {
            try {
                download(baseUrl + arg, configDirectoryPath.resolve(arg));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }


    }

    private void download(String url, Path filename) throws Exception {
        System.out.print("Downloading " + filename.getFileName() + " model... ");
        if (Files.exists(filename)) {
            System.out.println("not downloading, existed already.");
        } else {
            URLConnection connection = new URL(url).openConnection();
            connection.connect();

            try (InputStream inputStream = connection.getInputStream()) {
                Files.copy(inputStream, filename);
            }
            System.out.println("done");
        }
    }
}
