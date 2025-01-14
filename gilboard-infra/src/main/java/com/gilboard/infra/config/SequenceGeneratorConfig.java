package com.gilboard.infra.config;

import com.gilboard.infra.persistence.sequence.JdbcMachineSequenceAllocator;
import com.gilboard.infra.persistence.sequence.MachineSequenceAllocator;
import com.gilboard.infra.persistence.sequence.SequenceGenerator;
import com.gilboard.infra.persistence.sequence.SequenceGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class SequenceGeneratorConfig {

    private static final int MACHINE_SEQUENCE_BIT_SIZE = 7;

    @Bean
    public MachineSequenceAllocator machineSequenceAllocator(
            JdbcTemplate jdbcTemplate,
            PlatformTransactionManager transactionManager
    ) {
        return new JdbcMachineSequenceAllocator(
                MACHINE_SEQUENCE_BIT_SIZE,
                jdbcTemplate,
                transactionManager
        );
    }

    @Bean
    public SequenceGenerator sequenceGenerator(MachineSequenceAllocator allocator) {
        int machineSequence = allocator.allocate();

        return new SequenceGeneratorImpl(machineSequence, MACHINE_SEQUENCE_BIT_SIZE);
    }
}

