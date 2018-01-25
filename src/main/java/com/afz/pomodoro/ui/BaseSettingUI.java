package com.afz.pomodoro.ui;

import com.afz.pomodoro.constants.AppConstants;
import com.jfoenix.controls.JFXToggleButton;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BaseSettingUI {

    private static final String BTN_STYLE = "jfxbutton";
    private static final String LBL_STYLE = "jfxLabel";
    private static final String SPINNER_STYLE = Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL;
    private static final int SPINNER_WIDTH = 100; // use css


    protected Label createLabel(String text) {

        Label lbl = new Label(text);
        lbl.getStyleClass().add(LBL_STYLE);
        return lbl;
    }

    protected Button createButton(String label) {
        Button btn = new Button(label);
        btn.getStyleClass().add(BTN_STYLE);
        return btn;
    }

    protected Spinner<Integer> createSpinner(int min, int max, int initialValue) {
        Spinner<Integer> sp = new Spinner<>(min, max, initialValue);
        sp.getStyleClass().add(SPINNER_STYLE);
        sp.setMaxWidth(SPINNER_WIDTH);
        return sp;
    }

    protected JFXToggleButton createToggleButton(String string) {
        JFXToggleButton tb = new JFXToggleButton();
        tb.setText(string);
        tb.getStyleClass().add(LBL_STYLE);
        return tb;

    }

    protected void showDialog(AnchorPane root, String title, double width, double height) {
        Stage stage = new Stage();
        Scene scene = new Scene(root, width, height);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        // This will load style from CSS
        scene.getStylesheets().add(getClass().getResource("/css/pomodoro.css").toExternalForm());
        stage.getIcons().add(new Image(getClass().getResourceAsStream(AppConstants.ICON_SETTING)));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

}
