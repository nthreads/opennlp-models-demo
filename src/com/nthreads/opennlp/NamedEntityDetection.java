package com.nthreads.opennlp;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.InputStream;

public class NamedEntityDetection {

    enum TYPE {persons, locations, dates, time}

    public static void main(String[] args) {
        String content = "Kobe Bryant was one of the best basketball players of all times. He got a big contract with Addidas and Nike. Not even Michael Jordan has ever scored 81 points in one game. Munich is really an awesome city, but New York is as well. Yesterday at 12:05 PM has been the hottest day of the year.";

        try {
            InputStream modelInputStream = new FileInputStream("models/en-ner-" + TYPE.persons + ".bin");
            TokenNameFinderModel model = new TokenNameFinderModel(modelInputStream);

            NameFinderME nameFinder = new NameFinderME(model);

            String[] tokens = SimpleTokenizer.INSTANCE.tokenize(content);
            Span spans[] = new NameFinderME(model).find(tokens);


            Logger.log(Span.spansToStrings(spans, tokens));

            /*for(Span s: spans)
                System.out.println(s.toString()+"  "+tokens[s.getStart()]);*/



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
