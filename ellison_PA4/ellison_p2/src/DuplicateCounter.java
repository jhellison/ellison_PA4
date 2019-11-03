import java.util.*;
import java.io.*;

public class DuplicateCounter {

    private static Map<String, Integer> wordCounter;

    public void count(String dataFile) throws IOException
    {
    String wordstringcounter;
    wordCounter = new HashMap<String,Integer>();
    Scanner scnr =new Scanner(new File(dataFile));
    // the set will only store unique words
    while(scnr.hasNext())
    {
        wordstringcounter=scnr.next();
        if (wordCounter.containsKey(wordstringcounter))
        {
            wordCounter.put(wordstringcounter,wordCounter.get(wordstringcounter) + 1);
        }

        else
        {
            wordCounter.put(wordstringcounter, 1);
        }
    }
        scnr.close();
    }

    public void write(String outputFile) throws IOException
    {
       File file;
       FileWriter filewriter = null;
       file = new File(outputFile);
       if(!file.exists())
        {
            file.createNewFile();
        }
       filewriter = new FileWriter(file);
       for (Map.Entry Entry : wordCounter.entrySet())
        {
            filewriter.write(Entry.getKey() + ":" + Entry.getValue()+"\n");
        }
       filewriter.close();
        }
    }

