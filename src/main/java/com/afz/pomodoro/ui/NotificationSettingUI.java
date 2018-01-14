package com.afz.pomodoro.ui;

import com.afz.pomodoro.constants.AppConstants;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NotificationSettingUI {

	private static final Font LBL_FONT = Font.font("Varela Round", FontWeight.BOLD, 12);
	String buttonStyle = "-fx-border-style: none;-fx-background-color: #555555;-fx-text-fill: white;-fx-pref-width: 70.0px;-fx-cursor: pointer;-fx-padding: 0.0px 5.0px 0.0px 5.0px;-fx-font-size: 16.0px;";

	private AnchorPane root = new AnchorPane();

	public void createNotificationSettingDailog() {
		GridPane gridpane = new GridPane();
		gridpane.setHgap(20);
		gridpane.setVgap(20);
		gridpane.setPadding(new Insets(20, 20, 20, 20));
		
		Group gpTrayNotification=new Group();
		

		root.getChildren().add(gridpane);

		Stage stage = new Stage();
		Scene scene = new Scene(root, 350, 300);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(AppConstants.POMODORO_TITLE);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.setScene(scene);
		stage.show();

	}

}
