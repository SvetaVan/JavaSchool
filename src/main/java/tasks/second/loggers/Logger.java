package tasks.second.loggers;

import java.time.LocalDate;

public class Logger {
    private int level;//do i need to make it final?
    private int messageNumber;

    public static final int ERROR = 0;
    public static final int INFO = 10;
    public static final int DEBAG = 20;

    public Logger(int level, int messageNumber) {
        if (level == ERROR || level == INFO || level == DEBAG) {
            this.level = level;
            this.messageNumber = messageNumber;
        } else {
            throw new IllegalArgumentException("Please provide correct logger level");
        }
    }

    //как избежать дублирования кода?
    public Logger(int level) {
        if (level == ERROR || level == INFO || level == DEBAG) {
            this.level = level;
        } else {
            throw new IllegalArgumentException("Please provide correct logger level");
        }
    }

    public Logger() {
    }

    public void log(int level, String message) {
        if (level <= this.level) {
            System.out.println(String.format("%s %s %s: %s", messageNumber, LocalDate.now().toString(), level, message));
        }
    }


    @Override
    public String toString() {
        return "Logger{" +
                "level=" + level +
                ", messageNumber=" + messageNumber +
                '}';
    }

    public int getLevel() {
        return level;
    }

    public int getMessageNumber() {
        return messageNumber;
    }
}
