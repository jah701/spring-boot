package com.spring.boot.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "external_id")
    private String externalId;
    private String name;
    private String password;
    @Column(name = "helpfulness_numerator")
    private String helpfulnessNumerator;
    @Column(name = "helpfulness_denominator")
    private String helpfulnessDenominator;
    @ManyToMany
    private Set<Role> roles;
}
