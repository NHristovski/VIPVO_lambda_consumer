import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdditionRequest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("first_number")
    private Long firstNumber;

    @JsonProperty("second_number")
    private Long secondNumber;
}
