package javase03.t01;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

public class CrazyLogger {
    private StringBuilder logger;
    private SimpleDateFormat dateFormat;
    private StringBuilder result;

    public CrazyLogger() {
        logger = new StringBuilder();
        dateFormat = new SimpleDateFormat("dd-MM-YYYY : HH-mm - ");
    }

    public CrazyLogger(StringBuilder message) {
        logger = new StringBuilder(message);
        dateFormat = new SimpleDateFormat("dd-MM-YYYY : HH-mm - ");
    }

    public void addMessage(StringBuilder message) {
        Date data = new Date();
        logger.append(dateFormat.format(data));
        logger.append(message);
        logger.append('\n');
    }

    public void showAllMessage() {
        out.println(logger);
    }

    public void searchMessagesByKeyword(String keyword) {
        searchMessages(keyword);
    }

    public void searchMessagesByDate(Date keyDate) {
        searchMessages(dateFormat.format(keyDate));
    }

    private void searchMessages(String keyword) {
        result = new StringBuilder();
        String subStr;
        int start = 0;
        int end = 0;
        for (int i = 0; i < logger.length(); i++) {
            if (logger.charAt(i) == '\n') {
                end = i;
                subStr = logger.substring(start, end);

                if (subStr.indexOf(keyword) != -1) {
                    result.append(subStr);
                    result.append('\n');
                }
                start = i + 1;
            }
        }

        if (result.length() == 0) {
            out.println("Поиск по ключевому слову ("+keyword+") не дал результатов");
        } else {
            out.println("Результаты по вашему запросу:("+keyword+")");
            out.println(result);
        }
    }
}
