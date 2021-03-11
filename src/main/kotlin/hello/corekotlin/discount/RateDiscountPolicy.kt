package hello.corekotlin.discount

import hello.corekotlin.member.Grade

class RateDiscountPolicy: DiscountPolicy {
    companion object{
        const val discountRate = 10;
    }
    override fun discount(price: Int, grade: Grade): Int = if (grade == Grade.VIP) price * (100 - discountRate) / 100 else price
}