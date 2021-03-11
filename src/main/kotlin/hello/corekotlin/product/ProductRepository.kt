package hello.corekotlin.product

class ProductRepository {
    companion object{
        var store = HashMap<Long, Product>()
    }
    fun save(product: Product){
        store[product.id] = product
    }
    fun findById(id: Long) = store[id]
}