package com.example.demo

import com.example.demo.model.Person
import com.example.demo.model.PersonRepo
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import javax.inject.Inject
import javax.persistence.EntityManager

@RunWith(SpringRunner::class)
@DataJpaTest

class PersonRepoTest {
    @Inject
    lateinit var em: EntityManager
    @Inject
    lateinit var repo: PersonRepo

    @Test
    fun testFindAll() {
        em.persist(Person(firstName = "Piet", lastName = "Puk"))
        val findAll = repo.findAll()
        assertEquals(1, findAll.count())
    }

    @Test
    fun findByLastName() {
        em.persist(Person("Piet", "Puk"))
        em.persist(Person("Zwarte", "Piet"))

        val findal = repo.findByLastName("Puk")
        assertEquals(findal.size, 1)
        assertEquals(findal[0].firstName, "Piet")
    }
}