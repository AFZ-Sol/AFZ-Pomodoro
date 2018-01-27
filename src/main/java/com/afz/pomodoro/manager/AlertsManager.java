package com.afz.pomodoro.manager;

import java.awt.CheckboxMenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import com.afz.pomodoro.config.NotificationsSetting;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.media.AudioClip;

public class AlertsManager {

    private static final String FOCUS_TIME_MESSAGE = "Focus time started";
    private static final String SHORT_BREAK_TIME_MESSAGE = "Short break time started";
    private static final String LONG_BREAK_TIME_MESSAGE = "Long break time started";

    private static final String FOCUS_TIME_SOUND = "Focus time Sound.mp3";
    private static final String SHORT_BREAK_TIME_SOUND = "Short break Sound.mp3";
    private static final String LONG_BREAK_TIME_SOUND = "Long break Sound.mp3";

    private static TrayIcon trayIcon;
    private static SystemTray tray;

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
        // TODO show system tray notification
        System.err.println("Tray : " + message);

        try {

            if (SystemTray.isSupported()) {
                tray = SystemTray.getSystemTray();
                BufferedImage image = ImageIO
                        .read(new URL("http://icons.iconarchive.com/icons/ampeross/qetto-2/128/clock-icon.png"));

                trayIcon = new TrayIcon(image, "AFZ - Pomodoro", null);
                tray.add(trayIcon);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        trayIcon.displayMessage("AFZ - Pomodoro", message, TrayIcon.MessageType.INFO);

                    }
                });
            }

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
