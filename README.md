**Telegram bot that gets info from Central Bank SOAP service**

Implemented two commands:
- `/key_rate` - Receives the key rate for the current day from the Сentral bank API and returns it to the user in the telegram chat.
- `/inflation` - Receives the inflation rate for the current day from the Central bank API and returns it to the user in the telegram chat.

---

For testing, you should create own telegram bot, issue and set it's token in environment variables with "TBOT" key.
