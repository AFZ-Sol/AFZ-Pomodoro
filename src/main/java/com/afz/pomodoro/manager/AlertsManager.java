package com.afz.pomodoro.manager;

import com.afz.pomodoro.config.NotificationsSetting;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class AlertsManager {

    private static final String FOCUS_TIME_MESSAGE = "Focus time started";
    private static final String SHORT_BREAK_TIME_MESSAGE = "Short break time started";
    private static final String LONG_BREAK_TIME_MESSAGE = "Long break time started";

    private static final String FOCUS_TIME_SOUND = "Focus time Sound.mp3";
    private static final String SHORT_BREAK_TIME_SOUND = "Short break Sound.mp3";
    private static final String LONG_BREAK_TIME_SOUND = "Long break Sound.mp3";

    TrayNotification tray = new TrayNotification();

    public void focusTimeStarted() {
        if (NotificationsSetting.INSTANCE.isNotificationBeforeFocus()) {
            showTrayNotification(FOCUS_TIME_MESSAGE);
        }

        if (NotificationsSetting.INSTANCE.isSoundBeforeFocus()) {
            playSoundNotification(FOCUS_TIME_SOUND);
        }
    }

    public void shortBreakStarted() {
        if (NotificationsSetting.INSTANCE.isNotificationBeforeShortBreak()) {
            showTrayNotification(SHORT_BREAK_TIME_MESSAGE);
        }
        if (NotificationsSetting.INSTANCE.isSoundBeforeShortBreak()) {
            playSoundNotification(SHORT_BREAK_TIME_SOUND);
        }
    }

    public void longBreakStarted() {
        if (NotificationsSetting.INSTANCE.isNotificationBeforeLongBreak()) {
            showTrayNotification(LONG_BREAK_TIME_MESSAGE);

        }
        if (NotificationsSetting.INSTANCE.isSoundBeforeLongBreak()) {
            playSoundNotification(LONG_BREAK_TIME_SOUND);
        }
    }

    private void showTrayNotification(String message) {
        System.err.println("Tray : " + message);
        try {
            // Image whatsAppImg = new Image(
            // "https://cdn4.iconfinder.com/data/icons/iconsimple-logotypes/512/whatsapp-128.png");
            tray.setTitle("AFZ - Pomodoro");
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.INFORMATION);
            tray.setAnimationType(AnimationType.FADE);
            tray.showAndDismiss(Duration.seconds(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void playSoundNotification(String sound) {
        // TODO play sound notification
        System.err.println("Sound play : " + sound);
        AudioClip au = new AudioClip(getClass().getResource("/sounds/applause.mp3").toString());
        au.play();
    }
}
