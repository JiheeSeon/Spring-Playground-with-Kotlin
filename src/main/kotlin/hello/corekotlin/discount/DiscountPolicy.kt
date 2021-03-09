package hello.corekotlin.discount

import hello.corekotlin.member.Member

interface DiscountPolicy {
    fun calculateDiscountPrice(member: Member?): Int
}