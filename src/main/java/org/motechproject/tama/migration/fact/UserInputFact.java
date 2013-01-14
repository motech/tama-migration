package org.motechproject.tama.migration.fact;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_input_event")
@Data
public class UserInputFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "call_id")
    private String callId;

    @Column(name = "request")
    private String request;

    @Column(name = "user_input")
    private String userInput;

    @Column(name = "response")
    private String response;

    @Column(name = "occurred_at")
    private Date occurredAt;
}
