package hello.corekotlin.discount

import hello.corekotlin.member.Grade

interface DiscountPolicy {
    fun discount(price: Int, grade: Grade): Int
}