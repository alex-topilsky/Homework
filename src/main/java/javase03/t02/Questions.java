package javase03.t02;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.lang.System.out;

public class Questions {
    private static char choice = 0;
    private static ResourceBundle rb;

    public static void question() {
        String country = "", language = "";
        out.println("1 – Русский");
        out.println("2 – Английский");
        choice = 0;
        try {
            choice = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice) {
            case '1': {
                country = "ru";
                language = "RU";
                break;
            }
            case '2': {
                country = "US";
                language = "EN";
                break;
            }
            default:
            {
                out.println("Произошла ошибка ввода! Выбран Русский язык.");
                country = "ru";
                language = "RU";
                break;
            }
        }

        Locale current = new Locale(language, country);
        rb = ResourceBundle.getBundle("Questions", current);

        try {
            String questions = new String(rb.getString("questions1").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("questions2").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("questions3").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("questions4").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("questions5").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("questions6").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("questions7").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("questions8").getBytes("ISO-8859-1"));
            out.println(questions);
            questions = new String(rb.getString("help").getBytes("ISO-8859-1"));
            out.println(questions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void answer() {
        do {
            try {
                choice = (char) System.in.read();
            } catch (IOException e) {
                e.getMessage();
            }

            try {
                {
                    String answer;
                    switch (choice) {
                        case '1':
                            answer = new String(rb.getString("answer1").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                        case '2':
                            answer = new String(rb.getString("answer2").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                        case '3':
                            answer = new String(rb.getString("answer3").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                        case '4':
                            answer = new String(rb.getString("answer4").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                        case '5':
                            answer = new String(rb.getString("answer5").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                        case '6':
                            answer = new String(rb.getString("answer6").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                        case '7':
                            answer = new String(rb.getString("answer7").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                        case '8':
                            answer = new String(rb.getString("answer8").getBytes("ISO-8859-1"));
                            out.println(answer);
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice != '0');
    }
}
