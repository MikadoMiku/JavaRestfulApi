package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="CardSetInfo")
@Data
@NoArgsConstructor
@Table(name="cardSetInfo", schema="MIKUCARDSCHEMA")
public class CardSetInfo {

    @Id
    @SequenceGenerator(name = "my_seq2", sequenceName = "seq2", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq2")
    private Long id;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "cardSetName")
    private String set_name = "";

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cardSetCode")
    private String set_code = "";

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cardSetRarity")
    private String set_rarity = "";

    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "cardSetRarityCode")
    private String set_rarity_code = "";
}
