package hello.corekotlin.member

import hello.corekotlin.AppConfig
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MemberServiceTest {
    companion object{
        val appConfig = AppConfig()
        var memberService = appConfig.memberService()
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