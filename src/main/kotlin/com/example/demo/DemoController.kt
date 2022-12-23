package com.example.demo

import jakarta.persistence.EntityManager
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(val em: EntityManager) {

    @GetMapping("/users")
    fun getUsers(): List<User> {

        val cb = em.criteriaBuilder
        val q = cb.createQuery(User::class.java)

        // Criteria variant
        SeniorLadySpecification.apply(cb, q, q.from(User::class.java))

        val users =  em.createQuery(q).resultList

        // POJO variant
        users.forEach {
            assert(SeniorLadySpecification.isSatisfiedBy(it))
        }

        return users
    }
}
