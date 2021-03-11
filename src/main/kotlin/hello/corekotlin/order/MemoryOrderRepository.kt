package hello.corekotlin.order

class MemoryOrderRepository: OrderRepository {
    companion object{
        var store = HashMap<Long, Order>()
    }
    override fun save(order: Order) {
        store[order.orderId] = order
    }

    override fun findById(id: Long): Order? = store[id]
}