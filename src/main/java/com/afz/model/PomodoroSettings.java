package com.afz.model;

public class PomodoroSettings {

    private int focusTime = 25; // 25 minutes
    private int shortBreak = 5; // 5 minutes
    private int longBreak = 15; // 15 minutes
    private int roundsBeforeLongBreak = 4; // e.g. long break 4 sessions
    private int sessionsPerDay = 16; // e.g. 16 sessions for 8 hours

    /**
     * Show tray notifications
     */
    private boolean notificationAfterFocus = true;
    private boolean notificationAfterBreak = true;

    /**
     * Play sound notifications
     */
    private boolean soundAfterFocus = false;
    private boolean soundAfterBreak = false;

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

    public boolean isNotificationAfterFocus() {
        return notificationAfterFocus;
    }

    public void setNotificationAfterFocus(boolean notificationAfterFocus) {
        this.notificationAfterFocus = notificationAfterFocus;
    }

    public boolean isNotificationAfterBreak() {
        return notificationAfterBreak;
    }

    public void setNotificationAfterBreak(boolean notificationAfterBreak) {
        this.notificationAfterBreak = notificationAfterBreak;
    }

    public boolean isSoundAfterFocus() {
        return soundAfterFocus;
    }

    public void setSoundAfterFocus(boolean soundAfterFocus) {
        this.soundAfterFocus = soundAfterFocus;
    }

    public boolean isSoundAfterBreak() {
        return soundAfterBreak;
    }

    public void setSoundAfterBreak(boolean soundAfterBreak) {
        this.soundAfterBreak = soundAfterBreak;
    }

    @Override
    public String toString() {
        return "PomodoroSettings [focusTime=" + focusTime + ", shortBreak=" + shortBreak + ", longBreak=" + longBreak
                + ", roundsBeforeLongBreak=" + roundsBeforeLongBreak + ", sessionsPerDay=" + sessionsPerDay
                + ", notificationAfterFocus=" + notificationAfterFocus + ", notificationAfterBreak="
                + notificationAfterBreak + ", soundAfterFocus=" + soundAfterFocus + ", soundAfterBreak="
                + soundAfterBreak + "]";
    }

}
