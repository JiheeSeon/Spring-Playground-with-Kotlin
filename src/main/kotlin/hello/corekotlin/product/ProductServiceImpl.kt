package hello.corekotlin.product

class ProductServiceImpl(var productRepository: ProductRepository) : ProductService {
    override fun register(product: Product) {
        productRepository.save(product)
    }

    override fun findProduct(id: Long): Product? = productRepository.findById(id)
}