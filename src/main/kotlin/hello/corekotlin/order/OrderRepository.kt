package hello.corekotlin.order

interface OrderRepository {
    fun save(order: Order)
    fun findById(id: Long): Order?
}