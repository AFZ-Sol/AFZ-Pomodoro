package com.afz.pomodoro.ui;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.constants.AppConstants;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PomodoroSettingUI {

    // TODO define font in css
    private static final Font LBL_FONT = Font.font("Varela Round", FontWeight.BOLD, 12);
    private AnchorPane root = new AnchorPane();

    JFXTextField txtPomodoroDuration = new JFXTextField();
    JFXTextField txtShortBrakDuration = new JFXTextField();
    JFXTextField txtLongBreakDuration = new JFXTextField();
    JFXTextField txtSessionsBeforeLongBreak = new JFXTextField();
    JFXTextField txtSessionsPerDay = new JFXTextField();

    public void createPomodoroSettingDialog() {

        GridPane gridpane = new GridPane();
        gridpane.setHgap(20);
        gridpane.setVgap(20);
        gridpane.setPadding(new Insets(20, 20, 20, 20));

        Label lblPomodoroDuration = new Label("Pomodoro Duration :");
        Label lblShortBreakDuration = new Label("Short Break Duration :");
        Label lblLongBreakDuration = new Label("Long Break Duration :");
        Label lblSessionsBeforeLongBreak = new Label("Sessions Before Long Break :");
        Label lblSessionsPerDay = new Label("Sessions Per Day :");

        lblPomodoroDuration.setFont(LBL_FONT);
        lblShortBreakDuration.setFont(LBL_FONT);
        lblLongBreakDuration.setFont(LBL_FONT);
        lblSessionsBeforeLongBreak.setFont(LBL_FONT);
        lblSessionsPerDay.setFont(LBL_FONT);

        JFXButton btnSave = new JFXButton("Save");
        final JFXButton btnCancel = new JFXButton("Cancel");
        btnSave.setFont(LBL_FONT);
        btnCancel.setFont(LBL_FONT);

        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSave);
        hbBtn.getChildren().add(btnCancel);

        gridpane.add(lblPomodoroDuration, 1, 0);
        gridpane.add(lblShortBreakDuration, 1, 1);
        gridpane.add(lblLongBreakDuration, 1, 2);
        gridpane.add(lblSessionsBeforeLongBreak, 1, 3);
        gridpane.add(lblSessionsPerDay, 1, 4);

        gridpane.add(txtPomodoroDuration, 2, 0);
        gridpane.add(txtShortBrakDuration, 2, 1);
        gridpane.add(txtLongBreakDuration, 2, 2);
        gridpane.add(txtSessionsBeforeLongBreak, 2, 3);
        gridpane.add(txtSessionsPerDay, 2, 4);

        gridpane.add(hbBtn, 2, 5);

        root.getChildren().add(gridpane);

        loadPomodoroSettings();

        btnSave.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                System.err.println("Save button pressed");
                savePomodoroSettings();
                btnCancel.getScene().getWindow().hide();
            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                System.err.println("Cancel Button Pressed");
                btnCancel.getScene().getWindow().hide();
            }
        });

        Stage stage = new Stage();
        Scene scene = new Scene(root, 400, 300);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(AppConstants.POMODORO_TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

    }

    private void loadPomodoroSettings() {
        PomodoroSetting setting = PomodoroSetting.INSTANCE;
        txtPomodoroDuration.setText(String.valueOf(setting.getFocusTime()));
        txtShortBrakDuration.setText(String.valueOf(setting.getShortBreak()));
        txtLongBreakDuration.setText(String.valueOf(setting.getLongBreak()));
        txtSessionsBeforeLongBreak.setText(String.valueOf(setting.getSessionsBeforeLongBreak()));
        txtSessionsPerDay.setText(String.valueOf(setting.getSessionsPerDay()));
    }

    private void savePomodoroSettings() {
        // Get new values to save in file.
        int dummyVal = 4;
        PomodoroSetting.INSTANCE.update(dummyVal, dummyVal, dummyVal, dummyVal, dummyVal);
        PomodoroSetting.INSTANCE.saveSetting();
    }

}
