package br.com.dio.barbershop.service.query;

import java.time.OffsetDateTime;
import java.util.List;

import br.com.dio.barbershop.entity.ScheduleEntity;

public interface IScheduleQueryService {
    
    ScheduleEntity findById(final Long id);

    List<ScheduleEntity> findInMonth(final OffsetDateTime startAt, final OffsetDateTime endAt);

    void verifyScheduleExists(final OffsetDateTime startAt, final OffsetDateTime endAt);
}
