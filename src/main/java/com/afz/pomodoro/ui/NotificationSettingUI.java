package com.afz.pomodoro.ui;

import com.afz.pomodoro.constants.AppConstants;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;

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

public class NotificationSettingUI {

    private static final Font LBL_FONT = Font.font("Varela Round", FontWeight.BOLD, 12);

    String buttonStyle = "-fx-border-style: none;-fx-background-color: #555555;-fx-text-fill: white;-fx-pref-width: 70.0px;-fx-cursor: pointer;-fx-padding: 0.0px 5.0px 0.0px 5.0px;-fx-font-size: 16.0px;";

    private AnchorPane root = new AnchorPane();

    public void createNotificationSettingDailog() {

        GridPane gridpane = new GridPane();
        gridpane.setHgap(20);
        gridpane.setPadding(new Insets(20, 20, 20, 20));

        Label lblShowTrayNotifications = new Label("Show Tray Notifications :");
        Label lblPlaySoundNotifications = new Label("Play Sound Notifications :");
        Label lblstnAfterFocusTime = new Label("After Focus Time :");
        Label lblstnAfterBreakTime = new Label("After Break Time :");
        Label lblplsAfterFocusTime = new Label("After Focus Time :");
        Label lblplsAfterBreakTime = new Label("After Break Time :");

        lblShowTrayNotifications.setFont(LBL_FONT);
        lblPlaySoundNotifications.setFont(LBL_FONT);
        lblstnAfterFocusTime.setFont(LBL_FONT);
        lblstnAfterBreakTime.setFont(LBL_FONT);
        lblplsAfterFocusTime.setFont(LBL_FONT);
        lblplsAfterBreakTime.setFont(LBL_FONT);

        gridpane.add(lblShowTrayNotifications, 1, 0);
        gridpane.add(lblPlaySoundNotifications, 1, 3);

        gridpane.add(lblstnAfterFocusTime, 1, 1);
        gridpane.add(lblstnAfterBreakTime, 1, 2);
        gridpane.add(lblplsAfterFocusTime, 1, 4);
        gridpane.add(lblplsAfterBreakTime, 1, 5);

        JFXToggleButton stnAfterFocusTime = new JFXToggleButton();
        JFXToggleButton stnAfterBreakTime = new JFXToggleButton();
        JFXToggleButton plsAfterFocusTime = new JFXToggleButton();
        JFXToggleButton plsAfterBreakTime = new JFXToggleButton();
        stnAfterBreakTime.setMaxHeight(30);
        stnAfterFocusTime.setMaxHeight(30);
        plsAfterBreakTime.setMaxHeight(30);
        plsAfterFocusTime.setMaxHeight(30);

        gridpane.add(stnAfterFocusTime, 3, 1);
        gridpane.add(stnAfterBreakTime, 3, 2);
        gridpane.add(plsAfterFocusTime, 3, 4);
        gridpane.add(plsAfterBreakTime, 3, 5);

        JFXButton btnSave = new JFXButton("Save");
        final JFXButton btnCancel = new JFXButton("Cancel");

        btnSave.setStyle(buttonStyle);
        btnCancel.setStyle(buttonStyle);

        HBox hbBtn = new HBox(30);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSave);
        hbBtn.getChildren().add(btnCancel);

        gridpane.add(hbBtn, 1, 6, 3, 1);

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
        Scene scene = new Scene(root, 350, 350);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(AppConstants.POMODORO_TITLE);
        // scene.getStylesheets().add(getClass().getResource("/gui/Dashboard.fxml").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

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
