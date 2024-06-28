package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Goods assets.
 */
@Schema(description = "Goods assets.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class GoodAsset   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("convertedValue")
  private String convertedValue = null;

  @JsonProperty("currency")
  private String currency = null;

  public GoodAsset id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique id for good assets.
   * @return id
   **/
  @Schema(description = "Unique id for good assets.")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GoodAsset type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(example = "TANGIBLE", description = "")
      @NotNull

    public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public GoodAsset status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(example = "VERIFIED", description = "")
      @NotNull

    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GoodAsset value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Total value of the asset or liability.
   * @return value
   **/
  @Schema(example = "300000.00", description = "Total value of the asset or liability.")
      @NotNull

  @Pattern(regexp="^[-]{0,1}[0-9]{1,20}\\.[0-9]{2}$")   public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public GoodAsset convertedValue(String convertedValue) {
    this.convertedValue = convertedValue;
    return this;
  }

  /**
   * Total value of the asset or liability.
   * @return convertedValue
   **/
  @Schema(example = "300000.00", description = "Total value of the asset or liability.")
      @NotNull

  @Pattern(regexp="^[-]{0,1}[0-9]{1,20}\\.[0-9]{2}$")   public String getConvertedValue() {
    return convertedValue;
  }

  public void setConvertedValue(String convertedValue) {
    this.convertedValue = convertedValue;
  }

  public GoodAsset currency(String currency) {
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
    GoodAsset goodAsset = (GoodAsset) o;
    return Objects.equals(this.id, goodAsset.id) &&
        Objects.equals(this.type, goodAsset.type) &&
        Objects.equals(this.status, goodAsset.status) &&
        Objects.equals(this.value, goodAsset.value) &&
        Objects.equals(this.convertedValue, goodAsset.convertedValue) &&
        Objects.equals(this.currency, goodAsset.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, status, value, convertedValue, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoodAsset {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    convertedValue: ").append(toIndentedString(convertedValue)).append("\n");
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
