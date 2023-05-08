package com.example.todoapppractice

import java.time.LocalDate
import java.time.LocalTime

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(

    val taskName: String,
    val description: String,
    val time: LocalTime ,
    val date: LocalDate,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    )
