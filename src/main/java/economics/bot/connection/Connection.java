package economics.bot.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {

  private final URL URL;

  public Connection(String url) {
    try {
      this.URL = new URL(url);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String makeRequest(String requestBody) {
    InputStream inputStream = null;
    BufferedReader bufferedReader = null;
    HttpURLConnection connection = getConnection();
    try(OutputStream os = connection.getOutputStream();
    ) {
      os.write(requestBody.getBytes());
      os.flush();
      os.close();

      int responseCode = connection.getResponseCode();
      if (responseCode == HttpURLConnection.HTTP_OK) {
        System.out.println("SOAP Request Sent Successfully.");
        // Чтение ответа
        String inputLine;
        StringBuilder response = new StringBuilder();

        inputStream = connection.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((inputLine = bufferedReader.readLine()) != null) {
          response.append(inputLine);
        }
        return response.toString();
      } else {
        throw new RuntimeException("Error in SOAP Request: " + responseCode);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        assert inputStream != null;
        inputStream.close();
        assert bufferedReader != null;
        bufferedReader.close();
      } catch (IOException ignored) {}
    }
  }

  private HttpURLConnection getConnection() {
    HttpURLConnection connection = null;
    try {
      connection = (HttpURLConnection) URL.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
      connection.setDoOutput(true);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return connection;
  }
}
