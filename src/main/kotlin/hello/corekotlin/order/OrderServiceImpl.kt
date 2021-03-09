package hello.corekotlin.order

import hello.corekotlin.discount.FixDiscountPolicy
import hello.corekotlin.member.MemberServiceImpl
import hello.corekotlin.member.MemoryMemberRepository

class OrderServiceImpl: OrderService {
    var memoryMemberRepository = MemoryMemberRepository()
    var discountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, price: Int): Order {
        val member = memoryMemberRepository.findById(memberId)
        val discountPrice = discountPolicy.calculateDiscountPrice(member)

        return Order(memberId, itemName, price, discountPrice)
    }
}