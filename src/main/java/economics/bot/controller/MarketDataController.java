package economics.bot.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import economics.bot.connection.Connection;
import economics.bot.dto.Envelope;
import economics.bot.dto.RegData;

public class MarketDataController {

  private static final String SOAP_ENDPOINT_URL = "https://www.cbr.ru/DailyInfoWebServ/DailyInfo.asmx";
  private static final String XML_INPUT = """
       <?xml version="1.0" encoding="utf-8"?>
       <soap12:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://www.w3.org/2003/05/soap-envelope">
       <soap12:Body>
       <MainInfoXML xmlns="http://web.cbr.ru/" />
       </soap12:Body>
       </soap12:Envelope>
       """;
  private final Connection connection = new Connection(SOAP_ENDPOINT_URL);

  public RegData getData() {
    RegData regData;

    try {
      String response = connection.makeRequest(XML_INPUT);

      // Демаршалинг
      XmlMapper xmlMapper = new XmlMapper();
      xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

      Envelope envelope = xmlMapper.readValue(response, Envelope.class);
      regData = envelope
          .getBody()
          .getMainInfoXMLResponse()
          .getMainInfoXMLResult()
          .getRegData();

      return regData;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
