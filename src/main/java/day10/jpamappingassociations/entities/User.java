package day10.jpamappingassociations.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Column(length = 70)
    private String userName;
    @Column(unique = true,length = 70)
    private String login;
    @Column(length = 70)
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY)
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Role> roles=new ArrayList<>();

}
