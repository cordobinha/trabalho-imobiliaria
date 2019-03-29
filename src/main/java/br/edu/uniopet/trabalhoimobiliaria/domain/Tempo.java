package br.edu.uniopet.trabalhoimobiliaria.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Tempo implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date ano;

    private String semana;

    private String feriado;

    private String semanaMes;

    private String mes;

    @OneToMany(mappedBy = "tempo")
    private List <Imobiliaria> imobiliarias=new ArrayList<>();


}
