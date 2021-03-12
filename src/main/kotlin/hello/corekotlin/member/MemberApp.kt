package hello.corekotlin.member

import hello.corekotlin.AppConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class MemberApp
fun main(args: Array<String>){
    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService : MemberService = applicationContext.getBean("memberService") as MemberService
    val newMember = Member(1L, "Kotlin-Member-A", Grade.VIP)
    memberService.join(newMember)

    val foundMember = memberService.findMember(1L)
    println("newMember = ${newMember.name}")
    println("foundMember = ${foundMember?.name}")

}