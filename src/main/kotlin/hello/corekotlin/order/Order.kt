package hello.corekotlin.order

data class Order(var memberId: Long, var itemName: String, var itemPrice: Int, var discountPrice: Int) {
    override fun toString(): String {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}'
    }
}