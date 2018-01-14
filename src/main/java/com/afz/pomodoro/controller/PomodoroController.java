package com.afz.pomodoro.controller;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import com.afz.pomodoro.config.PomodoroSetting;
import com.afz.pomodoro.ui.NotificationSettingUI;
import com.afz.pomodoro.ui.PomodoroSettingUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PomodoroController implements Initializable, Observer {

    // Define all FXML components here
    @FXML
    Label lblTime;

    public PomodoroController() {
        PomodoroSetting.INSTANCE.addObserver(this);
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.err.println("Initialze");
        updateGui(PomodoroSetting.INSTANCE);

    }

    @FXML
    public void handlePomodoroSetting(ActionEvent event) {

        PomodoroSettingUI ref = new PomodoroSettingUI();
        ref.createPomodoroSettingDialog();

    }
    
    @FXML public void handleNotificationSetting(ActionEvent event) {
    	NotificationSettingUI obj=new NotificationSettingUI();
    	obj.createNotificationSettingDailog();
    }

    public void update(Observable o, Object arg) {
        if (o instanceof PomodoroSetting) {
            System.err.println("Pomodoro settings updated." + o);
            System.out.println(PomodoroSetting.INSTANCE);
            updateGui(PomodoroSetting.INSTANCE);
        }
    }

    private void updateGui(PomodoroSetting setting) {
        // update Gui elements with setting
        lblTime.setText(String.valueOf(setting.getFocusTime()));
    }

}
