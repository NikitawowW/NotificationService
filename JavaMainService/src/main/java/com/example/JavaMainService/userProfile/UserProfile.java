package com.example.JavaMainService.user;

import com.example.JavaMainService.notifications.model.Communication;
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

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;
}
