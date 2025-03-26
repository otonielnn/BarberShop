package br.com.dio.barbershop.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
    name = "CLIENTS",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_EMAIL", columnNames = "email"),
        @UniqueConstraint(name = "UK_PHONE", columnNames = "phone")
    }
)
@Getter
@Setter
@ToString
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 11, columnDefinition = "bpchar(11)")
    private String phone;

    @ToString.Exclude
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ScheduleEntity> schedules = new HashSet<>();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    
}
