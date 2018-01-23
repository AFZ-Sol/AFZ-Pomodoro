package com.afz.pomodoro.ui;

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

    JFXToggleButton stnAfterFocusTime;
    JFXToggleButton stnAfterBreakTime;
    JFXToggleButton plsAfterFocusTime;
    JFXToggleButton plsAfterBreakTime;

    public void createNotificationSettingDailog() {

        GridPane gridpane = new GridPane();
        gridpane.setHgap(20);
        gridpane.setPadding(new Insets(20, 20, 20, 20));

        Label lblShowTrayNotifications = createLabel("Show Tray Notifications :");
        Label lblPlaySoundNotifications = createLabel("Play Sound Notifications :");

        Label lblstnAfterFocusTime = createLabel("After Focus Time :");
        Label lblstnAfterBreakTime = createLabel("After Break Time :");
        Label lblplsAfterFocusTime = createLabel("After Focus Time :");
        Label lblplsAfterBreakTime = createLabel("After Break Time :");

        stnAfterFocusTime = createToggleButton();
        stnAfterBreakTime = createToggleButton();
        plsAfterFocusTime = createToggleButton();
        plsAfterBreakTime = createToggleButton();

        gridpane.add(lblShowTrayNotifications, 1, 0);
        gridpane.add(lblPlaySoundNotifications, 1, 3);

        gridpane.add(lblstnAfterFocusTime, 1, 1);
        gridpane.add(lblstnAfterBreakTime, 1, 2);
        gridpane.add(lblplsAfterFocusTime, 1, 4);
        gridpane.add(lblplsAfterBreakTime, 1, 5);

        gridpane.add(stnAfterFocusTime, 3, 1);
        gridpane.add(stnAfterBreakTime, 3, 2);
        gridpane.add(plsAfterFocusTime, 3, 4);
        gridpane.add(plsAfterBreakTime, 3, 5);

        Button btnSave = createButton("Save");
        Button btnCancel = createButton("Cancel");

        HBox hbBtn = new HBox(30);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSave);
        hbBtn.getChildren().add(btnCancel);

        gridpane.add(hbBtn, 1, 6, 3, 1);

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
        showDialog(root, AppConstants.NOTIFICATION_SETTING_TITLE);
    }

    private void loadPomodoroSettings() {
        // TODO load and initialize buttons with setting
        // NotificationsSetting
    }

    private void savePomodoroSettings() {
        // Get new values to save in file.
        // NotificationsSetting
    }

}
