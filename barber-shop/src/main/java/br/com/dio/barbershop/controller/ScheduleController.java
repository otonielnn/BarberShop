package br.com.dio.barbershop.controller;

import java.time.YearMonth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.barbershop.controller.request.SaveScheduleRequest;
import br.com.dio.barbershop.controller.response.SaveScheduleResponse;
import br.com.dio.barbershop.controller.response.ScheduleAppointmentMonthResponse;
import br.com.dio.barbershop.mapper.IScheduleMapper;
import br.com.dio.barbershop.service.IScheduleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import static java.time.ZoneOffset.UTC;

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

    @GetMapping("{year}/{month}")
    ScheduleAppointmentMonthResponse listMonth(@PathVariable final int year, @PathVariable final int month) {
        var yearMonth = YearMonth.of(year, month);
        var startAt = yearMonth.atDay(1).atTime(0, 0, 0, 0).atOffset(UTC);
        var endAt = yearMonth.atEndOfMonth().atTime(23, 59, 59, 999_999_999).atOffset(UTC);
        var entities = queryService.findInMonth(startAt, endAt);
        return mapper.toMonthResponse(year, month, entities);
    }
}
