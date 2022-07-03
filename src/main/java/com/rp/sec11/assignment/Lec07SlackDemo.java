package com.rp.sec11.assignment;

import courseutil.Util;

public class Lec07SlackDemo {
    public static void main(String[] args) {
        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinsRoom(sam);
        slackRoom.joinsRoom(jake);
        slackRoom.joinsRoom(mike);

        sam.says("Hi all...");
        Util.sleepSeconds(4);

        jake.says("Hey!");
        sam.says("I simple wanted to say hi ...");
        Util.sleepSeconds(4);

        slackRoom.joinsRoom(mike);
        mike.says("Hey guys ... glad to be here");
    }
}
