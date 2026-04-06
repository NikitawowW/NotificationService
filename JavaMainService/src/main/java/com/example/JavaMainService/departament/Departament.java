package com.example.JavaMainService.departament;

import com.example.JavaMainService.user.User;
import com.example.JavaMainService.userProfile.UserProfile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "departament")
@Getter
@Setter
@NoArgsConstructor
public class Departament {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "departament")
    private UserProfile userProfile;

    public Departament(String name) {
        this.name = name;
    }
}
