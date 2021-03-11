package hello.corekotlin.order

import hello.corekotlin.product.Product

interface OrderService {
    fun createOrder(memberId: Long, productId: Long, amount: Int): Order
}