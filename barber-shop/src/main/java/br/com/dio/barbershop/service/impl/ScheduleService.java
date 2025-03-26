package br.com.dio.barbershop.service.impl;

import org.springframework.stereotype.Service;

import br.com.dio.barbershop.entity.ScheduleEntity;
import br.com.dio.barbershop.repository.IScheduleRepository;
import br.com.dio.barbershop.service.IScheduleService;
import br.com.dio.barbershop.service.query.IScheduleQueryService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleService implements IScheduleService{
    
    private final IScheduleRepository repository;
    private final IScheduleQueryService queryService;

    @Override
    public ScheduleEntity save(final ScheduleEntity entity) {
        queryService.verifyScheduleExists(entity.getStartAt(), entity.getEndAt());

        return repository.save(entity);
    }

    @Override
    public void delete(long id) {
        queryService.findById(id);
        repository.deleteById(id);
    }
    
}
