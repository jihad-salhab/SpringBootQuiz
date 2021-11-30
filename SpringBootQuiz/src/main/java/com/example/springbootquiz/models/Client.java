package com.example.springbootquiz.models;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "client_name")
    String clientName;
    @Column(name = "client_last_name")
    String clientLastName;
    @Column(name = "client_mobile")
    String clientMobile;
}
