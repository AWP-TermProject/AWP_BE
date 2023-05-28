package team.buildup.registerservice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "reservation_date")
    private String reservationDate;

    @Column(name = "drone_type")
    private String droneType;

    public Register(String username, String reservationDate, String droneType) {
        this.username = username;
        this.reservationDate = reservationDate;
        this.droneType = droneType;
    }
}