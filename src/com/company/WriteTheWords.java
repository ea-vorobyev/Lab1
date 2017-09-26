package com.company;

import java.util.HashMap;
import java.util.Map;

public class WriteTheWords {
    private Map<String, Integer> words;
    private boolean stopStream;
    private int inc;

    public WriteTheWords() {
        this.words = new HashMap<String, Integer>();
    }

    private String replace(String line) {
        line = line.replaceAll("[0-9]+","");
        line = line.replaceAll("[^А-Яа-яёA-Za-z]", " ");
        return line;
    }

    private synchronized void getWords() {
        System.out.println(words + " " + inc);
    }

    private synchronized void addWord(String word) {
        if(!word.equals("")) {
            inc++;
            Integer value = words.get(word);
            if(value == null) {
                words.put(word, 1);
            }
            else {
                words.put(word, ++value);
            }
        }
    }

    public boolean parseString(String line) {
        line = replace(line);
        String[] result = line.split(" ");
        for(String word: result) {
            char[] charArray = word.toCharArray();
            for(char c: charArray) {
                int charIndex = (int) c;
                if(((charIndex >= 65) && (charIndex <= 90)) || ((charIndex >= 97) && (charIndex <= 122))) {
                    System.out.println("Найден иностранный символ " + " '" + c + "' ");
                    stopStream = true;
                    return true;
                }
            }
            if(stopStream) {
                return stopStream;
            }
            addWord(word);
        }
        //System.out.println(words); //ConcurrentModificationException
        getWords();
        return stopStream;
    }

}
