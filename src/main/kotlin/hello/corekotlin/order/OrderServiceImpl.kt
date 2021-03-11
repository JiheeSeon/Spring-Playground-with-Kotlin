package hello.corekotlin.order

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.member.Grade
import hello.corekotlin.member.MemoryMemberRepository
import hello.corekotlin.product.ProductRepository

class OrderServiceImpl(var memberRepository: MemoryMemberRepository, var orderRepository: OrderRepository, var productRepository: ProductRepository, var discountPolicy: DiscountPolicy): OrderService {
    override fun createOrder(memberId: Long, productId: Long, amount: Int): Order {
        val grade: Grade? = memberRepository.findById(memberId)?.grade
        val originalPrice = productRepository.findById(productId)?.price

        val totalPrice = amount * discountPolicy.discount(originalPrice!!, grade!!) //TODO change !!

        val order = Order(1234, memberId, amount, productId, totalPrice)
        orderRepository.save(order)

        return order
    }
}