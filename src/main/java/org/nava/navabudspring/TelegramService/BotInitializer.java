package org.nava.navabudspring.TelegramService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotInitializer implements CommandLineRunner {

    private final NavaBot navaBot;

    public BotInitializer(NavaBot navaBot) {
        this.navaBot = navaBot;
    }

    @Override
    public void run(String... args) throws Exception {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(navaBot);
    }

}
