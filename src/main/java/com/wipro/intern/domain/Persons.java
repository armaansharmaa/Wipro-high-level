package com.wipro.intern.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="persons")
public class Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    Integer id;

    @Column(name = "person_first_name")
    String firstName;

    @Column(name = "person_last_name")
    String lastName;

    @Column(name = "person_middle_name")
    String middleName;

    @Column(name = "person_email")
    String email;

    @Column(name = "person_street")
    String street;

    @Column(name = "person_city")
    String city;

    @Column(name = "person_state")
    String state;

    @Column(name = "person_country")
    String country;

    @Column(name = "person_postalcode")
    String pincode;

    @Column(name = "person_employer_name")
    String employerName;

    @Column(name = "employer_id")
    String employerId;

    @Column(name = "employer_street")
    String employerStreet;


    @Column(name = "employer_city")
    String employerCity;

    @Column(name = "employer_state")
    String employerState;

    @Column(name = "employer_country")
    String employerCountry;

    @Column(name = "employer_postalcode")
    String employerPincode;

}