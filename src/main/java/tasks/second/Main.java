package tasks.second;

import tasks.second.loggers.Logger;
import tasks.second.loggers.NameableLogger;
import tasks.second.loggers.RepeatableLogger;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger(20, 1);
        System.out.println("log for usual logger");
        logger.log(logger.getLevel(), "что-то заработало...");
        System.out.println("toString for usual logger");
        System.out.println(logger.toString());

        System.out.println();

        Logger loggerNamed = new NameableLogger(0, "SuperLogger");
        System.out.println("log for named logger");
        loggerNamed.log(loggerNamed.getLevel(), "что-то поломалось...");
        System.out.println("toString for named logger");
        System.out.println(loggerNamed.toString());

        System.out.println();

        Logger repeatableLogger = new RepeatableLogger(10, 10);
        System.out.println("log for rep logger");
        repeatableLogger.log(repeatableLogger.getLevel(), "что-то происходит...");
        System.out.println("toString for rep logger");
        System.out.println(repeatableLogger.toString());
    }

}
