package com.keepcode.tests.test3;

//Stubs added for comfortable work in IDEA
import static com.keepcode.tests.test3.stubs.Statics.*;
import com.keepcode.tests.test3.stubs.*;
import java.net.InetSocketAddress;
import java.util.Date;

public class Main {

    //I would like to use constants instead of magic numbers
    public static final int ZERO = 0;

    public static void main(String[] args) {

    }

    void processTask(ChannelHandlerContext ctx) {
        InetSocketAddress lineAddress = new InetSocketAddress(getIpAddress(), getUdpPort());
        //There would be a usage of stream api, but it's not improve code readability
        for (Command currentCommand : getAllCommands()) {
            //Maybe it is a good idea to create method invoke() in Command and extract logic to it
            //But I don't know can modify Command or not
            boolean isAttemptsNumberNotExhausted = !currentCommand.isAttemptsNumberExhausted();
            boolean isNotRebootChannelOrIsTimeToSend = currentCommand.getCommandType() != CommandType.REBOOT_CHANNEL || currentCommand.isTimeToSend();
            if (isAttemptsNumberNotExhausted && isNotRebootChannelOrIsTimeToSend) {
                sendCommandToContext(ctx, lineAddress, currentCommand.getCommandText());
                sendMessage(lineAddress, currentCommand);
            } else {
                deleteCommand(currentCommand.getCommandType());
            }
        }
        sendKeepAliveOkAndFlush(ctx);
    }

    public void sendMessage(InetSocketAddress lineAddress, Command currentCommand) {
        try {
            AdminController.getInstance().processUssdMessage(
                    new DblIncomeUssdMessage(lineAddress.getHostName(),
                            lineAddress.getPort(),
                            ZERO,
                            EnumGoip.getByModel(getGoipModel()),
                            currentCommand.getCommandText()),
                    false
            );
        } catch (Exception ignored) {
            //It's not so good to leave empty code block, better to log exception
        }
        //next line was switched for one of two cases because it looked vary similar
        currentCommand.setSendDate(new Date());
        currentCommand.incSendCounter();
        Log.ussd.write(String.format("sent: ip: %s; порт: %d; %s",
                lineAddress.getHostString(),
                lineAddress.getPort(),
                currentCommand.getCommandText()));
    }

}