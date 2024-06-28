package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BalanceSheetAssets;
import io.swagger.model.Summary;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Details of the balance sheet of assets and liabilities for a party.
 */
@Schema(description = "Details of the balance sheet of assets and liabilities for a party.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class BalanceSheet   {
  @JsonProperty("bncId")
  private String bncId = null;

  @JsonProperty("emittedDateTime")
  private OffsetDateTime emittedDateTime = null;

  @JsonProperty("assets")
  private BalanceSheetAssets assets = null;

  @JsonProperty("summary")
  private Summary summary = null;

  public BalanceSheet bncId(String bncId) {
    this.bncId = bncId;
    return this;
  }

  /**
   * BNC client unique identifier.
   * @return bncId
   **/
  @Schema(example = "0657EF111A92C051FB2AEF387114D8A6DBBE4239C6F36332B34F425B3B7B1BC0", description = "BNC client unique identifier.")
      @NotNull

    public String getBncId() {
    return bncId;
  }

  public void setBncId(String bncId) {
    this.bncId = bncId;
  }

  public BalanceSheet emittedDateTime(OffsetDateTime emittedDateTime) {
    this.emittedDateTime = emittedDateTime;
    return this;
  }

  /**
   * Date and time in ISO-8601 format (YYYY-MM-DDThh:mm:ss.sssZ) the current status was reached.  example: '2024-12-31T00:00:00Z'
   * @return emittedDateTime
   **/
  @Schema(description = "Date and time in ISO-8601 format (YYYY-MM-DDThh:mm:ss.sssZ) the current status was reached.  example: '2024-12-31T00:00:00Z'")
      @NotNull

    @Valid
    public OffsetDateTime getEmittedDateTime() {
    return emittedDateTime;
  }

  public void setEmittedDateTime(OffsetDateTime emittedDateTime) {
    this.emittedDateTime = emittedDateTime;
  }

  public BalanceSheet assets(BalanceSheetAssets assets) {
    this.assets = assets;
    return this;
  }

  /**
   * Get assets
   * @return assets
   **/
  @Schema(description = "")
      @NotNull

    @Valid
    public BalanceSheetAssets getAssets() {
    return assets;
  }

  public void setAssets(BalanceSheetAssets assets) {
    this.assets = assets;
  }

  public BalanceSheet summary(Summary summary) {
    this.summary = summary;
    return this;
  }

  /**
   * Get summary
   * @return summary
   **/
  @Schema(description = "")
      @NotNull

    @Valid
    public Summary getSummary() {
    return summary;
  }

  public void setSummary(Summary summary) {
    this.summary = summary;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BalanceSheet balanceSheet = (BalanceSheet) o;
    return Objects.equals(this.bncId, balanceSheet.bncId) &&
        Objects.equals(this.emittedDateTime, balanceSheet.emittedDateTime) &&
        Objects.equals(this.assets, balanceSheet.assets) &&
        Objects.equals(this.summary, balanceSheet.summary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bncId, emittedDateTime, assets, summary);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BalanceSheet {\n");
    
    sb.append("    bncId: ").append(toIndentedString(bncId)).append("\n");
    sb.append("    emittedDateTime: ").append(toIndentedString(emittedDateTime)).append("\n");
    sb.append("    assets: ").append(toIndentedString(assets)).append("\n");
    sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
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
