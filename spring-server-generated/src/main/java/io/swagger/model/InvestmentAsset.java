package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * generic field for a financial asset
 */
@Schema(description = "generic field for a financial asset")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class InvestmentAsset   {
  @JsonProperty("type")
  private String type = null;

  @JsonProperty("origin")
  private String origin = null;

  @JsonProperty("issuingInstitution")
  private String issuingInstitution = null;

  @JsonProperty("accountNumber")
  private String accountNumber = null;

  @JsonProperty("value")
  private String value = null;

  @JsonProperty("accountRole")
  private String accountRole = null;

  @JsonProperty("accountStatus")
  private String accountStatus = null;

  @JsonProperty("transit")
  private String transit = null;

  @JsonProperty("legislation")
  private String legislation = null;

  @JsonProperty("accountAliasName")
  private String accountAliasName = null;

  @JsonProperty("lineOfBusiness")
  private String lineOfBusiness = null;

  @JsonProperty("convertedValue")
  private String convertedValue = null;

  @JsonProperty("currency")
  private String currency = null;

  public InvestmentAsset type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Indicates the type of account, EBX Category(Domain):BasePrdCd
   * @return type
   **/
  @Schema(example = "CELI", description = "Indicates the type of account, EBX Category(Domain):BasePrdCd")
      @NotNull

  @Size(max=30)   public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public InvestmentAsset origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Origin of the account, whether the account is internal or external
   * @return origin
   **/
  @Schema(example = "INTERNAL", description = "Origin of the account, whether the account is internal or external")
      @NotNull

  @Size(max=15)   public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public InvestmentAsset issuingInstitution(String issuingInstitution) {
    this.issuingInstitution = issuingInstitution;
    return this;
  }

  /**
   * Code of the institution with which the account is opened, EBX Category(Domain):FinancialInstitutionsCan
   * @return issuingInstitution
   **/
  @Schema(example = "006", description = "Code of the institution with which the account is opened, EBX Category(Domain):FinancialInstitutionsCan")
      @NotNull

  @Size(max=3)   public String getIssuingInstitution() {
    return issuingInstitution;
  }

  public void setIssuingInstitution(String issuingInstitution) {
    this.issuingInstitution = issuingInstitution;
  }

  public InvestmentAsset accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * Account number issued by the institute. This field in combination with transit identifies an account uniquely
   * @return accountNumber
   **/
  @Schema(example = "234765", description = "Account number issued by the institute. This field in combination with transit identifies an account uniquely")
      @NotNull

  @Size(max=20)   public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public InvestmentAsset value(String value) {
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

  public InvestmentAsset accountRole(String accountRole) {
    this.accountRole = accountRole;
    return this;
  }

  /**
   * Describes the client's role in this account. It will indicate whether the account is solely own by the client or is it a joint account, EBX Category(Domain):AgtPtyRlTp
   * @return accountRole
   **/
  @Schema(example = "MAIN/HOLDER", description = "Describes the client's role in this account. It will indicate whether the account is solely own by the client or is it a joint account, EBX Category(Domain):AgtPtyRlTp")
      @NotNull

  @Size(max=20)   public String getAccountRole() {
    return accountRole;
  }

  public void setAccountRole(String accountRole) {
    this.accountRole = accountRole;
  }

  public InvestmentAsset accountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  /**
   * Indicates the status of the account
   * @return accountStatus
   **/
  @Schema(example = "OPEN", description = "Indicates the status of the account")
      @NotNull

  @Size(max=20)   public String getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
  }

  public InvestmentAsset transit(String transit) {
    this.transit = transit;
    return this;
  }

  /**
   * Branch code of the account. This field in combination with accountNumber uniquely identifies an account
   * @return transit
   **/
  @Schema(example = "12589", description = "Branch code of the account. This field in combination with accountNumber uniquely identifies an account")
      @NotNull

  @Size(max=8)   public String getTransit() {
    return transit;
  }

  public void setTransit(String transit) {
    this.transit = transit;
  }

  public InvestmentAsset legislation(String legislation) {
    this.legislation = legislation;
    return this;
  }

  /**
   * Indicates the juristiction under which the account is ruled, EBX Category(Domain):ISO3166-2
   * @return legislation
   **/
  @Schema(example = "CA-QC", description = "Indicates the juristiction under which the account is ruled, EBX Category(Domain):ISO3166-2")
      @NotNull

  @Size(max=6)   public String getLegislation() {
    return legislation;
  }

  public void setLegislation(String legislation) {
    this.legislation = legislation;
  }

  public InvestmentAsset accountAliasName(String accountAliasName) {
    this.accountAliasName = accountAliasName;
    return this;
  }

  /**
   * Description of the account
   * @return accountAliasName
   **/
  @Schema(example = "Fiducie familiale Tremblay", description = "Description of the account")
      @NotNull

  @Size(max=50)   public String getAccountAliasName() {
    return accountAliasName;
  }

  public void setAccountAliasName(String accountAliasName) {
    this.accountAliasName = accountAliasName;
  }

  public InvestmentAsset lineOfBusiness(String lineOfBusiness) {
    this.lineOfBusiness = lineOfBusiness;
    return this;
  }

  /**
   * Unique abbreviation (code) used to identify a Line of Business.
   * @return lineOfBusiness
   **/
  @Schema(description = "Unique abbreviation (code) used to identify a Line of Business.")
      @NotNull

  @Size(max=12)   public String getLineOfBusiness() {
    return lineOfBusiness;
  }

  public void setLineOfBusiness(String lineOfBusiness) {
    this.lineOfBusiness = lineOfBusiness;
  }

  public InvestmentAsset convertedValue(String convertedValue) {
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

  public InvestmentAsset currency(String currency) {
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
    InvestmentAsset investmentAsset = (InvestmentAsset) o;
    return Objects.equals(this.type, investmentAsset.type) &&
        Objects.equals(this.origin, investmentAsset.origin) &&
        Objects.equals(this.issuingInstitution, investmentAsset.issuingInstitution) &&
        Objects.equals(this.accountNumber, investmentAsset.accountNumber) &&
        Objects.equals(this.value, investmentAsset.value) &&
        Objects.equals(this.accountRole, investmentAsset.accountRole) &&
        Objects.equals(this.accountStatus, investmentAsset.accountStatus) &&
        Objects.equals(this.transit, investmentAsset.transit) &&
        Objects.equals(this.legislation, investmentAsset.legislation) &&
        Objects.equals(this.accountAliasName, investmentAsset.accountAliasName) &&
        Objects.equals(this.lineOfBusiness, investmentAsset.lineOfBusiness) &&
        Objects.equals(this.convertedValue, investmentAsset.convertedValue) &&
        Objects.equals(this.currency, investmentAsset.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, origin, issuingInstitution, accountNumber, value, accountRole, accountStatus, transit, legislation, accountAliasName, lineOfBusiness, convertedValue, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvestmentAsset {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    issuingInstitution: ").append(toIndentedString(issuingInstitution)).append("\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    accountRole: ").append(toIndentedString(accountRole)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    transit: ").append(toIndentedString(transit)).append("\n");
    sb.append("    legislation: ").append(toIndentedString(legislation)).append("\n");
    sb.append("    accountAliasName: ").append(toIndentedString(accountAliasName)).append("\n");
    sb.append("    lineOfBusiness: ").append(toIndentedString(lineOfBusiness)).append("\n");
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
