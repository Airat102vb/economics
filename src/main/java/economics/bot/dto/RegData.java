package economics.bot.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RegData {
  @JacksonXmlProperty(localName = "keyRate")
  private KeyRate keyRate;

  @JacksonXmlProperty(localName = "Inflation")
  private Inflation inflation;

  @JacksonXmlProperty(localName = "stavka_ref")
  private StavkaRef stavkaRef;

  @JacksonXmlProperty(localName = "GoldBaks")
  private GoldBaks goldBaks;

  public KeyRate getKeyRate() {
    return keyRate;
  }

  public void setKeyRate(KeyRate keyRate) {
    this.keyRate = keyRate;
  }

  public Inflation getInflation() {
    return inflation;
  }

  public void setInflation(Inflation inflation) {
    this.inflation = inflation;
  }

  public StavkaRef getStavkaRef() {
    return stavkaRef;
  }

  public void setStavkaRef(StavkaRef stavkaRef) {
    this.stavkaRef = stavkaRef;
  }

  public GoldBaks getGoldBaks() {
    return goldBaks;
  }

  public void setGoldBaks(GoldBaks goldBaks) {
    this.goldBaks = goldBaks;
  }
}
