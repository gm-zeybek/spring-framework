package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.loadtime.definition.Definition;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    @ManyToOne(fetch = FetchType.LAZY)  // it is preferable way no need to declare again oneToMany other side
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)  // default fetch type differentiate based on type many or one
    private Cinema cinema;

}
