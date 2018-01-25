package com.afz.pomodoro.model;

public class PSession {
    private String taskName;
    /**
     * Remaining time for this session in seconds
     */
    private int remainingSeconds;

    private PType type;

    public PSession(String taskName, int remainingSeconds, PType type) {
        super();
        this.taskName = taskName;
        this.remainingSeconds = remainingSeconds;
        this.type = type;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }

    public PType getType() {
        return type;
    }

    public void setType(PType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PSession [taskName=" + taskName + ", remainingSeconds=" + remainingSeconds + ", type=" + type + "]";
    }

}
