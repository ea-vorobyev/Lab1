package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class WorkWithFile {
    private File file;
    private WriteTheWords writeTheWords;
    private boolean stopMain = true;

    public WorkWithFile(File file, WriteTheWords writeTheWords) {
        this.file = file;
        this.writeTheWords = writeTheWords;
    }

    public void readFile() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while((line = bufferedReader.readLine()) != null || stopMain != false) {
                //System.out.println(line);
                stopMain = writeTheWords.parseString(line);
            }
            bufferedReader.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
