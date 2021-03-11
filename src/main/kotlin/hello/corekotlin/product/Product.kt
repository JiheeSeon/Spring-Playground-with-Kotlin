package hello.corekotlin.product

data class Product(var id: Long, var name: String, var department: Department, var price: Int){
    override fun toString() = "[Item] id = $id, name = $name, department = $department original price = $price"
}
