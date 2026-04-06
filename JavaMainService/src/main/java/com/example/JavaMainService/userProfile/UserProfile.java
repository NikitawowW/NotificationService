package com.example.JavaMainService.userProfile;

import com.example.JavaMainService.departament.Departament;
import com.example.JavaMainService.notifications.model.Communication;
import com.example.JavaMainService.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "communication")
    @Enumerated(EnumType.STRING)
    private Communication communication;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "departement_id")
    private Departament departament;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;

    public UserProfile(String lastName, String name, String surname, Communication communication, Position position, Grade grade, User user) {
        this.lastName = lastName;
        this.name = name;
        this.surname = surname;
        this.communication = communication;
        this.position = position;
        this.grade = grade;
        this.user = user;
    }
}
