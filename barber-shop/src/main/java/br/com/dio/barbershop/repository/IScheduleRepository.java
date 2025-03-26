package br.com.dio.barbershop.repository;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.barbershop.entity.ScheduleEntity;

@Repository
public interface IScheduleRepository extends JpaRepository<ScheduleEntity, Long>{
    
    List<ScheduleEntity> findByStartAtGreaterThanEqualAndEndAtLessThenEqualOrderByStartAtEndAt(final OffsetDateTime startAt,
    final OffsetDateTime endAt
    );

    boolean existsByStartAtAndEndAt(final OffsetDateTime startAt, final OffsetDateTime endAt);
}
