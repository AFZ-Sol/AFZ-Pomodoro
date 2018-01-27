package com.afz.pomodoro.constants;

import java.io.File;

public class AppConstants {

    public final static String APP_TITLE = "AFZ Pomodoro";
    public final static String POMODORO_SETTING_TITLE = "Pomodoro Setting";
    public final static String NOTIFICATION_SETTING_TITLE = "Notifications Setting";

    public final static double NOTIFICATION_SETTING_HEIGHT = 400;
    public final static double NOTIFICATION_SETTING_WIDTH = 350;

    public final static double POMODORO_SETTING_HEIGHT = 300;
    public final static double POMODORO_SETTING_WIDTH = 350;

    public final static String ICON_APPLICATION = "/images/pomodoro-icon.png";
    public final static String ICON_SETTING = "/images/Settings-icon.png";

    public static final String CONFIG_FILE_PATH = System.getProperty("user.home") + File.separator + APP_TITLE;
}
