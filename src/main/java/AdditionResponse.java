import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AdditionResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("has_error")
    private Boolean hasError;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("addition_result")
    private Long additionResult;
}

