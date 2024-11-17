package economics.bot;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotApplication {

	public static void main(String[] args) throws TelegramApiException {
		TelegramBotsLongPollingApplication pollingApplication = new TelegramBotsLongPollingApplication();
		pollingApplication.registerBot(System.getenv("TBOT"), new EconomicsBot(System.getenv("TBOT")));
	}
}