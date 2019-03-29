package br.edu.uniopet.trabalhoimobiliaria.repository;

import br.edu.uniopet.trabalhoimobiliaria.domain.Cidade;
import br.edu.uniopet.trabalhoimobiliaria.domain.Imobiliaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImobiliariaRepository extends JpaRepository <Imobiliaria,Integer> {

    //Imobiliaria findAllByNome(String s);
}
