package com.shiva.finsight.repository;

import com.shiva.finsight.entity.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRecordRepository extends JpaRepository<TransactionRecord,Long> {
}
