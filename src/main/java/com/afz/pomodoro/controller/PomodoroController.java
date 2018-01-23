package com.afz.pomodoro.controller;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.constants.AppConstants;
import com.afz.pomodoro.ui.NotificationSettingUI;
import com.afz.pomodoro.ui.PomodoroSettingUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PomodoroController implements Initializable, Observer {

    @FXML
    Label lblTime;
    @FXML
    Label lblTitle;
    @FXML
    Label lblGoals;
    @FXML
    Label lblSessions;

    @FXML
    Button btnPlay;
    @FXML
    Button btnPause;

    public PomodoroController() {
        PomodoroSetting.INSTANCE.addObserver(this);
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.err.println("Initialze");
        updateGui(PomodoroSetting.INSTANCE);

    }

    private void updateGui(PomodoroSetting setting) {
        // update Gui elements with setting
        lblTime.setText(String.valueOf(setting.getFocusTime()));
        lblGoals.setText(String.valueOf(setting.getSessionsBeforeLongBreak()));
        lblSessions.setText(String.valueOf(setting.getSessionsPerDay()));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    public void handleExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void handlePomodoroSetting(ActionEvent event) {
        PomodoroSettingUI ref = new PomodoroSettingUI();
        ref.createPomodoroSettingDialog();

    }

    @FXML
    public void handleNotificationSetting(ActionEvent event) {
        NotificationSettingUI obj = new NotificationSettingUI();
        obj.createNotificationSettingDailog();
    }

    @FXML
    public void handleAboutAFZPomodoro(ActionEvent event) {

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(AppConstants.APP_TITLE);
        alert.setHeaderText("AFZ - Pemodoro");
        alert.setContentText(
                "Developed by:\t\tMuhammad Awais\nDepartment of:\tComputer Sciences\nStudent of:\t\tCOMSATS Institute of Information\n\t\t\t\tTechnology, Wah Cantt");

        alert.showAndWait();
    }

    public void update(Observable o, Object arg) {
        if (o instanceof PomodoroSetting) {
            System.err.println("Pomodoro settings updated." + o);
            System.out.println(PomodoroSetting.INSTANCE);
            updateGui(PomodoroSetting.INSTANCE);
        }
    }

}
