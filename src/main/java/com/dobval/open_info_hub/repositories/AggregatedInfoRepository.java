package com.dobval.open_info_hub.repositories;

import com.dobval.open_info_hub.entities.AggregatedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //explicit statement for debugging
public interface AggregatedInfoRepository extends JpaRepository<AggregatedInfo, Long> {
    // Add custom query methods if needed
	// TODO: is a repository needed?
}
