package com.keepcode.tests.test3.stubs;

import java.net.InetSocketAddress;
import java.util.ArrayList;

public class Statics {

    public static Object getGoipModel() {
        return null;
    }

    public static void deleteCommand(CommandType typeToRemove) {

    }

    public static void sendKeepAliveOkAndFlush(ChannelHandlerContext ctx) {
    }

    public static void sendCommandToContext(ChannelHandlerContext ctx, InetSocketAddress lineAddress, Object commandText) {

    }

    public static Iterable<? extends Command> getAllCommands() {
        return new ArrayList<>();
    }

    public static int getUdpPort() {
        return 0;
    }

    public static String getIpAddress() {
        return "";
    }

    public static class Log {
        public static final Boo ussd = new Boo();

    }

}
