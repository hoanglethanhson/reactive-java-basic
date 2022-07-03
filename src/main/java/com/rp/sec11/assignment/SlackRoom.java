package com.rp.sec11.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {
    private String name;
    private Sinks.Many<SlackMassage> sink;
    private Flux<SlackMassage> flux;

    public SlackRoom(String name) {
        this.name = name;
        this.sink = Sinks.many().replay().all();
        this.flux = this.sink.asFlux();
    }

    public void joinsRoom(SlackMember slackMember) {
        System.out.println(slackMember.getName() + "------joined-------" + this.name);
        this.subscribe(slackMember);
        slackMember.setMessageConsumer(
                msg -> this.postMessage(msg, slackMember)
        );
    }

    private void subscribe(SlackMember slackMember) {
        this.flux
                .filter(slackMassage -> slackMassage.getSender().equals(slackMember.getName()))
                .doOnNext(slackMassage -> slackMassage.setReceiver(slackMember.getName()))
                .map(SlackMassage::toString)
                .subscribe(slackMember::receive);
    }

    private void postMessage(String message, SlackMember slackMember) {
        SlackMassage slackMassage = new SlackMassage();
        slackMassage.setSender(slackMember.getName());
        slackMassage.setMessage(message);
        this.sink.tryEmitNext(slackMassage);
    }
}
