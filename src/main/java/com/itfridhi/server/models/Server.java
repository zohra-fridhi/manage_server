package com.itfridhi.server.models;

import com.itfridhi.server.emum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Server {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "this field can not be empty")
    private String ipAdress;
    private String urlImage;
    private String name;
    private String memory;
    private String type;
    private Status status;
}
