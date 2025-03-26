package br.com.dio.barbershop.service.query.impl;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.dio.barbershop.entity.ScheduleEntity;
import br.com.dio.barbershop.exception.NotFoundException;
import br.com.dio.barbershop.exception.ScheduleInUseException;
import br.com.dio.barbershop.repository.IScheduleRepository;
import br.com.dio.barbershop.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ScheduleQueryService implements IScheduleQueryService{

    private final IScheduleRepository repository;

    @Override
    public ScheduleEntity findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Agendamento não encontrado"));
    }

    @Override
    public List<ScheduleEntity> findInMonth(OffsetDateTime startAt, OffsetDateTime endAt) {
        return repository.findByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByStartAtEndAt(startAt, endAt);
    }

    @Override
    public void verifyScheduleExists(OffsetDateTime startAt, OffsetDateTime endAt) {
        if (repository.existsByStartAtAndEndAt(startAt, endAt)) {
            var message = "Já existe um cliente agendado no horário solicitado";
            throw new ScheduleInUseException(message);
        }
    }
    
}
