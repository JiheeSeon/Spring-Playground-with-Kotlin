package hello.corekotlin.order

interface OrderService {
    fun createOrder(memberId: Long, name: String, price: Int): Order
}