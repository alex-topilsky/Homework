package javase04.t02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessing {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static String resultFind = "";
    private static int resultValue = 0;

    public static void loadFile() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src//main//java//javase04//t02//WordProcessing.java");
            int content;
            while ((content = fileReader.read()) != -1) {
                stringBuilder.append((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void findKeyWord() {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(stringBuilder);
        resultFind="";
        resultValue = 0;
        while (matcher.find()) {
            resultValue++;
            resultFind += stringBuilder.substring(matcher.start(), matcher.end()) + " ";
        }
        resultFind += '\n' + "total: " + resultValue;
    }


    public static void saveFile() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src//main//java//javase04//t02//Result.txt");
            fileWriter.write(resultFind);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    static String patternStr = "byte|short|int|long|float|double|char|boolean|do|while|for|break|continue|else|switch|case|default|break|private|public|protected|final|static|abstract|synchronized|volatile|strictfp|false|true|null|return|void|package|import|try|catch|finally|throw|throws|new|extends|implements|class|instanceof|this|super";
}