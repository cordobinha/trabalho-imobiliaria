package br.edu.uniopet.trabalhoimobiliaria.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Pais  implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Estado estado;


    @OneToMany(mappedBy = "pais")
    private List<Estado> estados=new ArrayList<>();


}
