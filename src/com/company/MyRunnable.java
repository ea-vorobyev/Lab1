package com.company;

public class MyRunnable implements Runnable {

    private final WorkWithFile workWithFile;

    public MyRunnable(WorkWithFile workWithFile) {
        this.workWithFile = workWithFile;
    }

    @Override
    public void run() {
        workWithFile.readFile();
    }

}
