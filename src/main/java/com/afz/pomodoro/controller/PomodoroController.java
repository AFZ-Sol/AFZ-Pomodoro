package com.afz.pomodoro.controller;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.constants.AppConstants;
import com.afz.pomodoro.manager.PomodoroManager;
import com.afz.pomodoro.model.PType;
import com.afz.pomodoro.ui.NotificationSettingUI;
import com.afz.pomodoro.ui.PomodoroSettingUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

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
    /////////////////////////////////////////////////////////////
    private PomodoroManager manager;
    private Timeline mTimeline;

    ////////////////////////////////////////////////////////////

    public PomodoroController() {
        PomodoroSetting.INSTANCE.addObserver(this);
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.err.println("Initialze");
        manager = new PomodoroManager();
        updateGui();
        prepareTimeline();

        btnPlay.setOnAction(e -> {
            playTimer();
        });

        btnPause.setOnAction(e -> {
            pauseTimer();
        });
    }

    private void updateGui() {
        // update Gui elements with setting
        lblTitle.setText(manager.getCurrentTitle());
        lblGoals.setText(manager.getGoalSessions());
        lblSessions.setText(manager.getTodaySessions());
        updateRemainingTime();
    }

    private void updateRemainingTime() {
        lblTime.setText(manager.getRemainingTime());
    }

    private void prepareTimeline() {
        reset();
        // addAttemptStyle(kind);

        updateGui();

        mTimeline = new Timeline();
        mTimeline.setCycleCount(manager.getCurrentSessionSeconds());
        mTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            manager.tick();
            updateRemainingTime();
        }));
        mTimeline.setOnFinished(e -> {
            // saveCurrentAttempt();
            manager.onFinished();
            // Prepare next attempt
            prepareTimeline();
            playTimer();
        });
    }

    private void reset() {
        // TODO Auto-generated method stub

    }

    public void playTimer() {
        mTimeline.play();
    }

    public void pauseTimer() {
        mTimeline.pause();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    private void focusTimeStarted() {
    }

    private void shortBreakStarted() {

    }

    private void longBreakStarted() {

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

            PType.FOCUS_TIME.setDuration(((PomodoroSetting) o).getFocusTime());
            PType.SHORT_BREAK.setDuration(((PomodoroSetting) o).getShortBreak());
            PType.LONG_BREAK.setDuration(((PomodoroSetting) o).getLongBreak());

            updateGui();
        }
    }

}
