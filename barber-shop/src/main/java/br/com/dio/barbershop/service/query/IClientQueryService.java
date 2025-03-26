package br.com.dio.barbershop.service.query;

import java.util.List;

import br.com.dio.barbershop.entity.ClientEntity;

public interface IClientQueryService {
    
    ClientEntity findById(final long id);

    List<ClientEntity> list();

    void VerifyPhone(final String phone);

    void VerifyPhone(final long id, final String phone);

    void VerifyEmail(final String email);

    void VerifyEmail(final long id, final String email);
}
