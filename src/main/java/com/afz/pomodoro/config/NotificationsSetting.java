package com.afz.pomodoro.config;

public class NotificationsSetting extends SharedSetting {

    private static final String NOTIFICATION_BEFORE_FOCUS = "NOTIFICATION_BEFORE_FOCUS";
    private static final String NOTIFICATION_BEFORE_SHORT_BREAK = "NOTIFICATION_BEFORE_SHORT_BREAK";
    private static final String NOTIFICATION_BEFORE_LONG_BREAK = "NOTIFICATION_BEFORE_LONG_BREAK";

    private static final String SOUND_BEFORE_FOCUS_TIME = "SOUND_BEFORE_FOCUS_TIME";
    private static final String SOUND_BEFORE_SHORT_BREAK = "SOUND_BEFORE_SHORT_BREAK";
    private static final String SOUND_BEFORE_LONG_BREAK = "SOUND_BEFORE_LONG_BREAK";
    /**
     * Show tray notifications
     */
    private boolean notificationBeforeFocus = true;
    private boolean notificationBeforeShortBreak = true;
    private boolean notificationBeforeLongBreak = true;

    /**
     * Play sound notifications
     */
    private boolean soundBeforeFocus = false;
    private boolean soundBeforeShortBreak = false;
    private boolean soundBeforeLongBreak = false;

    public static final NotificationsSetting INSTANCE = new NotificationsSetting();

    private NotificationsSetting() {
        loadSetting();
    }

    public void update(boolean notificationBeforeFocus, boolean notificationBeforeShortBreak,
            boolean notificationBeforeLongBreak, boolean soundBeforeFocus, boolean soundBeforeShortBreak,
            boolean soundBeforeLongBreak) {
        this.notificationBeforeFocus = notificationBeforeFocus;
        this.notificationBeforeShortBreak = notificationBeforeShortBreak;
        this.notificationBeforeLongBreak = notificationBeforeLongBreak;
        this.soundBeforeFocus = soundBeforeFocus;
        this.soundBeforeShortBreak = soundBeforeShortBreak;
        this.soundBeforeLongBreak = soundBeforeLongBreak;
    }

    private void loadSetting() {
        System.err.println("Loading pomodoro settings.");
        super.loadSettingFromFile();
        // TODO Read and validate settings
        notificationBeforeFocus = getBooleanProperty(NOTIFICATION_BEFORE_FOCUS, notificationBeforeFocus);
        notificationBeforeShortBreak = getBooleanProperty(NOTIFICATION_BEFORE_SHORT_BREAK,
                notificationBeforeShortBreak);
        notificationBeforeLongBreak = getBooleanProperty(NOTIFICATION_BEFORE_LONG_BREAK, notificationBeforeLongBreak);

        soundBeforeFocus = getBooleanProperty(SOUND_BEFORE_FOCUS_TIME, soundBeforeFocus);
        soundBeforeShortBreak = getBooleanProperty(SOUND_BEFORE_SHORT_BREAK, soundBeforeShortBreak);
        soundBeforeLongBreak = getBooleanProperty(SOUND_BEFORE_LONG_BREAK, soundBeforeLongBreak);
    }

    public void saveSetting() {
        // TODO Save curret settings in file
        saveProperty(NOTIFICATION_BEFORE_FOCUS, Boolean.toString(notificationBeforeFocus));
        saveProperty(NOTIFICATION_BEFORE_SHORT_BREAK, Boolean.toString(notificationBeforeShortBreak));
        saveProperty(NOTIFICATION_BEFORE_LONG_BREAK, Boolean.toString(notificationBeforeLongBreak));
        saveProperty(SOUND_BEFORE_FOCUS_TIME, Boolean.toString(soundBeforeFocus));
        saveProperty(SOUND_BEFORE_SHORT_BREAK, Boolean.toString(soundBeforeShortBreak));
        saveProperty(SOUND_BEFORE_LONG_BREAK, Boolean.toString(soundBeforeLongBreak));

        System.err.println("Saving pomodoro settings.");
        super.saveSettingInFile();

    }

    public boolean isNotificationBeforeFocus() {
        return notificationBeforeFocus;
    }

    public void setNotificationBeforeFocus(boolean notificationBeforeFocus) {
        this.notificationBeforeFocus = notificationBeforeFocus;
    }

    public boolean isNotificationBeforeShortBreak() {
        return notificationBeforeShortBreak;
    }

    public void setNotificationBeforeShortBreak(boolean notificationBeforeShortBreak) {
        this.notificationBeforeShortBreak = notificationBeforeShortBreak;
    }

    public boolean isNotificationBeforeLongBreak() {
        return notificationBeforeLongBreak;
    }

    public void setNotificationBeforeLongBreak(boolean notificationBeforeLongBreak) {
        this.notificationBeforeLongBreak = notificationBeforeLongBreak;
    }

    public boolean isSoundBeforeFocus() {
        return soundBeforeFocus;
    }

    public void setSoundBeforeFocus(boolean soundBeforeFocus) {
        this.soundBeforeFocus = soundBeforeFocus;
    }

    public boolean isSoundBeforeShortBreak() {
        return soundBeforeShortBreak;
    }

    public void setSoundBeforeShortBreak(boolean soundBeforeShortBreak) {
        this.soundBeforeShortBreak = soundBeforeShortBreak;
    }

    public boolean isSoundBeforeLongBreak() {
        return soundBeforeLongBreak;
    }

    public void setSoundBeforeLongBreak(boolean soundBeforeLongBreak) {
        this.soundBeforeLongBreak = soundBeforeLongBreak;
    }

    @Override
    public String toString() {
        return "NotificationsSetting [notificationBeforeFocus=" + notificationBeforeFocus
                + ", notificationBeforeShortBreak=" + notificationBeforeShortBreak + ", notificationBeforeLongBreak="
                + notificationBeforeLongBreak + ", soundBeforeFocus=" + soundBeforeFocus + ", soundBeforeShortBreak="
                + soundBeforeShortBreak + ", soundBeforeLongBreak=" + soundBeforeLongBreak + "]";
    }

}
