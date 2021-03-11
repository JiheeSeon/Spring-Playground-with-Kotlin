package hello.corekotlin.order

import hello.corekotlin.discount.RateDiscountPolicy
import hello.corekotlin.member.Grade
import hello.corekotlin.member.Member
import hello.corekotlin.member.MemberServiceImpl
import hello.corekotlin.member.MemoryMemberRepository
import hello.corekotlin.product.Department
import hello.corekotlin.product.Product
import hello.corekotlin.product.ProductRepository
import hello.corekotlin.product.ProductServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class OrderServiceTest {
    companion object {
        val memberRepository = MemoryMemberRepository()
        val orderRepository = MemoryOrderRepository()
        val productRepository = ProductRepository()

        //policy
        val discountPolicy = RateDiscountPolicy()

        //service
        val memberServiceImpl = MemberServiceImpl(memberRepository)
        val productServiceImpl = ProductServiceImpl(productRepository)
        val orderServiceImpl = OrderServiceImpl(memberRepository, orderRepository, productRepository, discountPolicy)
    }

    @BeforeEach
    fun beforeEach() {
        val membersToJoin: Array<Member> = arrayOf(
            Member(1L, "Kotlin-lover", Grade.VIP),
            Member(2L, "Sleeper", Grade.BASIC),
            Member(30L, "Seon", Grade.VIP)
        )

        for (member in membersToJoin)
            memberServiceImpl.join(member)

        val productsToRegister: Array<Product> = arrayOf(
            Product(11L, "Monalisa", Department.ARTS_CRAFTS, 10000000),
            Product(22L, "IMAC-PRO-Latest ed", Department.COMPUTERS, 1111111),
            Product(33L, "Gucci bag", Department.FASHION, 202020),
            Product(44L, "M1", Department.COMPUTERS, 2000000),
            Product(55L, "Smart light", Department.SMART_HOME, 50000)
        )

        for (product in productsToRegister)
            productServiceImpl.register(product)
    }

    @Test
    fun order() {
        assertThat(orderServiceImpl.createOrder(2L, 55L, 3).totalPrice).isEqualTo(150000)
        assertThat(orderServiceImpl.createOrder(1L, 22L, 2).totalPrice).isEqualTo(1999998)
        assertThat(orderServiceImpl.createOrder(1L, 11L, 1).totalPrice).isEqualTo(9000000)
        assertThat(orderServiceImpl.createOrder(30L, 44L, 2).totalPrice).isEqualTo(3600000)
    }
}