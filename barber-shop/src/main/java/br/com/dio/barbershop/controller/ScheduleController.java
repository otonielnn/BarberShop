package br.com.dio.barbershop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.barbershop.controller.request.SaveScheduleRequest;
import br.com.dio.barbershop.controller.response.SaveScheduleResponse;
import br.com.dio.barbershop.mapper.IScheduleMapper;
import br.com.dio.barbershop.service.IScheduleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("schedules")
@AllArgsConstructor
public class ScheduleController {
    
    private final IScheduleService service;
    private final IScheduleService queryService;
    private final IScheduleMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    SaveScheduleResponse save(@RequestBody @Valid SaveScheduleRequest request) {
        var entity = mapper.toEntity(request);
        service.save(entity);
        return mapper.toSaveResponse(entity);
    }
}
