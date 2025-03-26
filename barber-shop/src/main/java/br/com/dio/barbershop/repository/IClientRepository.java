package br.com.dio.barbershop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.barbershop.entity.ClientEntity;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {

    boolean existsByEmail(final String email);
    
    boolean existsByPhone(final String email);
    
    Optional<ClientEntity> FindByEmail(final String email);
    
    Optional<ClientEntity> FindByPhone(final String email);
}
