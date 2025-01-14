package org.gilboard.domain.member;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gilboard.domain.member.model.Member;
import com.gilboard.domain.member.model.MemberId;
import org.junit.jupiter.api.Test;

public class SerializeTest {

    @Test
    void objectMapperTest1() throws JsonProcessingException {
        // given
        Member member = Member.newOne(MemberId.newOne(1L), "gilbert");

        // when
        ObjectMapper objectMapper = new ObjectMapper();

        // then
        String string = objectMapper.writeValueAsString(member);

        // {"id":"3cf9887d-e5bd-41ab-8bfe-672b43b86ca5","name":"gilbert"}
        System.out.println(string);
    }

    @Test
    void objectMapperTest2() throws JsonProcessingException {
        // given
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = "{ \"id\":\"8a811c0d-b0b2-4ded-b13c-7af469878ea5\",\"name\":\"gilbert\"}";

        // when
        Member member = objectMapper.readValue(jsonData, Member.class);

        // then : id :8a811c0d-b0b2-4ded-b13c-7af469878ea5&name :gilbert
        System.out.println(member.toString());
    }

    @Test
    void objectMapperTest3() throws JsonProcessingException {
        // given
        Member member = Member.newOne(MemberId.newOne(1L), "gilbert");

        // when
        ObjectMapper objectMapper = new ObjectMapper();

        // then
        String string = objectMapper.writeValueAsString(member);

        // {"id":"3cf9887d-e5bd-41ab-8bfe-672b43b86ca5","name":"gilbert"}
        System.out.println(string);
    }
}
