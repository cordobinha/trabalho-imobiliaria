package br.edu.uniopet.trabalhoimobiliaria.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Imoveis implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoImovel;

    private String valorTotalImovel;

    private String tamanho;

    private String novo;

    private String usado;

    private String vagasGaragem;

    private String numerosDormitorios;


    @OneToMany(mappedBy = "imoveis")
    private List<Imobiliaria> imobiliarias = new ArrayList<>();


}
