package br.com.dio.barbershop.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.dio.barbershop.controller.request.SaveScheduleRequest;
import br.com.dio.barbershop.controller.response.SaveScheduleResponse;
import br.com.dio.barbershop.entity.ScheduleEntity;

@Mapper(componentModel = SPRING)
public interface IScheduleMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client.id", source = "clientId")
    ScheduleEntity toEntity(final SaveScheduleRequest request);

    @Mapping(target =  "clientId", source = "client.id")
    SaveScheduleResponse toSaveResponse(final ScheduleEntity entity);
    
}
