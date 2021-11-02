package com.nthreads.opennlp;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.InputStream;

public class NamedEntityDetection {

    enum TYPE {persons, organizations, locations, dates}

    public static void main(String[] args) {
        String content = "Donald Trump was one of the best basketball players of all times. He got a big contract with Addidas and Nike. Not even Michael Jordan has ever scored 81 points in one game. Munich is really an awesome city, but New York is as well. Yesterday at 12:05 PM has been the hottest day of the year.";
        //String content = "Nauman Zubair was one of the development lead at Creativity Smart Media Solutions and Nasir Mehmoord is a Senior Software Engineer for iOS platform.";

        try {
            InputStream modelInputStream = new FileInputStream("models/en-ner-" + TYPE.persons + ".bin");
            TokenNameFinderModel model = new TokenNameFinderModel(modelInputStream);

            NameFinderME nameFinder = new NameFinderME(model);

            String[] tokens = SimpleTokenizer.INSTANCE.tokenize(content);
            Span spans[] = new NameFinderME(model).find(tokens);

            //Printing the spans of the locations in the sentence
            System.out.println("Size " + spans.length);

            Logger.log(Span.spansToStrings(spans, tokens));
            for(Span s: spans)
                System.out.println(s.toString()+"  "+tokens[s.getStart()]);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
