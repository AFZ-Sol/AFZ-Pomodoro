package com.afz.pomodoro.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

public class BaseSettingUI {

    protected static final String BTN_STYLE = "jfxbutton";
    protected static final String LBL_STYLE = "jfxLabel";
    String spinnerStyle = Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL;
    int SPINNER_WIDTH = 100; // use css

    protected Label createLabel(String text) {

        Label lbl = new Label(text);
        lbl.getStyleClass().add(LBL_STYLE);
        return lbl;
    }

    protected Button createButton(String label) {
        // create button and apply style
        return null;
    }

    protected Spinner<Integer> createSpinner(int min, int max, int value) {
        return null;
    }

}
