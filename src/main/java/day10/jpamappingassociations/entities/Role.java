package day10.jpamappingassociations.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @Column(length = 100,unique = true)
    private String groupName;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Users> users=new ArrayList<>();
}
