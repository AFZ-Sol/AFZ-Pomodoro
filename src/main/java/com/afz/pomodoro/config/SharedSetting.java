package com.afz.pomodoro.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.Properties;

import com.afz.pomodoro.constants.AppConstants;

public abstract class SharedSetting extends Observable {

    static Properties setting = new Properties();

    protected void loadSettingFromFile() {
        System.err.println("Loading setting from file : " + AppConstants.CONFIG_FILE_PATH);
        File f = new File(AppConstants.CONFIG_FILE_PATH);
        if (f.exists()) {
            try {
                setting.load(new FileInputStream(f));

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    protected void saveSettingInFile() {
        System.err.println("Saving setting in file." + AppConstants.CONFIG_FILE_PATH);
        // setting.save(out, comments);
        // FileUtil.ensureDirPath(AppConstants.CONFIG_FILE_PATH);

        try (FileOutputStream outputFile = new FileOutputStream(AppConstants.CONFIG_FILE_PATH)) {
            setting.store(outputFile, "UserProperties");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected boolean getBooleanProperty(String key, boolean defaultValue) {
        boolean value = Boolean.valueOf(setting.getProperty(key, Boolean.toString(defaultValue)));
        return value;
    }

    protected int getIntProperty(String key, int defaultValue) {
        int value = Integer.valueOf(setting.getProperty(key, Integer.toString(defaultValue)));
        return value;
    }

    protected void saveProperty(String key, String value) {
        setting.put(key, value);
    }
}
