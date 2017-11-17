package io.jtelegram.api.update;

import io.jtelegram.api.TelegramBot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PollingUpdateProvider implements UpdateProvider {
    private final Map<TelegramBot, PollingUpdateThread> botThreads = new ConcurrentHashMap<>();
    // THESE VALUES SHOULD NOT BE MODIFIED AFTER SET
    // DO NOT USE REFLECTION TO CHANGE THESE
    private int sleepInterval = 50;
    private int timeout = 10;
    private List<UpdateType> allowedUpdates = new ArrayList<>();

    @Override
    public void listenFor(TelegramBot bot) {
        PollingUpdateThread thread = new PollingUpdateThread(bot, this);
        thread.start();
        botThreads.put(bot, thread);
    }

    @Override
    public void stopListening(TelegramBot bot) {
        botThreads.remove(bot).interrupt();
    }
}
