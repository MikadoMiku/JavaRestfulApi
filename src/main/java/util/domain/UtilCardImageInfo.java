package util.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UtilCardImageInfo {

    private String image_url = "";

    private String image_url_small = "";
}
