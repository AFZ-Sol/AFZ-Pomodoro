package com.afz.pomodoro.manager;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.model.PSession;
import com.afz.pomodoro.model.PType;

public class PomodoroManager {

    private static final int SECONDS_PER_MINUTE = 60;

    private int goalSessions = 0;
    private int todaySessions = 0;

    private PSession currentSession;

    public PomodoroManager() {
        initSettings();
        prepareSession(PType.FOCUS_TIME);
    }

    private void initSettings() {
        // TODO read pomodoro settings from config file
        // readConfigFile();
    }

    private void prepareSession(PType pType) {
        currentSession = new PSession("TODO", pType.getDuration() * SECONDS_PER_MINUTE, pType);
    }

    ////////////////////////////////////////////////////////////////

    public String getCurrentTitle() {
        return currentSession.getType().getDisplayName();
    }

    public String getRemainingTime() {
        int seconds = currentSession.getRemainingSeconds() % 60;
        int minutes = currentSession.getRemainingSeconds() / 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    public String getGoalSessions() {
        return String.format("%d/%d", goalSessions, PomodoroSetting.INSTANCE.getSessionsBeforeLongBreak());
    }

    public String getTodaySessions() {
        return String.format("%d/%d", todaySessions, PomodoroSetting.INSTANCE.getSessionsPerDay());
    }

}
