package br.com.dio.barbershop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.dio.barbershop.controller.request.SaveClientRequest;
import br.com.dio.barbershop.controller.request.UpdateClientRequest;
import br.com.dio.barbershop.controller.response.ClientDetailResponse;
import br.com.dio.barbershop.controller.response.ListClientResponse;
import br.com.dio.barbershop.controller.response.SaveClientResponse;
import br.com.dio.barbershop.controller.response.UpdateClientResponse;
import br.com.dio.barbershop.entity.ClientEntity;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

@Mapper(componentModel = SPRING)
public interface IClientMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    ClientEntity toEntity(final SaveClientRequest request);

    SaveClientResponse toSaveResponse(final ClientEntity entity);

    @Mapping(target = "schedule", ignore = true)
    ClientEntity toEntity(final long id, final UpdateClientRequest request);

    UpdateClientResponse toUpdateResponse(final ClientEntity entity);

    ClientDetailResponse toDetailResponse(final ClientEntity entity);

    List<ListClientResponse> toListResponse(final List<ClientEntity> entities);
}
