package com.afz.pomodoro.manager;

import com.afz.pomodoro.config.NotificationsSetting;

public class AlertsManager {

    private static final String FOCUS_TIME_SOUND = "FocusSound.mp3";
    private static final String FOCUS_TIME_MESSAGE = "Focus time started";

    public void focusTimeStarted() {
        if (NotificationsSetting.INSTANCE.isNotificationBeforeFocus()) {
            showTrayNotification(FOCUS_TIME_MESSAGE);
        }

        if (NotificationsSetting.INSTANCE.isSoundBeforeFocus()) {
            showTrayNotification(FOCUS_TIME_SOUND);
        }
    }

    public void shortBreakStarted() {

    }

    public void longBreakStarted() {

    }

    private void showTrayNotification(String message) {
        // TODO show system tray notification
        System.err.println("Tray : " + message);
    }

    private void showSoundNotification(String sound) {
        // TODO play sound notification
        System.err.println("Sound play : " + sound);
    }
}
