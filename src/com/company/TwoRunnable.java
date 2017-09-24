package com.company;

import java.io.File;

public class TwoRunnable implements Runnable {
    private final WriteTheWords writeTheWords;
    private File newFile;

    public TwoRunnable(WriteTheWords writeTheWords, File newFile) {
        this.writeTheWords = writeTheWords;
        this.newFile = newFile;
    }

    @Override
    public void run() {
        WorkWithFile workWithFileTwo = new WorkWithFile(newFile, writeTheWords);
        workWithFileTwo.readFile();
    }
}
