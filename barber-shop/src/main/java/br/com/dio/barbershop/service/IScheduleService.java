package br.com.dio.barbershop.service;

import java.time.OffsetDateTime;

import br.com.dio.barbershop.entity.ScheduleEntity;

public interface IScheduleService {
    
    ScheduleEntity save(final ScheduleEntity entity);

    void delete(final long id);

    Object findInMonth(OffsetDateTime startAt, OffsetDateTime endAt);
}
