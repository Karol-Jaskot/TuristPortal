package pl.jaskot.turistportal.backend.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private LocalDate create_date;

}