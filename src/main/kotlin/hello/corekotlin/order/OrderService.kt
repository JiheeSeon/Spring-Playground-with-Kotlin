package hello.corekotlin.order

interface OrderService {
    fun createOrder(memberId: Long, productId: Long, amount: Int): Order
}