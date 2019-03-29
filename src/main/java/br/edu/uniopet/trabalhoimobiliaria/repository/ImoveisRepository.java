package br.edu.uniopet.trabalhoimobiliaria.repository;

import br.edu.uniopet.trabalhoimobiliaria.domain.Cidade;
import br.edu.uniopet.trabalhoimobiliaria.domain.Imoveis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImoveisRepository extends JpaRepository <Imoveis,Integer> {

    //Imoveis findAllByNome(String s);
}
