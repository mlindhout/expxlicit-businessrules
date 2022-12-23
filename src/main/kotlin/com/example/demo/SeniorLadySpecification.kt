package com.example.demo

import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Expression
import jakarta.persistence.criteria.Root
import java.time.LocalDate
import java.time.Period

/**
 * Specification pattern (https://en.wikipedia.org/wiki/Specification_pattern).
 * Multiple methods can be provided, for simple POJO testing, or (for example)
 * for adding criteria to where clauses.
 */
class SeniorLadySpecification {

    companion object {
        val SENIOR_AGE = 60

        fun isSatisfiedBy(user: User): Boolean {
            return user.gender == Gender.female && Period.between(user.dateOfBirth, LocalDate.now()).years >= SENIOR_AGE
        }

        fun apply(cb: CriteriaBuilder, q: CriteriaQuery<out Any>, from: Root<User>) {
            val gender = from.get<Gender>("gender")
            val dob: Expression<LocalDate> = from.get("dateOfBirth")
            val age = cb.diff(
                cb.function("year", Integer::class.java, cb.currentDate()),
                cb.function("year", Integer::class.java, dob)
            )
            q.where(
                cb.and(
                    cb.equal(gender, Gender.female),
                    cb.ge(age, SENIOR_AGE)
                )
            )
        }
    }
}



