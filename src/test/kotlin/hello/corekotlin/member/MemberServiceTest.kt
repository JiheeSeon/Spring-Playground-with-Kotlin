package hello.corekotlin.member

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MemberServiceTest {
    companion object{
        var memberService = MemberServiceImpl();
    }

    @Test
    fun join(){
        // given
        val newMember = Member(1L, "Kotlin-Member-A", Grade.VIP);

        // when
        memberService.join(newMember);
        val foundMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(newMember).isEqualTo(foundMember);
    }
}