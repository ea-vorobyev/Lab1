package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        WriteTheWords writeTheWords = new WriteTheWords();

        File fileOne = new File("1.txt");
        OneRunnable oneRunnable = new OneRunnable(writeTheWords, fileOne);
        Thread one = new Thread(oneRunnable);
        one.start();

        System.out.println("");

        File fileTwo = new File("2.txt");
        TwoRunnable twoRunnable = new TwoRunnable(writeTheWords, fileTwo);
        Thread two = new Thread(twoRunnable);
        two.start();
    }

}
