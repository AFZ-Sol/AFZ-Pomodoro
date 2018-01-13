package com.afz.pomodoro.manager;

import com.afz.pomodoro.config.PomodoroSetting;

public class PomodoroManager {

    public PomodoroManager() {
        initSettings();
    }

    /**
     * Init settings and update GUI on first run
     */
    private void initSettings() {
        // TODO read pomodoro settings from config file
        // readConfigFile();

        // TODO update GUI with settings
        // updateSettings()

    }

    private void updateSettings(PomodoroSetting settings) {
        // update GUI
    }
}
