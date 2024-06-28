package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubTotalInformation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class SubTotalInformation   {
  @JsonProperty("amount")
  private String amount = null;

  @JsonProperty("rate")
  private String rate = null;

  @JsonProperty("convertedAmount")
  private String convertedAmount = null;

  @JsonProperty("currency")
  private String currency = null;

  public SubTotalInformation amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Total value of the asset or liability.
   * @return amount
   **/
  @Schema(example = "300000.00", description = "Total value of the asset or liability.")
      @NotNull

  @Pattern(regexp="^[-]{0,1}[0-9]{1,20}\\.[0-9]{2}$")   public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public SubTotalInformation rate(String rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Interest rate offered on the product.
   * @return rate
   **/
  @Schema(example = "1.333", description = "Interest rate offered on the product.")
      @NotNull

  @Pattern(regexp="^[0-9]{1,3}\\.[0-9]{1,3}$")   public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public SubTotalInformation convertedAmount(String convertedAmount) {
    this.convertedAmount = convertedAmount;
    return this;
  }

  /**
   * Total value of the asset or liability.
   * @return convertedAmount
   **/
  @Schema(example = "300000.00", description = "Total value of the asset or liability.")
      @NotNull

  @Pattern(regexp="^[-]{0,1}[0-9]{1,20}\\.[0-9]{2}$")   public String getConvertedAmount() {
    return convertedAmount;
  }

  public void setConvertedAmount(String convertedAmount) {
    this.convertedAmount = convertedAmount;
  }

  public SubTotalInformation currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * currency of the account. EBX Category(Domain):CurrencyTp
   * @return currency
   **/
  @Schema(example = "USD", description = "currency of the account. EBX Category(Domain):CurrencyTp")
      @NotNull

  @Pattern(regexp="^([A-Z]{3,3})$") @Size(max=3)   public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubTotalInformation subTotalInformation = (SubTotalInformation) o;
    return Objects.equals(this.amount, subTotalInformation.amount) &&
        Objects.equals(this.rate, subTotalInformation.rate) &&
        Objects.equals(this.convertedAmount, subTotalInformation.convertedAmount) &&
        Objects.equals(this.currency, subTotalInformation.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, rate, convertedAmount, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubTotalInformation {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    convertedAmount: ").append(toIndentedString(convertedAmount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
