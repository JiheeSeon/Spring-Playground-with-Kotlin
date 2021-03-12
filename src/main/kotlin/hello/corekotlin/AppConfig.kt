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
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {
    @Bean fun memberRepository(): MemberRepository = MemoryMemberRepository()
    @Bean fun orderRepository() : OrderRepository = MemoryOrderRepository()
    @Bean fun productRepository() : ProductRepository = ProductRepository()
    @Bean fun discountPolicy(): DiscountPolicy = RateDiscountPolicy()
    @Bean fun memberService() : MemberService = MemberServiceImpl(memberRepository())
    @Bean fun orderService(): OrderService = OrderServiceImpl(memberRepository(), orderRepository(), productRepository(), discountPolicy())
    @Bean fun productService(): ProductService = ProductServiceImpl(productRepository())
}