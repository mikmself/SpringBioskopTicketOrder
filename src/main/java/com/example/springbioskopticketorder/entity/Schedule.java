package com.example.springbioskopticketorder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue
    private int id_schedule;
    @Column(nullable = true)
    private int film_id;
    @Column(nullable = true)
    private int theater_id;
    private Date date;
    private Time time;
}
