package com.company;

import java.io.File;

public class Main extends Thread{

    public static void main(String[] args) {
        WriteTheWords writeTheWords = new WriteTheWords();
        File[] fileArray = new File[args.length];

        for(int i = 0; i<args.length; i++) {
            fileArray[i] = new File(args[i]);
            new Thread(
                    new MyRunnable(
                            new WorkWithFile(fileArray[i], writeTheWords)))
                    .start();
        }
    }

}
