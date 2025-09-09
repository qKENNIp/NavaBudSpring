package org.nava.navabudspring.TelegramService;

import org.nava.navabudspring.Entity.ClientDate;
import org.nava.navabudspring.ServisLayer.ServiceLayer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
public class NavaBot extends TelegramLongPollingBot {

    private final ServiceLayer serviceLayer;

    @Value("${telegram.bot.username}")
    private String name;

    @Value("${telegram.bot.token}")
    private String token;

    public NavaBot(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;

    }

    @Override
    public String getBotUsername() {
        return this.name;
    }
    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasCallbackQuery()){
            Answer(update);
        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case "/start":
                    break;
                case "/showAllClients":
                    ShowClients(update);
                    break;
                case "/sendWithOutAnswer":
                    ShowClientsWithoutAnswer(update);
                    break;
            }
        }
    }

    private void ShowClients(Update update) {
        // find all clients from DB
        List<ClientDate> clients = serviceLayer.findAll();

        // sending message with all clients
        for (ClientDate client : clients) {
            SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), client.toString());
            try {
                execute(sendMessage);

            } catch (TelegramApiException e) {}
        }

    }

    private void ShowClientsWithoutAnswer(Update update) {
        List<ClientDate> clients = serviceLayer.findByAnswerFalse();

        for (ClientDate client : clients) {
            SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), client.toString());

            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setText("Ответил");
            button.setCallbackData(client.getClientId().toString());

            InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
            markup.setKeyboard(List.of(List.of(button)));

            sendMessage.setReplyMarkup(markup);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {}
        }
    }

    private void Answer(Update update) {

        CallbackQuery callbackQuery = update.getCallbackQuery();
        Long callbackData = Long.parseLong(callbackQuery.getData()) ;
        SendMessage response = new SendMessage();

        serviceLayer.setAnswerTrue(callbackData);

        response.setChatId(update.getMessage().getChatId());
        response.setText("Клиент отмечен как отвеченный");

        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
