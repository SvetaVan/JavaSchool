package tasks.second.loggers;

public class NameableLogger extends Logger {
    private String loggerName;

    public NameableLogger(int level, String loggerName){
        super(level);
        this.loggerName = loggerName;
    }


    @Override
    public void log(int level, String message) {
        System.out.print(String.format("%s: ", this.loggerName));
        super.log(level, message);
    }

    @Override
    public String toString() {
        return String.format("%s, %S ", this.loggerName,super.toString());
    }



}
