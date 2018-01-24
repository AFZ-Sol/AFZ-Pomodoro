package com.afz.pomodoro.ui;

import com.afz.pomodoro.config.NotificationsSetting;
import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.constants.AppConstants;
import com.jfoenix.controls.JFXToggleButton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NotificationSettingUI extends BaseSettingUI {

    JFXToggleButton tbNotificationBeforeFocus;
    JFXToggleButton tbNotificationBeforeShortBreak;
    JFXToggleButton tbNotificationBeforeLongBreak;

    JFXToggleButton tbSoundBeforeFocus;
    JFXToggleButton tbSoundBeforeShortBreak;
    JFXToggleButton tbSoundBeforeLongBreak;

    public void createNotificationSettingDailog() {

        GridPane gridpane = new GridPane();
        gridpane.setHgap(20);
        gridpane.setPadding(new Insets(20, 20, 20, 20));

        Label lblShowTrayNotifications = createLabel("Show Tray Notifications :");
        Label lblPlaySoundNotifications = createLabel("Play Sound Notifications :");

        tbNotificationBeforeFocus = createToggleButton("Before Focus Time");
        tbNotificationBeforeShortBreak = createToggleButton("Before Short Break");
        tbNotificationBeforeLongBreak = createToggleButton("Before Long Break");

        tbSoundBeforeFocus = createToggleButton("Before Focus Time");
        tbSoundBeforeShortBreak = createToggleButton("Before Short Break");
        tbSoundBeforeLongBreak = createToggleButton("Before Long Break");

        Button btnSave = createButton("Save");
        Button btnCancel = createButton("Cancel");
        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSave);
        hbBtn.getChildren().add(btnCancel);

        gridpane.add(lblShowTrayNotifications, 1, 0);
        gridpane.add(tbNotificationBeforeFocus, 1, 1);
        gridpane.add(tbNotificationBeforeShortBreak, 1, 2);
        gridpane.add(tbNotificationBeforeLongBreak, 1, 3);
        gridpane.add(lblPlaySoundNotifications, 1, 4);

        gridpane.add(tbSoundBeforeFocus, 1, 5);
        gridpane.add(tbSoundBeforeShortBreak, 1, 6);
        gridpane.add(tbSoundBeforeLongBreak, 1, 7);
        gridpane.add(hbBtn, 1, 8, 6, 1);

        loadPomodoroSettings();

        btnSave.setOnAction(e -> {
            System.err.println("Save button pressed");
            savePomodoroSettings();
            btnCancel.getScene().getWindow().hide();
        });

        btnCancel.setOnAction(e -> {
            System.err.println("Cancel Button Pressed");
            btnCancel.getScene().getWindow().hide();
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().add(gridpane);
        showDialog(root, AppConstants.NOTIFICATION_SETTING_TITLE, AppConstants.NOTIFICATION_SETTING_WIDTH,
                AppConstants.NOTIFICATION_SETTING_HEIGHT);
    }

    private void loadPomodoroSettings() {
        // TODO load and initialize buttons with setting
        // NotificationsSetting
        NotificationsSetting setting = NotificationsSetting.INSTANCE;
        if (setting.isNotificationBeforeFocus()) {
            tbNotificationBeforeFocus.setSelected(true);
        } else {
            tbNotificationBeforeFocus.setSelected(false);
        }
        if (setting.isNotificationBeforeShortBreak()) {
            tbNotificationBeforeShortBreak.setSelected(true);
        } else {
            tbNotificationBeforeShortBreak.setSelected(false);
        }
        if (setting.isNotificationBeforeLongBreak()) {
            tbNotificationBeforeLongBreak.setSelected(true);
        } else {
            tbNotificationBeforeLongBreak.setSelected(false);
        }
        if (setting.isSoundBeforeFocus()) {
            tbSoundBeforeFocus.setSelected(true);
        } else {
            tbSoundBeforeFocus.setSelected(false);
        }
        if (setting.isSoundBeforeShortBreak()) {
            tbSoundBeforeShortBreak.setSelected(true);
        } else {
            tbSoundBeforeShortBreak.setSelected(false);
        }
        if (setting.isSoundBeforeLongBreak()) {
            tbSoundBeforeLongBreak.setSelected(true);
        } else {
            tbSoundBeforeLongBreak.setSelected(false);
        }
    }

    private void savePomodoroSettings() {
        // Get new values to save in file.
        // NotificationsSetting
        boolean notificationBeforeFocus;
        boolean notificationBeforeShortBreak;
        boolean notificationBeforeLongBreak;

        /**
         * Play sound notifications
         */
        boolean soundBeforeFocus;
        boolean soundBeforeShortBreak;
        boolean soundBeforeLongBreak;

        if (tbNotificationBeforeFocus.isSelected()) {
            notificationBeforeFocus = true;
        } else {
            notificationBeforeFocus = false;
        }
        if (tbNotificationBeforeShortBreak.isSelected()) {
            notificationBeforeShortBreak = true;
        } else {
            notificationBeforeShortBreak = false;
        }
        if (tbNotificationBeforeLongBreak.isSelected()) {
            notificationBeforeLongBreak = true;
        } else {
            notificationBeforeLongBreak = false;
        }
        if (tbSoundBeforeFocus.isSelected()) {
            soundBeforeFocus = true;
        } else {
            soundBeforeFocus = false;
        }
        if (tbSoundBeforeShortBreak.isSelected()) {
            soundBeforeShortBreak = true;
        } else {
            soundBeforeShortBreak = false;
        }
        if (tbSoundBeforeLongBreak.isSelected()) {
            soundBeforeLongBreak = true;
        } else {
            soundBeforeLongBreak = false;
        }

        NotificationsSetting.INSTANCE.update(notificationBeforeFocus, notificationBeforeShortBreak,
                notificationBeforeLongBreak, soundBeforeFocus, soundBeforeShortBreak, soundBeforeLongBreak);
        PomodoroSetting.INSTANCE.saveSetting();

    }

}
