package hello.corekotlin.member

class MemberServiceImpl(var memberRepository: MemberRepository): MemberService {
    override fun join(member: Member) {
        memberRepository.save(member)
    }

    override fun findMember(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }

}