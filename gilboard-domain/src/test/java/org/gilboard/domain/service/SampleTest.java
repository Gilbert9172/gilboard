package org.gilboard.domain.service;

import com.gilboard.domain.model.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class SampleTest {

    @Test
    @DisplayName("sample test")
    public void test() throws Exception {
        Member member = Member.newOne("gilbert");
        assertThat(member.name).isEqualTo("gilbert");
    }

}
