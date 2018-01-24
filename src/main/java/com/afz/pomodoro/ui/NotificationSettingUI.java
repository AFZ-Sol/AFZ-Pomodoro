package com.afz.pomodoro.ui;

import com.afz.pomodoro.config.NotificationsSetting;
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

    JFXToggleButton notificationBeforeFocus;
    JFXToggleButton notificationBeforeShortBreak;
    JFXToggleButton notificationBeforeLongBreak;

    JFXToggleButton soundBeforeFocus;
    JFXToggleButton soundBeforeShortBreak;
    JFXToggleButton soundBeforeLongBreak;

    public void createNotificationSettingDailog() {

        GridPane gridpane = new GridPane();
        gridpane.setHgap(20);
        gridpane.setPadding(new Insets(20, 20, 20, 20));

        Label lblShowTrayNotifications = createLabel("Show Tray Notifications :");
        Label lblPlaySoundNotifications = createLabel("Play Sound Notifications :");

        notificationBeforeFocus = createToggleButton("Before Focus Time");
        notificationBeforeShortBreak = createToggleButton("Before Short Break");
        notificationBeforeLongBreak = createToggleButton("Before Long Break");

        soundBeforeFocus = createToggleButton("Before Focus Time");
        soundBeforeShortBreak = createToggleButton("Before Short Break");
        soundBeforeLongBreak = createToggleButton("Before Long Break");

        Button btnSave = createButton("Save");
        Button btnCancel = createButton("Cancel");
        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSave);
        hbBtn.getChildren().add(btnCancel);

        gridpane.add(lblShowTrayNotifications, 1, 0);
        gridpane.add(notificationBeforeFocus, 1, 1);
        gridpane.add(notificationBeforeShortBreak, 1, 2);
        gridpane.add(notificationBeforeLongBreak, 1, 3);
        gridpane.add(lblPlaySoundNotifications, 1, 4);

        gridpane.add(soundBeforeFocus, 1, 5);
        gridpane.add(soundBeforeShortBreak, 1, 6);
        gridpane.add(soundBeforeLongBreak, 1, 7);
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
        showDialog(root, AppConstants.NOTIFICATION_SETTING_TITLE, AppConstants.NOTIFICATION_SETTING_WIDTH, AppConstants.NOTIFICATION_SETTING_HEIGHT);
    }

    private void loadPomodoroSettings() {
        // TODO load and initialize buttons with setting
        // NotificationsSetting
        NotificationsSetting setting = NotificationsSetting.INSTANCE;

    }

    private void savePomodoroSettings() {
        // Get new values to save in file.
        // NotificationsSetting

    }

}
