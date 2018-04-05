package com.example.demo.service

import com.example.demo.model.Person
import com.example.demo.model.PersonRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.websocket.server.PathParam


@RestController
@RequestMapping("/persons")
class Homecontroller {
    @Autowired
    lateinit var repo: PersonRepo

    @GetMapping("{id}")
    fun getById(@PathVariable("id") id: Int): ResponseEntity<*> {
        val result = repo.findById(id)
        if (result.isPresent)
            return ResponseEntity.ok(result.get())
        else
            return ResponseEntity.notFound().build<Any>()
    }

    @GetMapping("lastname")
    fun findByLastName(@RequestParam("name") name: String) : ResponseEntity<*>{
        println(name)

        val findByLastName = repo.findByLastNameContainingIgnoreCase(name)
        println(findByLastName)
        return ResponseEntity.ok(findByLastName)
    }
    @GetMapping
    fun list(): MutableIterable<Person> {
        return repo.findAll();
    }

    @PostMapping
    internal fun add(@RequestBody person: Person): ResponseEntity<*> {
        println(person)
        val save = repo.save(person)
        val location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(save.id).toUri()

        return ResponseEntity.created(location).build<Any>()
    }

}