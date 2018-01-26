package com.afz.pomodoro.manager;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.model.PSession;
import com.afz.pomodoro.model.PType;

public class PomodoroManager {

    private static final int SECONDS_PER_MINUTE = 60;

    private int goalSessions = 0;
    private int todaySessions = 0;

    private PSession currentSession;

    private AlertsManager alerts = new AlertsManager();

    public PomodoroManager() {
        initSettings();
        prepareSession(PType.FOCUS_TIME);
    }

    private void initSettings() {
        // TODO read pomodoro settings from config file
        // readConfigFile();
    }

    private void prepareSession(PType pType) {
        currentSession = new PSession("TODO", pType.getDuration(), pType);
    }

    public void onFinished() {

        PType nextSessionType;

        if (currentSession.getType() == PType.FOCUS_TIME) {

            if (goalSessions == PomodoroSetting.INSTANCE.getSessionsBeforeLongBreak() - 1) {
                // Start long break
                nextSessionType = PType.LONG_BREAK;
            } else {
                nextSessionType = PType.SHORT_BREAK;
            }
        } else {
            todaySessions++;
            goalSessions++;
            if (currentSession.getType() == PType.LONG_BREAK) {
                goalSessions = 0;
            }
            nextSessionType = PType.FOCUS_TIME;
        }
        triggerAlerts(nextSessionType);
        prepareSession(nextSessionType);

    }

    ////////////////////////////////////////////////////////////////

    private void triggerAlerts(PType nextSessionType) {

        if (nextSessionType == PType.FOCUS_TIME) {
            alerts.focusTimeStarted();
        } else if (nextSessionType == PType.SHORT_BREAK) {
            alerts.shortBreakStarted();
        } else if (nextSessionType == PType.LONG_BREAK) {
            alerts.longBreakStarted();
        }

    }

    public String getCurrentTitle() {
        return currentSession.getType().getDisplayName();
    }

    public int getCurrentSessionSeconds() {
        return currentSession.getRemainingSeconds();
    }

    public void tick() {
        currentSession.tick();
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
