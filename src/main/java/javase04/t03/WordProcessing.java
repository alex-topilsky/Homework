package javase04.t03;

import java.io.*;

public class WordProcessing {
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void loadFile() {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream("src//main//java//javase04//t03//text8.txt");
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF8"));

            int content;
            while ((content = bufferedReader.read()) != -1) {
                stringBuilder.append((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveFile() {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = new FileOutputStream("src//main//java//javase04//t03//Result16.txt");
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-16"));
            bufferedWriter.append(stringBuilder.toString());
            bufferedWriter.flush();
        } catch (IOException ex) {
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
