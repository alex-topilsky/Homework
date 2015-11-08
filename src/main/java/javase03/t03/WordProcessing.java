package javase03.t03;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.System.out;

public class WordProcessing {
    static StringBuilder text = new StringBuilder();

    //Строка для паттерна поиска ссылки на рисунок
    static String stringPatternRis = "(\\([р|Р]ис.[\\s|\\S]\\d.?\\))|(\\([р|Р]ис.[\\s|\\S]\\d.+?\\))";
    //Строка для паттерна поиска предложений
    static String stringPatternOffer = "(^|(?<=[.!?]\\s))(\\d+\\.\\s?)*[А-ЯA-Z][^!?]*?[.!?](?=\\s*(\\d+\\.\\s)*[А-ЯA-Z]|$)";
    //Строка для паттерна поиска номера рисунка
    static String stringPatternNumber = "\\d";
    //Строка для паттерна удаления мешающей html-разметки
    static String stringPatternHtml ="(<[\\/\\!]*?[^<>]*?>)|\\&.+?\\;";

    static Pattern patternRis = Pattern.compile(stringPatternRis);
    static Pattern patternOffer = Pattern.compile(stringPatternOffer);
    static Pattern patternNumber = Pattern.compile(stringPatternNumber);
    static Pattern patternHtml = Pattern.compile(stringPatternHtml);

    public static void LoadFile() {
        String str;
        try {
            FileInputStream in = new FileInputStream(new File("src\\main\\resources\\Java.SE.03.Information handling_task_attachment.html"));
            BufferedReader bufRead = new BufferedReader(new InputStreamReader(in, "Cp1251"));
            while ((str = bufRead.readLine()) != null) {
                text.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void find() {
        int i = 0;
        int numberRis = Integer.MIN_VALUE;
        Matcher matcherRis = patternRis.matcher(text);
        Matcher matcherNumber;
        boolean sequenceIsBroken = false;
        String resultFind = "";

        while (matcherRis.find()) {
            //Сохраняем найденную ссылку на рисунок
            resultFind = matcherRis.group();
            //Ищем в ней номер рисунка
            matcherNumber = patternNumber.matcher(resultFind);
            matcherNumber.find();
            //Если нарушения последовательности еще не было
            if (!sequenceIsBroken) {
                //Если найденный номер меньше предыдущего
                if (numberRis > Integer.parseInt(matcherNumber.group())) {
                    //Отмечаем, что последовательность была нарушена
                    sequenceIsBroken = true;
                } else {
                    numberRis = Integer.parseInt(matcherNumber.group());
                }
            }
            i++;
        }

        if (sequenceIsBroken) out.println("Последовательность была нарушена!");
        else out.println("Последовательность не была нарушена!");

        System.out.println("В тексте на рисунок ссылаются " + i + " раз.");
        System.out.println();
    }

    public static void group() {
        int i = 0;
        Matcher matcherRis;
        Matcher matcherHtml = patternHtml.matcher(text);
        String textWithoutHtml = matcherHtml.replaceAll("");
        Matcher matcherOffer = patternOffer.matcher(textWithoutHtml);

        //Разделяем текст на предложения
        while (matcherOffer.find()) {
            //В предложениях ищем ссылки на рисунки, и, если они найдены, выводим всё предложение
            matcherRis = patternRis.matcher(matcherOffer.group());
            if(matcherRis.find()) {
                out.println(matcherOffer.group());
                i++;
            }
        }
        out.println("Всего найдено предложений с ссылками на рисунки: "+i);
    }
}
