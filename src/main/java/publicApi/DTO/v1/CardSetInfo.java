package publicApi.DTO.v1;

import lombok.Data;

@Data
public class CardSetInfo {
    private Long id;

    private String set_name = "";

    private String set_code = "";

    private String set_rarity = "";

    private String set_rarity_code = "";
}
