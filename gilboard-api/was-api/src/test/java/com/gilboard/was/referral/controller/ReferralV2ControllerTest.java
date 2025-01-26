package com.gilboard.was.referral.controller;

import com.gilboard.domain.member.model.MemberId;
import com.gilboard.domain.referral.model.Referral;
import com.gilboard.infra.persistence.repository.referral.ReferralRepository;
import com.gilboard.was.referral.service.ReferralService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ActiveProfiles(value = "test")
@SpringBootTest(properties = {"spring.config.import=classpath:application-dbsource.yml"})
public class ReferralV2ControllerTest {

    @Autowired
    ReferralRepository referralRepository;

    @Autowired
    ReferralService referralService;

    private void ticketingTest(Runnable runnable) throws InterruptedException {
        int CONCURRENT_COUNT = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(CONCURRENT_COUNT);

        for (int i = 0; i < CONCURRENT_COUNT; i++) {
            executorService.submit(() -> {
                try {
                    runnable.run();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        Referral referral = referralRepository.findByReferralCode("m5wdwdyr9247").orElseThrow();
        Assertions.assertThat(referral.getInviteeMemberCount()).isEqualTo(CONCURRENT_COUNT);
    }

    @Disabled
    @DisplayName("동시에 100명이 동일한 초대코드 입력")
    public void badTicketingTest() throws Exception {
        MemberId memberId = MemberId.from("780504865333376");
        ticketingTest(() -> referralService.enterReferralCodeV2(memberId, "m5wdwdyr9247"));
    }
}
