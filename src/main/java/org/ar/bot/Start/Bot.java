package org.ar.bot.Start;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if (update.hasMessage()) {

            String text = update.getMessage().getText();
            String chatId = String.valueOf(update.getMessage().getChatId());
            Integer messageId = update.getMessage().getMessageId();

            System.out.println(text);
            System.out.println(chatId);
            System.out.println(messageId);

            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyToMessageId(messageId);
            sendMessage.setText(text);




        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }




    @Override
    public String getBotUsername() {
        return "@myfirstTestrobbot";
    }

    @Override
    public String getBotToken() {
        return "1140880693:AAGd24d-GZ9lkEuo_aKmWjGfyPNABD70RQ4";
    }


}
