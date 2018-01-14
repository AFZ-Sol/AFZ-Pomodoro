package com.afz.pomodoro.config;

import java.util.Observable;

import com.afz.pomodoro.constants.AppConstants;

public abstract class SharedSetting extends Observable {

    protected void loadSettingFromFile() {
        System.err.println("Loading setting from file : " + AppConstants.CONFIG_FILE_PATH);
    }

    protected void saveSettingInFile() {
        System.err.println("Saving setting from file." + AppConstants.CONFIG_FILE_PATH);
    }
}
