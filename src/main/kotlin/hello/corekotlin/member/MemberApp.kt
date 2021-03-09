package hello.corekotlin.member

class MemberApp
fun main(args: Array<String>){
    val memberService = MemberServiceImpl()
    val newMember = Member(1L, "Kotlin-Member-A", Grade.VIP)
    memberService.join(newMember)

    val foundMember = memberService.findMember(1L)
    println("newMember = ${newMember.name}")
    println("foundMember = ${foundMember?.name}")

}