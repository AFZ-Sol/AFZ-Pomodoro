package com.afz.pomodoro.model;

public class PSession {
    private String taskName;
    /**
     * Remaining time for this session in seconds
     */
    private int remainingDuration;

    private PType type;

    public PSession(String taskName, int remainingDuration, PType type) {
        super();
        this.taskName = taskName;
        this.remainingDuration = remainingDuration;
        this.type = type;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getRemainingDuration() {
        return remainingDuration;
    }

    public void setRemainingDuration(int remainingDuration) {
        this.remainingDuration = remainingDuration;
    }

    public PType getType() {
        return type;
    }

    public void setType(PType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PSession [taskName=" + taskName + ", remainingDuration=" + remainingDuration + ", type=" + type + "]";
    }

}
