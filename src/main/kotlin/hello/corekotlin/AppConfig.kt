package hello.corekotlin

import hello.corekotlin.discount.DiscountPolicy
import hello.corekotlin.discount.RateDiscountPolicy
import hello.corekotlin.member.MemberRepository
import hello.corekotlin.member.MemberService
import hello.corekotlin.member.MemberServiceImpl
import hello.corekotlin.member.MemoryMemberRepository
import hello.corekotlin.order.MemoryOrderRepository
import hello.corekotlin.order.OrderRepository
import hello.corekotlin.order.OrderService
import hello.corekotlin.order.OrderServiceImpl
import hello.corekotlin.product.ProductRepository
import hello.corekotlin.product.ProductService
import hello.corekotlin.product.ProductServiceImpl

class AppConfig {
    private fun memberRepository(): MemberRepository = MemoryMemberRepository()
    private fun orderRepository() : OrderRepository = MemoryOrderRepository()
    private fun productRepository() : ProductRepository = ProductRepository()
    private fun discountPolicy(): DiscountPolicy = RateDiscountPolicy()

    fun memberService() : MemberService = MemberServiceImpl(memberRepository())
    fun orderService(): OrderService = OrderServiceImpl(memberRepository(), orderRepository(), productRepository(), discountPolicy())
    fun productService(): ProductService = ProductServiceImpl(productRepository())
}