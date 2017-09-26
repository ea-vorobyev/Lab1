package com.company;

import java.io.*;

public class WorkWithFile {

    private File file;
    private WriteTheWords writeTheWords;
    private boolean stopStream;

    public WorkWithFile(File file, WriteTheWords writeTheWords) {
        this.file = file;
        this.writeTheWords = writeTheWords;
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null && !stopStream) {
                stopStream = writeTheWords.parseString(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
