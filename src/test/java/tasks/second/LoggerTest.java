package tasks.second;

import org.junit.Assert;
import org.junit.Test;
import tasks.second.loggers.Logger;
import tasks.second.loggers.NameableLogger;
import tasks.second.loggers.RepeatableLogger;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class LoggerTest {


    @Test
    public void testLoggersLogAllLevels() {

        String message0 = "что-то поломалось...";
        String message1 = "что-то заработало...";
        String message2 = "что-то происходит...";
        //level 0
        {
            OutputStream outputStream = setOutStream();
            Logger logger0 = new Logger(0, 144);
            logger0.log(logger0.getLevel(), message0);
            Assert.assertTrue(outputStream.toString().contains("144 2018-07-11 0: что-то поломалось..."));

        }
        {
            OutputStream outputStream = setOutStream();
            Logger loggerNamed0 = new NameableLogger(0, "NamedLogger");
            loggerNamed0.log(loggerNamed0.getLevel(), message0);
            Assert.assertTrue(outputStream.toString().contains("NamedLogger: 0 2018-07-11 0: что-то поломалось..."));

        }
        {
            OutputStream outputStream = setOutStream();
            Logger repeatableLogger0 = new RepeatableLogger(0, 2);
            repeatableLogger0.log(repeatableLogger0.getLevel(), message0);
            Assert.assertTrue(outputStream.toString().contains("0 2018-07-11 0: что-то поломалось...\n1 2018-07-11 0: что-то поломалось...\n"));
        }
        //level 10
        {
            OutputStream outputStream = setOutStream();
            Logger logger10 = new Logger(10, 144);
            logger10.log(logger10.getLevel(), message1);
            Assert.assertTrue(outputStream.toString().contains("144 2018-07-11 10: что-то заработало..."));
        }
        {
            OutputStream outputStream = setOutStream();
            Logger loggerNamed10 = new NameableLogger(10, "NamedLogger");
            loggerNamed10.log(loggerNamed10.getLevel(), message1);
            Assert.assertTrue(outputStream.toString().contains("NamedLogger: 0 2018-07-11 10: что-то заработало..."));

        }
        {
            OutputStream outputStream = setOutStream();
            Logger repeatableLogger10 = new RepeatableLogger(10, 2);
            repeatableLogger10.log(repeatableLogger10.getLevel(), message1);
            Assert.assertTrue(outputStream.toString().contains("0 2018-07-11 10: что-то заработало...\n1 2018-07-11 10: что-то заработало...\n"));
        }
        //level 20
        {
            OutputStream outputStream = setOutStream();
            Logger logger10 = new Logger(20, 144);
            logger10.log(logger10.getLevel(), message2);
            Assert.assertTrue(outputStream.toString().contains("144 2018-07-11 20: что-то происходит..."));
        }
        {
            OutputStream outputStream = setOutStream();
            Logger loggerNamed10 = new NameableLogger(20, "NamedLogger");
            loggerNamed10.log(loggerNamed10.getLevel(), message2);
            Assert.assertTrue(outputStream.toString().contains("NamedLogger: 0 2018-07-11 20: что-то происходит..."));

        }
        {
            OutputStream outputStream = setOutStream();
            Logger repeatableLogger10 = new RepeatableLogger(20, 2);
            repeatableLogger10.log(repeatableLogger10.getLevel(), message2);
            Assert.assertTrue(outputStream.toString().contains("0 2018-07-11 20: что-то происходит...\n1 2018-07-11 20: что-то происходит...\n"));
        }
    }

    @Test
    public void loggerToString(){
        Logger logger0 = new Logger(0, 144);
        Logger loggerNamed0 = new NameableLogger(0, "NamedLogger");
        Logger repeatableLogger10 = new RepeatableLogger(0, 2);
        Assert.assertEquals("Logger{level=0, messageNumber=144}", logger0.toString());
        Assert.assertEquals("NamedLogger, LOGGER{LEVEL=0, MESSAGENUMBER=0} ",loggerNamed0.toString());
        Assert.assertEquals("Logger{level=0, messageNumber=0}, repeat number - 2 ", repeatableLogger10.toString());
    }


    @Test(expected = IllegalArgumentException.class)
    public void loggerException() {
        Logger logger = new Logger(13, 0);
    }



    public static OutputStream setOutStream(){
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        return outputStream;
    }


}
