package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "JavaBotCode_bot";
    public static final String TOKEN = "6735666782:AAG1mvgHeeMyr15lJxKICd1Zr2tE_o4SPLM";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equalsIgnoreCase("/start")){
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera","step_1_btn"));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Tomar una salchica! +20 de fama","step_2_btn",
                            "Tomar un pescado! +20 de fama","step_2_btn",
                            "Tirar una lata de pepinillos! +20 de fama","step_2_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Romper al robot aspirador", "step_3_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Enviar al robot aspiradora por comida! + 30 puntos", "step_4_btn",
                            "Dar un paseo en el robot aspiradora! + 30 puntos", "step_4_btn",
                            "Huir del robot aspiradora! + 30 puntos", "step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT, Map.of("Ponte las gafas para poder seguir avanzando", "step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            setUserGlory(30);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Usar el guantelete del infinito! + 40 puntos", "step_6_btn",
                    "Obtener una cantidad de croquetas! + 40 puntos", "step_6_btn",
                    "Darte una ducha! + 40 puntos", "step_6_btn"));
        }

        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT);

        } else if (getMessageText().equals("gatomago")) {
            sendTextMessageAsync("lo lograste has desbloqueado la seguridad de la computadora", Map.of("Siguiente nivel", "step_7_btn"));

        }

        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            setUserGlory(40);
            sendTextMessageAsync(STEP_8_TEXT, Map.of("Salir fuera de la casa", "step_8_btn"));

        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            sendTextMessageAsync(FINAL_TEXT, Map.of());

        }
    }


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}