package io.swagger.api;

import io.swagger.model.BalanceSheet;
import io.swagger.model.ProblemDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-06-28T18:25:49.127268551Z[GMT]")
@RestController
public class AssetsAndLiabilitiesApiController implements AssetsAndLiabilitiesApi {

    private static final Logger log = LoggerFactory.getLogger(AssetsAndLiabilitiesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public AssetsAndLiabilitiesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<BalanceSheet> getBalanceSheet(@NotNull @Parameter(in = ParameterIn.QUERY, description = "BNC client unique identifier." ,required=true,schema=@Schema()) @Valid @RequestParam(value = "bncId", required = true) String bncId
,@Parameter(in = ParameterIn.HEADER, description = "" ,required=true,schema=@Schema()) @RequestHeader(value="employeeId", required=true) String employeeId
,@Parameter(in = ParameterIn.HEADER, description = "Unique abbreviation (code) used to identify a Line of Business." ,required=true,schema=@Schema()) @RequestHeader(value="lineOfBusiness", required=true) String lineOfBusiness
,@Parameter(in = ParameterIn.HEADER, description = "The tracing information for the request." ,schema=@Schema()) @RequestHeader(value="traceparent", required=false) String traceparent
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BalanceSheet>(objectMapper.readValue("{\n  \"summary\" : {\n    \"assets\" : {\n      \"subTotal\" : [ {\n        \"rate\" : \"1.333\"\n      }, {\n        \"rate\" : \"1.333\"\n      } ]\n    },\n    \"message\" : \"COMPLETE\"\n  },\n  \"assets\" : {\n    \"insurances\" : [ {\n      \"lineOfBusiness\" : \"lineOfBusiness\",\n      \"issuingInstitution\" : \"006\",\n      \"origin\" : \"INTERNAL\",\n      \"type\" : \"CELI\",\n      \"accountNumber\" : \"234765\",\n      \"accountStatus\" : \"OPEN\",\n      \"accountAliasName\" : \"Fiducie familiale Tremblay\",\n      \"transit\" : \"12589\",\n      \"accountRole\" : \"MAIN/HOLDER\",\n      \"legislation\" : \"CA-QC\"\n    }, {\n      \"lineOfBusiness\" : \"lineOfBusiness\",\n      \"issuingInstitution\" : \"006\",\n      \"origin\" : \"INTERNAL\",\n      \"type\" : \"CELI\",\n      \"accountNumber\" : \"234765\",\n      \"accountStatus\" : \"OPEN\",\n      \"accountAliasName\" : \"Fiducie familiale Tremblay\",\n      \"transit\" : \"12589\",\n      \"accountRole\" : \"MAIN/HOLDER\",\n      \"legislation\" : \"CA-QC\"\n    } ],\n    \"bankings\" : [ {\n      \"lineOfBusiness\" : \"lineOfBusiness\",\n      \"issuingInstitution\" : \"006\",\n      \"origin\" : \"INTERNAL\",\n      \"type\" : \"CELI\",\n      \"accountNumber\" : \"234765\",\n      \"accountStatus\" : \"OPEN\",\n      \"accountAliasName\" : \"Fiducie familiale Tremblay\",\n      \"transit\" : \"12589\",\n      \"accountRole\" : \"MAIN/HOLDER\",\n      \"legislation\" : \"CA-QC\"\n    }, {\n      \"lineOfBusiness\" : \"lineOfBusiness\",\n      \"issuingInstitution\" : \"006\",\n      \"origin\" : \"INTERNAL\",\n      \"type\" : \"CELI\",\n      \"accountNumber\" : \"234765\",\n      \"accountStatus\" : \"OPEN\",\n      \"accountAliasName\" : \"Fiducie familiale Tremblay\",\n      \"transit\" : \"12589\",\n      \"accountRole\" : \"MAIN/HOLDER\",\n      \"legislation\" : \"CA-QC\"\n    } ],\n    \"goods\" : [ {\n      \"currency\" : \"USD\",\n      \"id\" : \"id\",\n      \"type\" : \"TANGIBLE\",\n      \"value\" : \"300000.00\",\n      \"status\" : \"VERIFIED\"\n    }, {\n      \"currency\" : \"USD\",\n      \"id\" : \"id\",\n      \"type\" : \"TANGIBLE\",\n      \"value\" : \"300000.00\",\n      \"status\" : \"VERIFIED\"\n    } ],\n    \"investments\" : [ {\n      \"lineOfBusiness\" : \"lineOfBusiness\",\n      \"issuingInstitution\" : \"006\",\n      \"origin\" : \"INTERNAL\",\n      \"type\" : \"CELI\",\n      \"accountNumber\" : \"234765\",\n      \"accountStatus\" : \"OPEN\",\n      \"accountAliasName\" : \"Fiducie familiale Tremblay\",\n      \"transit\" : \"12589\",\n      \"accountRole\" : \"MAIN/HOLDER\",\n      \"legislation\" : \"CA-QC\"\n    }, {\n      \"lineOfBusiness\" : \"lineOfBusiness\",\n      \"issuingInstitution\" : \"006\",\n      \"origin\" : \"INTERNAL\",\n      \"type\" : \"CELI\",\n      \"accountNumber\" : \"234765\",\n      \"accountStatus\" : \"OPEN\",\n      \"accountAliasName\" : \"Fiducie familiale Tremblay\",\n      \"transit\" : \"12589\",\n      \"accountRole\" : \"MAIN/HOLDER\",\n      \"legislation\" : \"CA-QC\"\n    } ]\n  },\n  \"bncId\" : \"0657EF111A92C051FB2AEF387114D8A6DBBE4239C6F36332B34F425B3B7B1BC0\",\n  \"emittedDateTime\" : \"2000-01-23T04:56:07.000+00:00\"\n}", BalanceSheet.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BalanceSheet>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BalanceSheet>(HttpStatus.NOT_IMPLEMENTED);
    }

}
