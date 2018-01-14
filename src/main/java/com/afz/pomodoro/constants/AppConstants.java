package com.afz.pomodoro.constants;

import java.io.File;

public class AppConstants {

    public final static String APP_TITLE = "AFZ Pomodoro";
    public final static String POMODORO_TITLE = "Pomodoro Setting";

    private static final String APP_DIR_PATH = System.getProperty("user.home") + File.separator
            + APP_TITLE.replaceAll(" ", "_");
    public static final String CONFIG_FILE_PATH = System.getProperty("user.home") + File.separator + APP_TITLE;
}
