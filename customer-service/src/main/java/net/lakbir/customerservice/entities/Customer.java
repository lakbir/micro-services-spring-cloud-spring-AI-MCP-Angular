package net.lakbir.customerservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Created by lakbir.abderrahim on 03/02/2026
 */

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
