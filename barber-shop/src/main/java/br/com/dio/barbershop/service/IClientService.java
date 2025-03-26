package br.com.dio.barbershop.service;

import br.com.dio.barbershop.entity.ClientEntity;

public interface IClientService {
    
    ClientEntity save(final ClientEntity entity);

    ClientEntity update(final ClientEntity entity);

    void delete(final long id);
}
