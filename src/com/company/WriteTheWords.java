package com.company;

import java.util.HashMap;
import java.util.Map;

public class WriteTheWords {
    private Map<String, Integer> words;
    private boolean stopMain = true;

    public WriteTheWords() {
        this.words = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getWords() {
        return words;
    }

    public synchronized boolean parseString(String line) {
        if(stopMain == false) {
            return false;
        }
        char[] charArray = null;
        line = line.replaceAll(",", "");
        String[] result = line.split(" ");
        for(String word: result) {
            charArray = word.toCharArray();
            for(char c: charArray) {
                int u = (int) c;
                if(((u >= 65) && (u <= 90)) || ((u >= 97) && (u <= 122))) {
                    System.out.println("Найден иностранный символ " + c);
                    stopMain = false;
                    return false;
                }
            }
            Integer value = words.get(word);
            if(value == null) {
                words.put(word, 1);
            }
            else {
                words.put(word, ++value);
            }
        }
        System.out.println(words);
        return true;
    }
}
