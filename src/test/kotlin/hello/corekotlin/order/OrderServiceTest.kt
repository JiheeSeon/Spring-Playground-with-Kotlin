package hello.corekotlin.order

import hello.corekotlin.member.Grade
import hello.corekotlin.member.Member
import hello.corekotlin.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OrderServiceTest {
    val memberServiceImpl = MemberServiceImpl();
    val orderServiceImpl = OrderServiceImpl()

    @Test
    fun order(){
        memberServiceImpl.join(Member(1L, "Kotlin-Member-A", Grade.VIP))
        val order = orderServiceImpl.createOrder(1L, "item-A", 10000)

        Assertions.assertThat(order.discountPrice).isEqualTo(1000)
    }
}