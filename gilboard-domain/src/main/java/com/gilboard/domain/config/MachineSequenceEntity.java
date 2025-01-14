package com.gilboard.domain.config;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "machine_sequence")
public class MachineSequenceEntity {

    @Id
    Integer sequence;
}
