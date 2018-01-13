package com.afz.pomodoro.controller;

import com.afz.pomodoro.ui.PomodoroSettingUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class PomodoroController {

	@FXML
	public void handlePomodoroSetting(ActionEvent event) {

		PomodoroSettingUI ref = new PomodoroSettingUI();
		ref.createPomodoroSettingDialog();

	}

}
