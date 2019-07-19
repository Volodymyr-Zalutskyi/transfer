package volodymyr.zalutskyi.transfer.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class CabOrderRequest {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private LocalDate datePickup;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime timePickup;
    @Positive
    @NotNull
    private Integer minDrive;

    @NotNull
    private Long clientId;
    @NotEmpty
    private List<Long> stopIds;
    @NotNull
    private Long cabId;
}
