package com.afz.pomodoro.manager;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import com.afz.pomodoro.config.NotificationsSetting;

import javafx.application.Platform;

public class AlertsManager {

    private static final String FOCUS_TIME_SOUND = "FocusSound.mp3";
    private static final String FOCUS_TIME_MESSAGE = "Focus time started";

    private static final String SHORT_BREAK_TIME_SOUND = "FocusSound.mp3";
    private static final String SHORT_BREAK_TIME_MESSAGE = "Short break time started";

    private static final String LONG_BREAK_TIME_SOUND = "FocusSound.mp3";
    private static final String LONG_BREAK_TIME_MESSAGE = "Long break time started";

    private static TrayIcon trayIcon;

    public void focusTimeStarted() {
        if (NotificationsSetting.INSTANCE.isNotificationBeforeFocus()) {
            showTrayNotification(FOCUS_TIME_MESSAGE);
        }

        if (NotificationsSetting.INSTANCE.isSoundBeforeFocus()) {
            showTrayNotification(FOCUS_TIME_SOUND);
        }
    }

    public void shortBreakStarted() {
        if (NotificationsSetting.INSTANCE.isNotificationBeforeShortBreak()) {
            showTrayNotification(SHORT_BREAK_TIME_MESSAGE);
        }
        if (NotificationsSetting.INSTANCE.isSoundBeforeShortBreak()) {
            showSoundNotification(SHORT_BREAK_TIME_SOUND);
        }
    }

    public void longBreakStarted() {
        if (NotificationsSetting.INSTANCE.isNotificationBeforeLongBreak()) {
            showTrayNotification(LONG_BREAK_TIME_MESSAGE);
        }
        if (NotificationsSetting.INSTANCE.isSoundBeforeLongBreak()) {
            showSoundNotification(LONG_BREAK_TIME_SOUND);
        }
    }

    private void showTrayNotification(String message) {
        // TODO show system tray notification
        System.err.println("Tray : " + message);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                trayIcon.displayMessage("AFZ-Pomodoro", message, TrayIcon.MessageType.INFO);
            }
        });

    }

    private void showSoundNotification(String sound) {
        // TODO play sound notification
        System.err.println("Sound play : " + sound);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                trayIcon.displayMessage("AFZ-Pomodoro", sound, TrayIcon.MessageType.INFO);
            }
        });
    }
}
