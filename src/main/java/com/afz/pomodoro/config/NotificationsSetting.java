package com.afz.pomodoro.config;

public class NotificationsSetting {

    /**
     * Show tray notifications
     */
    private boolean notificationAfterFocus = true;
    private boolean notificationAfterBreak = true;

    /**
     * Play sound notifications
     */
    private boolean soundAfterFocus = false;
    private boolean soundAfterBreak = false;

    public boolean isNotificationAfterFocus() {
        return notificationAfterFocus;
    }

    public void setNotificationAfterFocus(boolean notificationAfterFocus) {
        this.notificationAfterFocus = notificationAfterFocus;
    }

    public boolean isNotificationAfterBreak() {
        return notificationAfterBreak;
    }

    public void setNotificationAfterBreak(boolean notificationAfterBreak) {
        this.notificationAfterBreak = notificationAfterBreak;
    }

    public boolean isSoundAfterFocus() {
        return soundAfterFocus;
    }

    public void setSoundAfterFocus(boolean soundAfterFocus) {
        this.soundAfterFocus = soundAfterFocus;
    }

    public boolean isSoundAfterBreak() {
        return soundAfterBreak;
    }

    public void setSoundAfterBreak(boolean soundAfterBreak) {
        this.soundAfterBreak = soundAfterBreak;
    }

    @Override
    public String toString() {
        return "NotificationsSetting [notificationAfterFocus=" + notificationAfterFocus + ", notificationAfterBreak="
                + notificationAfterBreak + ", soundAfterFocus=" + soundAfterFocus + ", soundAfterBreak="
                + soundAfterBreak + "]";
    }

}
