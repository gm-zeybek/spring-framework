package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseEntity {
    private Integer seatNumber;
    private Integer rowNumber;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private MovieCinema movieCinema;
    @ManyToOne(fetch = FetchType.EAGER)
    private User userAccount;

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                ", dateTime=" + dateTime +
                '}';
    }
}
