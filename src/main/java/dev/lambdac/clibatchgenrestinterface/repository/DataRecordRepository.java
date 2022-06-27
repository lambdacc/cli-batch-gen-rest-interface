package dev.lambdac.clibatchgenrestinterface.repository;

import dev.lambdac.clibatchgenrestinterface.model.DataRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRecordRepository extends JpaRepository<DataRecordEntity, Long> {
}
