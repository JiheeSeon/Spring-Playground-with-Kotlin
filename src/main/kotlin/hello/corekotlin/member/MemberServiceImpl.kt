package hello.corekotlin.member

class MemberServiceImpl: MemberService {
    var memberRepository = MemoryMemberRepository()
    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }

}