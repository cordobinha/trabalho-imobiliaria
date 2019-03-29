package br.edu.uniopet.trabalhoimobiliaria.repository;

import br.edu.uniopet.trabalhoimobiliaria.domain.Estado;
import br.edu.uniopet.trabalhoimobiliaria.domain.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends JpaRepository <Localizacao,Integer> {


}
