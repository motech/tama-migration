package org.motechproject.tama.migration.fact;

import lombok.Data;
import org.motechproject.tama.facility.domain.Clinic;

import javax.persistence.*;

@Entity
@Table(name = "clinic")
@Data
public class ClinicFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "city_id")
    private String cityId;

    private String name;

    private String phone;

    public ClinicFact() {
    }

    public ClinicFact(Clinic clinic) {
        address = clinic.getAddress();
        cityId = clinic.getCityId();
        name = clinic.getName();
        phone = clinic.getPhone();
    }
}
