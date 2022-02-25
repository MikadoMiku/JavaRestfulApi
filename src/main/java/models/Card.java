package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.domain.UtilCardImageInfo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name="Card")
@Data
@NoArgsConstructor
@Table(name="cards", schema="MIKUCARDSCHEMA")
public class Card {

    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "seq1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Long id;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "card_name")
    private String name = "";

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "card_type")
    private String type = "";

    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "card_description")
    private String desc = "";

    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "card_archetype")
    private String archetype = "NONE";

    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "card_attribute")
    private String attribute = "NONE";

    @NotNull
    @Column(name = "card_atk")
    private int atk;

    @NotNull
    @Column(name = "card_def")
    private int def;

    @NotNull
    @Column(name = "card_level")
    private int level;

    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "card_race")
    private String race = "";

    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "card_image_fileCode")
    private String fileCode = UUID.randomUUID().toString();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "card_id", referencedColumnName = "id")
    private Collection<CardSetInfo> card_sets;

    @Transient
    private List<UtilCardImageInfo> card_images;
}
