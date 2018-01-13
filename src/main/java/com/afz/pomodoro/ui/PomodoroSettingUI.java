package com.afz.pomodoro.ui;

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

	private AnchorPane root = new AnchorPane();
	private GridPane gridpane = new GridPane();

	public void createPomodoroSettingDialog() {

		gridpane.setHgap(20);
		gridpane.setVgap(20);
		gridpane.setPadding(new Insets(20, 20, 20, 20));

		Label lblPomodoroDuration = new Label("Pomodoro Duration :");
		Label lblShortBreakDuration = new Label("Short Break Duration :");
		Label lblLongBreakDuration = new Label("Long Break Duration :");
		Label lblSessionsBeforeLongBreak = new Label("Sessions Before Long Break :");
		Label lblSessionsPerDay = new Label("Sessions Per Day :");

		JFXTextField txtPomodoroDuration = new JFXTextField();
		JFXTextField txtShortBrakDuration = new JFXTextField();
		JFXTextField txtLongBreakDuration = new JFXTextField();
		JFXTextField txtSessionsBeforeLongBreak = new JFXTextField();
		JFXTextField txtSessionsPerDay = new JFXTextField();

		txtPomodoroDuration.setPromptText("in minutes");
		txtShortBrakDuration.setPromptText("in minutes");
		txtLongBreakDuration.setPromptText("in minutes");
		txtSessionsBeforeLongBreak.setPromptText("in minutes");
		txtSessionsPerDay.setPromptText("in minutes");

		lblPomodoroDuration.setFont(Font.font("Varela Round", FontWeight.BOLD, 12));
		lblShortBreakDuration.setFont(Font.font("Varela Round", FontWeight.BOLD, 12));
		lblLongBreakDuration.setFont(Font.font("Varela Round", FontWeight.BOLD, 12));
		lblSessionsBeforeLongBreak.setFont(Font.font("Varela Round", FontWeight.BOLD, 12));
		lblSessionsPerDay.setFont(Font.font("Varela Round", FontWeight.BOLD, 12));

		JFXButton btnSave = new JFXButton("Save");
		final JFXButton btnCancel = new JFXButton("Cancel");
		btnSave.setFont(Font.font("Varela Round", FontWeight.BOLD, 12));
		btnCancel.setFont(Font.font("Varela Round", FontWeight.BOLD, 12));

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

		btnSave.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				System.err.println("Sign in button pressed");
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

}
