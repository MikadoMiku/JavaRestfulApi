package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name="AppUser")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema="MIKUCARDSCHEMA")
public class AppUser {

    @Id
    @SequenceGenerator(name = "my_seq3", sequenceName = "seq3", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq3")
    private Long id;

    private String name;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppUserRole> roles = new ArrayList<>();
}
