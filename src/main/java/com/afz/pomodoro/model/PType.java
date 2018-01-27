package com.afz.pomodoro.model;

public enum PType {

    FOCUS_TIME(25, "Focus Time"), // Focus Time
    SHORT_BREAK(5, "Short Break"), // Short break
    LONG_BREAK(15, "Long Break"); // Long break

    private int duration;
    private String displayName;

    private PType(int duration, String displayName) {
        this.duration = duration;
        this.displayName = displayName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDisplayName() {
        return displayName;
    }

}
