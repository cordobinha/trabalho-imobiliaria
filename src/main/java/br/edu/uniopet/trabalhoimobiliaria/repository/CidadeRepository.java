package br.edu.uniopet.trabalhoimobiliaria.repository;

import br.edu.uniopet.trabalhoimobiliaria.domain.Cidade;
import br.edu.uniopet.trabalhoimobiliaria.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository <Cidade,Integer> {

    Cidade findAllByNome(String s);
}
