package com.afz.pomodoro.config;

public class PomodoroSetting {

    private int focusTime = 25; // 25 minutes
    private int shortBreak = 5; // 5 minutes
    private int longBreak = 15; // 15 minutes
    private int roundsBeforeLongBreak = 4; // e.g. long break 4 sessions
    private int sessionsPerDay = 16; // e.g. 16 sessions for 8 hours

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

    public int getRoundsBeforeLongBreak() {
        return roundsBeforeLongBreak;
    }

    public void setRoundsBeforeLongBreak(int roundsBeforeLongBreak) {
        this.roundsBeforeLongBreak = roundsBeforeLongBreak;
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
                + ", roundsBeforeLongBreak=" + roundsBeforeLongBreak + ", sessionsPerDay=" + sessionsPerDay + "]";
    }

}
