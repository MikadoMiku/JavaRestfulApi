package publicApi.DTO.v1;


import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Card {
    private Long id;

    private String name = "";

    private String type = "";

    private String desc = "";

    private String archetype = "";

    private String race = "";

    private String fileCode = "";

    private List<CardSetInfo> card_sets;
}
