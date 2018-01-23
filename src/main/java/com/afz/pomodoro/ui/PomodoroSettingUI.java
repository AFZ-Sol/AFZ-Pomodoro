package com.afz.pomodoro.ui;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.constants.AppConstants;
import com.jfoenix.controls.JFXButton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PomodoroSettingUI extends BaseSettingUI {

    Spinner<Integer> spPomodoroDuration;
    Spinner<Integer> spShortBrakDuration;
    Spinner<Integer> spLongBreakDuration;
    Spinner<Integer> spSessionsBeforeLongBreak;
    Spinner<Integer> spSessionsPerDay;

    public void createPomodoroSettingDialog() {

        Label lblPomodoroDuration = createLabel("Pomodoro Duration :");
        Label lblShortBreakDuration = createLabel("Short Break Duration :");
        Label lblLongBreakDuration = createLabel("Long Break Duration :");
        Label lblSessionsBeforeLongBreak = createLabel("Sessions Before Long Break :");
        Label lblSessionsPerDay = createLabel("Sessions Per Day :");

        // TODO use createSpinner() method
        spPomodoroDuration = createSpinner(15, 45, 25);
        spShortBrakDuration = createSpinner(3, 10, 5);
        spLongBreakDuration = createSpinner(10, 20, 15);
        spSessionsBeforeLongBreak = createSpinner(2, 5, 4);
        spSessionsPerDay = createSpinner(5, 55, 16);

        // Labels grid
        GridPane gridpane = new GridPane();
        gridpane.setHgap(20);
        gridpane.setVgap(20);
        gridpane.setPadding(new Insets(20, 20, 20, 20));

        gridpane.add(lblPomodoroDuration, 1, 0);
        gridpane.add(lblShortBreakDuration, 1, 1);
        gridpane.add(lblLongBreakDuration, 1, 2);
        gridpane.add(lblSessionsBeforeLongBreak, 1, 3);
        gridpane.add(lblSessionsPerDay, 1, 4);

        gridpane.add(spPomodoroDuration, 2, 0);
        gridpane.add(spShortBrakDuration, 2, 1);
        gridpane.add(spLongBreakDuration, 2, 2);
        gridpane.add(spSessionsBeforeLongBreak, 2, 3);
        gridpane.add(spSessionsPerDay, 2, 4);

        // Buttons grid
        // TODO use createButton()
        Button btnSave = createButton("Save");
        Button btnCancel = createButton("Cancel");

        HBox hbBtn = new HBox(30);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSave);
        hbBtn.getChildren().add(btnCancel);

        gridpane.add(hbBtn, 1, 5, 2, 1);

        loadPomodoroSettings();

        // Using Java8 lambda
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
        showDialog(root, AppConstants.POMODORO_SETTING_TITLE);

    }

    private void loadPomodoroSettings() {
        PomodoroSetting setting = PomodoroSetting.INSTANCE;
        spPomodoroDuration.getValueFactory().setValue(Integer.parseInt(String.valueOf(setting.getFocusTime())));
        spShortBrakDuration.getValueFactory().setValue(Integer.parseInt(String.valueOf(setting.getShortBreak())));
        spLongBreakDuration.getValueFactory()
                .setValue(Integer.parseInt(String.valueOf(setting.getSessionsBeforeLongBreak())));
        spSessionsBeforeLongBreak.getValueFactory()
                .setValue(Integer.parseInt(String.valueOf(setting.getSessionsBeforeLongBreak())));
        spSessionsPerDay.getValueFactory().setValue(Integer.parseInt(String.valueOf(setting.getSessionsPerDay())));

    }

    private void savePomodoroSettings() {
        // Get new values to save in file.
        int focusTime = spPomodoroDuration.getValue();
        int shortBreak = spShortBrakDuration.getValue();
        int longBreak = spLongBreakDuration.getValue();
        int sessionsBeforeLongBreak = spSessionsBeforeLongBreak.getValue();
        int sessionsPerDay = spSessionsPerDay.getValue();

        PomodoroSetting.INSTANCE.update(focusTime, shortBreak, longBreak, sessionsBeforeLongBreak, sessionsPerDay);
        PomodoroSetting.INSTANCE.saveSetting();
    }

}
