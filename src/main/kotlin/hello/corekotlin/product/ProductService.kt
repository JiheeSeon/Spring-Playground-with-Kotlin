package hello.corekotlin.product

interface ProductService {
    fun register(product: Product)
    fun findProduct(id: Long): Product?
}