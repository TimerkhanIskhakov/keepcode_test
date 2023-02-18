package com.keepcode.tests.test3.stubs;

import java.util.Date;

public class Command {

    private boolean timeToSend;

    public Command(boolean timeToSend) {
        this.timeToSend = timeToSend;
    }

    public CommandType getCommandType() {
        return null;
    }

    public boolean isAttemptsNumberExhausted() {
        return false;
    }

    public boolean isTimeToSend() {
        return timeToSend;
    }

    public Object getCommandText() {
        return null;
    }

    public void setSendDate(Date date) {

    }

    public void incSendCounter() {

    }
}
