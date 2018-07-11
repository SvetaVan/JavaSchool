package tasks.second.loggers;

import java.time.LocalDate;

public class Logger {
    private final int level;
    private int messageNumber;

    private static final int ERROR = 0;
    private static final int INFO = 10;
    private static final int DEBAG = 20;

    public Logger(int level, int messageNumber) {
        this(level);
        this.messageNumber = messageNumber;

    }

    public Logger(int level) {
        if (level == ERROR || level == INFO || level == DEBAG) {
            this.level = level;
        } else {
            throw new IllegalArgumentException("Please provide correct logger level");
        }
    }


    public void log(int level, String message) {
        if (level <= this.level) {
            System.out.println(String.format("%s %s %s: %s", messageNumber++, LocalDate.now().toString(), level, message));
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


}
