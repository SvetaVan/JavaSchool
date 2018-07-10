package tasks.second.loggers;

public class RepeatableLogger extends Logger {
    private int repeats;

    public RepeatableLogger(int level, int repeats) {
        super(level);
        this.repeats = repeats;
    }

    @Override
    public void log(int level, String message) {
        for (int i = 0; i < repeats; i++) {
            super.log(level, message);
        }
    }

    @Override
    public String toString() {
        return String.format("%s, repeat number - %s ", super.toString(), repeats);
    }





}
