package br.edu.uniopet.trabalhoimobiliaria.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Estado implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeEstado;

    private String nomeRegiao;


     @OneToMany(mappedBy = "estado")
     private List<Cidade> cidades=new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;



}
