package hello.corekotlin.discount

import hello.corekotlin.member.Grade
import hello.corekotlin.member.Member

class FixDiscountPolicy: DiscountPolicy{
    private val vipDiscountPrice = 1000

    override fun calculateDiscountPrice(member: Member?): Int {
        return if (member?.grade == Grade.VIP) vipDiscountPrice
        else 0
    }
}