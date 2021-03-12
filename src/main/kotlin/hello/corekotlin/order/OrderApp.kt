package hello.corekotlin.order

import hello.corekotlin.AppConfig
import hello.corekotlin.member.Grade
import hello.corekotlin.member.Member
import hello.corekotlin.product.Department
import hello.corekotlin.product.Product

class OrderApp

fun main(args: Array<String>) {
    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()
    val productService = appConfig.productService()


    val membersToJoin: Array<Member> = arrayOf(
        Member(1L, "Kotlin-lover", Grade.VIP),
        Member(2L, "Sleeper", Grade.BASIC),
        Member(30L, "Seon", Grade.VIP)
    )

    for (member in membersToJoin)
        memberService.join(member)

    val productsToRegister: Array<Product> = arrayOf(
        Product(11L, "Monalisa", Department.ARTS_CRAFTS, 10000000),
        Product(22L, "IMAC-PRO-Latest ed", Department.COMPUTERS, 1111111),
        Product(33L, "Gucci bag", Department.FASHION, 202020),
        Product(44L, "M1", Department.COMPUTERS, 2000000),
        Product(55L, "Smart light", Department.SMART_HOME, 50000)
    )

    for (product in productsToRegister)
        productService.register(product)

    println(orderService.createOrder(2L, 55L, 3)) // 150000
    println(orderService.createOrder(1L, 22L, 2)) // 2222222 * 0.9
    println(orderService.createOrder(1L, 11L, 1)) // 10000000 * 0.9
    println(orderService.createOrder(30L, 44L, 2)) // 4000000 * 0.9
}