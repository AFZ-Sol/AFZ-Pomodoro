package com.afz.pomodoro.config;

public class PomodoroSetting extends SharedSetting {

    private static final String FOCUS_TIME = "FOCUS_TIME";
    private static final String SHORT_BREAK = "SHORT_BREAK";
    private static final String LONG_BREAK = "LONG_BREAK";
    private static final String SESSIONS_BEFORE_LONG_BREAK = "SESSIONS_BEFORE_LONG_BREAK";
    private static final String SESSIONS_PER_DAY = "SESSIONS_PER_DAY";

    private int focusTime = 25; // 25 minutes
    private int shortBreak = 5; // 5 minutes
    private int longBreak = 15; // 15 minutes
    private int sessionsBeforeLongBreak = 4; // e.g. long break 4 sessions
    private int sessionsPerDay = 16; // e.g. 16 sessions for 8 hours

    public static final PomodoroSetting INSTANCE = new PomodoroSetting();

    private PomodoroSetting() {
        loadSetting();
    }

    public void update(int focusTime, int shortBreak, int longBreak, int sessionsBeforeLongBreak, int sessionsPerDay) {
        this.focusTime = focusTime;
        this.shortBreak = shortBreak;
        this.longBreak = longBreak;
        this.sessionsBeforeLongBreak = sessionsBeforeLongBreak;
        this.sessionsPerDay = sessionsPerDay;
        setChanged();
        notifyObservers();
    }

    private void loadSetting() {
        System.err.println("Loading pomodoro settings.");
        super.loadSettingFromFile();
        // TODO Read and validate settings
        focusTime = getIntProperty(FOCUS_TIME, focusTime);
        shortBreak = getIntProperty(SHORT_BREAK, shortBreak);
        longBreak = getIntProperty(LONG_BREAK, longBreak);
        sessionsBeforeLongBreak = getIntProperty(SESSIONS_BEFORE_LONG_BREAK, sessionsBeforeLongBreak);
        sessionsPerDay = getIntProperty(SESSIONS_PER_DAY, sessionsPerDay);
    }

    public void saveSetting() {
        // TODO Save curret settings in file
        saveProperty(FOCUS_TIME, Integer.toString(focusTime));
        saveProperty(SHORT_BREAK, Integer.toString(shortBreak));
        saveProperty(LONG_BREAK, Integer.toString(longBreak));
        saveProperty(SESSIONS_BEFORE_LONG_BREAK, Integer.toString(sessionsBeforeLongBreak));
        saveProperty(SESSIONS_PER_DAY, Integer.toString(sessionsPerDay));
        System.err.println("Saving pomodoro settings.");
        super.saveSettingInFile();
    }

    public int getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(int focusTime) {
        this.focusTime = focusTime;
    }

    public int getShortBreak() {
        return shortBreak;
    }

    public void setShortBreak(int shortBreak) {
        this.shortBreak = shortBreak;
    }

    public int getLongBreak() {
        return longBreak;
    }

    public void setLongBreak(int longBreak) {
        this.longBreak = longBreak;
    }

    public int getSessionsBeforeLongBreak() {
        return sessionsBeforeLongBreak;
    }

    public void setSessionsBeforeLongBreak(int sessionsBeforeLongBreak) {
        this.sessionsBeforeLongBreak = sessionsBeforeLongBreak;
    }

    public int getSessionsPerDay() {
        return sessionsPerDay;
    }

    public void setSessionsPerDay(int sessionsPerDay) {
        this.sessionsPerDay = sessionsPerDay;
    }

    @Override
    public String toString() {
        return "PomodoroSetting [focusTime=" + focusTime + ", shortBreak=" + shortBreak + ", longBreak=" + longBreak
                + ", roundsBeforeLongBreak=" + sessionsBeforeLongBreak + ", sessionsPerDay=" + sessionsPerDay + "]";
    }

}
