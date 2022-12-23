package com.example.demo

import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,

    @Column
    val firstname: String,
    @Column
    val lastname: String,

    @Column
    @Enumerated(EnumType.STRING)
    val gender: Gender,

    @Column
    val dateOfBirth: LocalDate
)
