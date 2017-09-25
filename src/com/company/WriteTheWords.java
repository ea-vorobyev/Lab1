package com.company;

import java.util.HashMap;
import java.util.Map;

public class WriteTheWords {
    private Map<String, Integer> words;
    private boolean stopMain;
    private int inc;

    public WriteTheWords() {
        this.words = new HashMap<String, Integer>();
    }

    public void setWords(Map<String, Integer> words) {
        this.words = words;
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    private String replace(String line) {
        line = line.replaceAll(",", "");
        line = line.replaceAll("[0-9]+","");
        //остальные символы
        return line;
    }

    public synchronized boolean parseString(String line) {
        line = replace(line);
        String[] result = line.split(" ");
        for(String word: result) {
            inc++;
            char[] charArray = word.toCharArray();
            for(char c: charArray) {
                int u = (int) c;
                if(((u >= 65) && (u <= 90)) || ((u >= 97) && (u <= 122))) {
                    System.out.println("Найден иностранный символ " + " '" + c + "' ");
                    stopMain = true;
                    return true;
                }
            }
            if(stopMain) {
                return stopMain;
            }
            //synchronized (this) {
                Integer value = words.get(word);
                if(value == null) {
                    words.put(word, 1);
                }
                else {
                    words.put(word, ++value);
                }
            //}
        }
        System.out.println(getWords() + " " + inc);
        return stopMain;
    }

}
