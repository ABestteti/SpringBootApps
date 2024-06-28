package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.SubTotalInformation;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SummaryAssets
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class SummaryAssets   {
  @JsonProperty("subTotal")
  @Valid
  private List<SubTotalInformation> subTotal = null;

  @JsonProperty("total")
  private String total = null;

  public SummaryAssets subTotal(List<SubTotalInformation> subTotal) {
    this.subTotal = subTotal;
    return this;
  }

  public SummaryAssets addSubTotalItem(SubTotalInformation subTotalItem) {
    if (this.subTotal == null) {
      this.subTotal = new ArrayList<SubTotalInformation>();
    }
    this.subTotal.add(subTotalItem);
    return this;
  }

  /**
   * Get subTotal
   * @return subTotal
   **/
  @Schema(description = "")
      @NotNull
    @Valid
    public List<SubTotalInformation> getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(List<SubTotalInformation> subTotal) {
    this.subTotal = subTotal;
  }

  public SummaryAssets total(String total) {
    this.total = total;
    return this;
  }

  /**
   * Total value of the asset or liability.
   * @return total
   **/
  @Schema(example = "300000.00", description = "Total value of the asset or liability.")
      @NotNull

  @Pattern(regexp="^[-]{0,1}[0-9]{1,20}\\.[0-9]{2}$")   public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SummaryAssets summaryAssets = (SummaryAssets) o;
    return Objects.equals(this.subTotal, summaryAssets.subTotal) &&
        Objects.equals(this.total, summaryAssets.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subTotal, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SummaryAssets {\n");
    
    sb.append("    subTotal: ").append(toIndentedString(subTotal)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
