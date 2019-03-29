package br.edu.uniopet.trabalhoimobiliaria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Imobiliaria implements Serializable {




    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String quantidade;

    private String precoMedio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="tempo_id")
    private Tempo tempo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="localizacao_id")
    private Localizacao localizacao;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="imoveis_id")
    private Imoveis imoveis;


}


