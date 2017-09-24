package com.company;

import java.io.File;

public class OneRunnable implements Runnable {
    private final WriteTheWords writeTheWords;
    private File newFile;

    public OneRunnable(WriteTheWords writeTheWords, File newFile) {
        this.writeTheWords = writeTheWords;
        this.newFile = newFile;
    }

    @Override
    public void run() {
        WorkWithFile workWithFileOne = new WorkWithFile(newFile, writeTheWords);
        workWithFileOne.readFile();
    }
}
