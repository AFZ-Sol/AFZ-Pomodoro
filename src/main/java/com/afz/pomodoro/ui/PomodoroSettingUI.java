package com.afz.pomodoro.ui;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.constants.AppConstants;
import com.jfoenix.controls.JFXButton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PomodoroSettingUI extends BaseSettingUI {

    Spinner<Integer> spPomodoroDuration = new Spinner<>(15, 25, 45);
    Spinner<Integer> spShortBrakDuration = new Spinner<>(3, 5, 10);
    Spinner<Integer> spLongBreakDuration = new Spinner<>(10, 15, 20);
    Spinner<Integer> spSessionsBeforeLongBreak = new Spinner<>(2, 5, 5);
    Spinner<Integer> spSessionsPerDay = new Spinner<>(5, 20, 25);

    public void createPomodoroSettingDialog() {

        Label lblPomodoroDuration = createLabel("Pomodoro Duration :");
        Label lblShortBreakDuration = createLabel("Short Break Duration :");
        Label lblLongBreakDuration = createLabel("Long Break Duration :");
        Label lblSessionsBeforeLongBreak = createLabel("Sessions Before Long Break :");
        Label lblSessionsPerDay = createLabel("Sessions Per Day :");

        // TODO use createSpinner() method
        spPomodoroDuration.getStyleClass().add(spinnerStyle);
        spShortBrakDuration.getStyleClass().add(spinnerStyle);
        spLongBreakDuration.getStyleClass().add(spinnerStyle);
        spSessionsBeforeLongBreak.getStyleClass().add(spinnerStyle);
        spSessionsPerDay.getStyleClass().add(spinnerStyle);

        spPomodoroDuration.setMaxWidth(SPINNER_WIDTH);
        spShortBrakDuration.setMaxWidth(SPINNER_WIDTH);
        spLongBreakDuration.setMaxWidth(SPINNER_WIDTH);
        spSessionsBeforeLongBreak.setMaxWidth(SPINNER_WIDTH);
        spSessionsPerDay.setMaxWidth(SPINNER_WIDTH);

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
        JFXButton btnSave = new JFXButton("Save");
        JFXButton btnCancel = new JFXButton("Cancel");
        btnSave.getStyleClass().add(BTN_STYLE);
        btnCancel.getStyleClass().add(BTN_STYLE);

        HBox hbBtn = new HBox(30);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSave);
        hbBtn.getChildren().add(btnCancel);

        gridpane.add(hbBtn, 1, 5, 2, 1);

        AnchorPane root = new AnchorPane();
        root.getChildren().add(gridpane);

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

        Stage stage = new Stage();
        Scene scene = new Scene(root, 350, 300);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(AppConstants.POMODORO_TITLE);
        // This will load style from CSS
        scene.getStylesheets().add(getClass().getResource("/css/pomodoro.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

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
