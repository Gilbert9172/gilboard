package com.gilboard.infra.persistence.sequence;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

@RequiredArgsConstructor
public class JdbcMachineSequenceAllocator implements MachineSequenceAllocator {

    private final int machineSequenceBitSize;
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;

    public JdbcMachineSequenceAllocator(int machineSequenceBitSize, JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
        this.machineSequenceBitSize = machineSequenceBitSize;
        this.jdbcTemplate = jdbcTemplate;
        this.transactionTemplate = new TransactionTemplate(transactionManager);
        this.transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        this.transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    }

    @Override
    public Integer allocate() {
        return transactionTemplate.execute(transactionStatus -> {
            String update = "UPDATE machine_sequence SET sequence = sequence + 1";
            jdbcTemplate.update(update);

            String select = "SELECT sequence FROM machine_sequence";

            Integer nextId;

            try {
                nextId = jdbcTemplate.queryForObject(select, Integer.class);
            } catch (EmptyResultDataAccessException e) {
                jdbcTemplate.update("INSERT INTO machine_sequence VALUES (1)");

                nextId = 1;
            }

            int sequenceModular = (int) Math.pow(2, machineSequenceBitSize);

            if (nextId != null) {
                return nextId % sequenceModular;
            }
            throw new SequenceGeneratorTimestampException("Sequence Allocation Error");
        });
    }
}
