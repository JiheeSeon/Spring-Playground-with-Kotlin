package hello.corekotlin.member

class MemoryMemberRepository: MemberRepository {
    companion object{
        var store = HashMap<Long, Member>();
    }

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long): Member? {
        return store[memberId]
    }

}