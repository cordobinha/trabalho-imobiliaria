package br.edu.uniopet.trabalhoimobiliaria.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String faixaEtaria;

    private String genero;

    private String faixaRenda;

    private String escolaridade;


    @OneToMany(mappedBy = "cliente")
    private List<Imobiliaria> imobiliarias=new ArrayList<>();
}
