package org.motechproject.tama.migration.fact;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "clinic_contact")
@Data
public class ClinicContactFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private String phone;

    public ClinicContactFact() {
    }

    public ClinicContactFact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
