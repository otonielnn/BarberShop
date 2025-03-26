package br.com.dio.barbershop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(
    name = "SCHEDULES",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_SCHEDULE_INTERVAL", columnNames = {"start_at", "end_at"}),
    }
)
@Getter
@Setter
@ToString
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name = "start_at")
    private String startAt;

    @Column(nullable = false, name = "end_at")
    private String endAt;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity client = new ClientEntity();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    
}


