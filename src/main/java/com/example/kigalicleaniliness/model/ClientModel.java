package com.example.kigalicleaniliness.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "Client_Table")
@Data
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String email;

    private String phone;
    private String address;
    private int number_of_house;
    private float amount_to_be_paid;

    private String enabled;


}
