package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BankingAsset;
import io.swagger.model.GoodAsset;
import io.swagger.model.InsuranceAsset;
import io.swagger.model.InvestmentAsset;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Assets of the party.
 */
@Schema(description = "Assets of the party.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class BalanceSheetAssets   {
  @JsonProperty("goods")
  @Valid
  private List<GoodAsset> goods = null;

  @JsonProperty("bankings")
  @Valid
  private List<BankingAsset> bankings = null;

  @JsonProperty("investments")
  @Valid
  private List<InvestmentAsset> investments = null;

  @JsonProperty("insurances")
  @Valid
  private List<InsuranceAsset> insurances = null;

  public BalanceSheetAssets goods(List<GoodAsset> goods) {
    this.goods = goods;
    return this;
  }

  public BalanceSheetAssets addGoodsItem(GoodAsset goodsItem) {
    if (this.goods == null) {
      this.goods = new ArrayList<GoodAsset>();
    }
    this.goods.add(goodsItem);
    return this;
  }

  /**
   * Get goods
   * @return goods
   **/
  @Schema(description = "")
      @NotNull
    @Valid
    public List<GoodAsset> getGoods() {
    return goods;
  }

  public void setGoods(List<GoodAsset> goods) {
    this.goods = goods;
  }

  public BalanceSheetAssets bankings(List<BankingAsset> bankings) {
    this.bankings = bankings;
    return this;
  }

  public BalanceSheetAssets addBankingsItem(BankingAsset bankingsItem) {
    if (this.bankings == null) {
      this.bankings = new ArrayList<BankingAsset>();
    }
    this.bankings.add(bankingsItem);
    return this;
  }

  /**
   * Get bankings
   * @return bankings
   **/
  @Schema(description = "")
      @NotNull
    @Valid
    public List<BankingAsset> getBankings() {
    return bankings;
  }

  public void setBankings(List<BankingAsset> bankings) {
    this.bankings = bankings;
  }

  public BalanceSheetAssets investments(List<InvestmentAsset> investments) {
    this.investments = investments;
    return this;
  }

  public BalanceSheetAssets addInvestmentsItem(InvestmentAsset investmentsItem) {
    if (this.investments == null) {
      this.investments = new ArrayList<InvestmentAsset>();
    }
    this.investments.add(investmentsItem);
    return this;
  }

  /**
   * Get investments
   * @return investments
   **/
  @Schema(description = "")
      @NotNull
    @Valid
    public List<InvestmentAsset> getInvestments() {
    return investments;
  }

  public void setInvestments(List<InvestmentAsset> investments) {
    this.investments = investments;
  }

  public BalanceSheetAssets insurances(List<InsuranceAsset> insurances) {
    this.insurances = insurances;
    return this;
  }

  public BalanceSheetAssets addInsurancesItem(InsuranceAsset insurancesItem) {
    if (this.insurances == null) {
      this.insurances = new ArrayList<InsuranceAsset>();
    }
    this.insurances.add(insurancesItem);
    return this;
  }

  /**
   * Get insurances
   * @return insurances
   **/
  @Schema(description = "")
      @NotNull
    @Valid
    public List<InsuranceAsset> getInsurances() {
    return insurances;
  }

  public void setInsurances(List<InsuranceAsset> insurances) {
    this.insurances = insurances;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BalanceSheetAssets balanceSheetAssets = (BalanceSheetAssets) o;
    return Objects.equals(this.goods, balanceSheetAssets.goods) &&
        Objects.equals(this.bankings, balanceSheetAssets.bankings) &&
        Objects.equals(this.investments, balanceSheetAssets.investments) &&
        Objects.equals(this.insurances, balanceSheetAssets.insurances);
  }

  @Override
  public int hashCode() {
    return Objects.hash(goods, bankings, investments, insurances);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BalanceSheetAssets {\n");
    
    sb.append("    goods: ").append(toIndentedString(goods)).append("\n");
    sb.append("    bankings: ").append(toIndentedString(bankings)).append("\n");
    sb.append("    investments: ").append(toIndentedString(investments)).append("\n");
    sb.append("    insurances: ").append(toIndentedString(insurances)).append("\n");
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
