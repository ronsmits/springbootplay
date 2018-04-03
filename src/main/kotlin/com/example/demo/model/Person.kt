package com.example.demo.model

import org.springframework.data.repository.CrudRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Person (val firstName: String, val lastName : String){
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id : Int = 0

}

interface PersonRepo : CrudRepository<Person, Int> {
    fun findByLastName(lastName: String): List<Person>
}