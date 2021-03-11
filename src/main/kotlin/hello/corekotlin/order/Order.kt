package hello.corekotlin.order

data class Order(var orderId: Long, var memberId: Long, var amount: Int, var productId: Long, var totalPrice:Int) {
    override fun toString() = "[Order] orderId=$orderId, memberId=$memberId, amount=$amount, productId=$productId, totalPrice=$totalPrice"
}