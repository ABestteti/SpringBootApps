package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ProblemElement
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")


public class ProblemElement   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("instance")
  private String instance = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("reasonCode")
  private String reasonCode = null;

  @JsonProperty("reasonType")
  private String reasonType = null;

  @JsonProperty("severity")
  private String severity = null;

  @JsonProperty("sourceCode")
  private String sourceCode = null;

  @JsonProperty("timestamp")
  private OffsetDateTime timestamp = null;

  public ProblemElement id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the specific element in cause.
   * @return id
   **/
  @Schema(example = "5138843532303", description = "The ID of the specific element in cause.")
      @NotNull

    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ProblemElement instance(String instance) {
    this.instance = instance;
    return this;
  }

  /**
   * A URI reference that identifies the specific occurrence of the element in cause.
   * @return instance
   **/
  @Schema(example = "/mcp/error/RF-IOC-001", description = "A URI reference that identifies the specific occurrence of the element in cause.")
      @NotNull

    public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }

  public ProblemElement message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A short, human-readable summary of the reason-code.
   * @return message
   **/
  @Schema(example = "Failed due to error", description = "A short, human-readable summary of the reason-code.")
      @NotNull

    public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ProblemElement name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the specific element in cause.
   * @return name
   **/
  @Schema(example = "occupation-api", description = "The name of the specific element in cause.")
      @NotNull

    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProblemElement reasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
    return this;
  }

  /**
   * A code identifying the specific reason why the element is in cause.
   * @return reasonCode
   **/
  @Schema(example = "RF-IOC-001", description = "A code identifying the specific reason why the element is in cause.")
      @NotNull

    public String getReasonCode() {
    return reasonCode;
  }

  public void setReasonCode(String reasonCode) {
    this.reasonCode = reasonCode;
  }

  public ProblemElement reasonType(String reasonType) {
    this.reasonType = reasonType;
    return this;
  }

  /**
   * A code identifying the reason why the element is in cause.
   * @return reasonType
   **/
  @Schema(example = "Error", description = "A code identifying the reason why the element is in cause.")
      @NotNull

    public String getReasonType() {
    return reasonType;
  }

  public void setReasonType(String reasonType) {
    this.reasonType = reasonType;
  }

  public ProblemElement severity(String severity) {
    this.severity = severity;
    return this;
  }

  /**
   * A code identifying the specific severity of the cause.
   * @return severity
   **/
  @Schema(example = "FATAL", description = "A code identifying the specific severity of the cause.")
      @NotNull

    public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public ProblemElement sourceCode(String sourceCode) {
    this.sourceCode = sourceCode;
    return this;
  }

  /**
   * The system code of the specific element in cause.
   * @return sourceCode
   **/
  @Schema(example = "3127", description = "The system code of the specific element in cause.")
      @NotNull

    public String getSourceCode() {
    return sourceCode;
  }

  public void setSourceCode(String sourceCode) {
    this.sourceCode = sourceCode;
  }

  public ProblemElement timestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * A timestamp identifying the specific occurrence of the element in cause.
   * @return timestamp
   **/
  @Schema(description = "A timestamp identifying the specific occurrence of the element in cause.")
      @NotNull

    @Valid
    public OffsetDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(OffsetDateTime timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProblemElement problemElement = (ProblemElement) o;
    return Objects.equals(this.id, problemElement.id) &&
        Objects.equals(this.instance, problemElement.instance) &&
        Objects.equals(this.message, problemElement.message) &&
        Objects.equals(this.name, problemElement.name) &&
        Objects.equals(this.reasonCode, problemElement.reasonCode) &&
        Objects.equals(this.reasonType, problemElement.reasonType) &&
        Objects.equals(this.severity, problemElement.severity) &&
        Objects.equals(this.sourceCode, problemElement.sourceCode) &&
        Objects.equals(this.timestamp, problemElement.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, instance, message, name, reasonCode, reasonType, severity, sourceCode, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProblemElement {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reasonCode: ").append(toIndentedString(reasonCode)).append("\n");
    sb.append("    reasonType: ").append(toIndentedString(reasonType)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    sourceCode: ").append(toIndentedString(sourceCode)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
