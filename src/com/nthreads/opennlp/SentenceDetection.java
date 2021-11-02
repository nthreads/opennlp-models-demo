package com.nthreads.opennlp;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.nthreads.opennlp.Logger.log;

public class SentenceDetection {
    public static void main(String[] args) {
        String paragraph = "Hello, How are you? Welcome to nthreads.com";

        Logger.log(usingOpenNLP(paragraph));

    }


    private static String[] usingJavaRegularExp(String paragraph) {
        String simple = "[.?!]";
        return (paragraph.split(simple));
    }

    private static String[] usingOpenNLP(String paragraph) {
        //Loading sentence detector model
        String[] sentences = new String[]{};

        try {
            InputStream inputStream = new FileInputStream("models/da-sent.bin");
            SentenceModel model = new SentenceModel(inputStream);

            SentenceDetectorME detector = new SentenceDetectorME(model);

            sentences = detector.sentDetect(paragraph);

            //Span[] spans = detector.sentPosDetect(paragraph);
            //print(spans);

            //Getting the probabilities of the last decoded sequence
            //double[] probs = detector.getSentenceProbabilities();
            //print(probs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sentences;
    }


}
