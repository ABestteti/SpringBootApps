package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SummaryAssets;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Summary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class Summary   {
  @JsonProperty("assets")
  private SummaryAssets assets = null;

  @JsonProperty("message")
  private String message = null;

  public Summary assets(SummaryAssets assets) {
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
    public SummaryAssets getAssets() {
    return assets;
  }

  public void setAssets(SummaryAssets assets) {
    this.assets = assets;
  }

  public Summary message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  @Schema(example = "COMPLETE", description = "")
      @NotNull

    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Summary summary = (Summary) o;
    return Objects.equals(this.assets, summary.assets) &&
        Objects.equals(this.message, summary.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assets, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Summary {\n");
    
    sb.append("    assets: ").append(toIndentedString(assets)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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
