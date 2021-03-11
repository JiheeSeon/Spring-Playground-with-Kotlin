package hello.corekotlin.discount

import hello.corekotlin.member.Grade

class FixedDiscountPolicy: DiscountPolicy {
    companion object{
        const val discountPrice = 1000
    }
    override fun discount(price: Int, grade: Grade): Int = if (grade == Grade.VIP) price - discountPrice else price
}