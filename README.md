# Apache OpenNLP Models

NLP is a set of tools used to derive meaningful and useful information from natural language sources such as web pages
and text documents. Apache OpenNLP is an open-source Java library which is used to process natural language text. You
can build an efficient text processing service using this library.

## Step 1 : Installation of Apache OpenNLP Distribution

- Download [Apache OpenNLP distribution](https://dlcdn.apache.org/opennlp/opennlp-1.9.3/apache-opennlp-1.9.3-bin.zip)
- Extract the zip file
- Add `path-to/apache-opennlp-1.9.3/bin` in your Environment Variables

## Step 2

- Open this repo in any of your favorite IDE, i am using IntelliJ IDEA :)
- Add `opennlp-tools-1.9.3.jar` and `opennlp-uima-1.9.3.jar` in your project

## Step 3

Download the pre-trained models provided by Apache OpenNLP as follows

- Open `OpenNLPModelsDownloader.java` file in terminal and execute command with space separated all the models taken
  from [Apache OpenNLP](http://opennlp.sourceforge.net/models-1.5) website. You can download as many models as you want.

 ```
 java OpenNLPModelsDownloader.java da-sent.bin en-ner-person.bin  
 ```

## Step 4

Run `SentenceDetection` or `NamedEntityDetection` to test these model.




