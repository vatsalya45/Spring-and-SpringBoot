package com.vatsalya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecordRepository extends JpaRepository<Record, Long> {
	List<Record> findByUserId(Long userId);

	List<Record> findByUserIdAndIsActive(Long userId, boolean isActive);

	List<Record> findByUserIdAndNameContainingIgnoreCase(Long userId, String name);

	List<Record> findByUserIdAndIsActiveAndNameContainingIgnoreCase(Long userId, boolean isActive, String name);

	@Modifying
	@Query("DELETE FROM Record r WHERE r.id IN :ids AND r.user.id = :userId")
	void deleteAllByIdInAndUserId(@Param("ids") List<Long> ids, @Param("userId") Long userId);
}
