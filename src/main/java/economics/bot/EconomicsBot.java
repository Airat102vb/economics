package economics.bot;

import economics.bot.controller.MarketDataController;
import economics.bot.dto.RegData;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import java.util.List;
import static economics.bot.Command.INFLATION;
import static economics.bot.Command.KEY_RATE;
import static java.lang.String.format;

public class EconomicsBot implements LongPollingSingleThreadUpdateConsumer {

  private TelegramClient telegramClient;
  private MarketDataController marketDataController = new MarketDataController();

  public EconomicsBot(String token) {
    this.telegramClient = new OkHttpTelegramClient(token);
  }

  @Override
  public void consume(List<Update> updates) {
    LongPollingSingleThreadUpdateConsumer.super.consume(updates);
  }

  @Override
  public void consume(Update update) {
    final String pattern = "%s: %s";
    SendMessage message = null;

    if (update.hasMessage()) {
      String chatId = update.getMessage().getChatId().toString();

      if (update.getMessage().isCommand()) {
        RegData data = marketDataController.getData();
        message = switch (update.getMessage().getText()) {
          case KEY_RATE -> new SendMessage(chatId, format(pattern, data.getKeyRate().getTitle(), data.getKeyRate().getValue()));
          case INFLATION -> new SendMessage(chatId, format(pattern, data.getInflation().getTitle(), data.getInflation().getValue()));
          default -> new SendMessage(chatId, "Вы ввели несуществующую команду");
        };
      } else {
        message = new SendMessage(chatId, "Вам нужно выбрать, что вы хотите узнать");
      }

      try {
        telegramClient.execute(message);
      } catch (TelegramApiException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
