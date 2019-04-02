package br.edu.uniopet.trabalhoimobiliaria;

import br.edu.uniopet.trabalhoimobiliaria.domain.*;
import br.edu.uniopet.trabalhoimobiliaria.repository.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

@SpringBootApplication
public class TrabalhoImobiliariaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoImobiliariaApplication.class, args);
    }

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    ImoveisRepository imoveisRepository;

    @Autowired
    ImobiliariaRepository imobiliariaRepository;

    @Override
    public void run(String... args) throws Exception {

        Gson gson = new Gson();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/imobiliaria.json"));

        Type type = new TypeToken<List<DadosImobiliaria>>() {


        }.getType();

        List<DadosImobiliaria> list = gson.fromJson(bufferedReader, type);

        System.out.println(list);

        Estado estado = new Estado();

        Cidade cidade = new Cidade();

        Imoveis imoveis = new Imoveis();

        Imobiliaria imobiliaria = new Imobiliaria();


        Localizacao localizacao = new Localizacao();

        for (DadosImobiliaria dadosImobiliaria : list) {

            if (dadosImobiliaria.getUf() != null) {

                Estado estadoAux = estadoRepository.findAllByNomeEstado(dadosImobiliaria.getUf());

                if (estadoAux == null) {
                    estado.setNomeEstado(dadosImobiliaria.getUf());
                    estadoRepository.save(estado);

                }

            }

            if (dadosImobiliaria.getCidade() != null) {
                Cidade cidadeAux = cidadeRepository.findAllByNome(dadosImobiliaria.getCidade());

                if (cidadeAux == null) {
                    Estado estadoAux = estadoRepository.findAllByNomeEstado(dadosImobiliaria.getUf());

                    cidade.setNome(dadosImobiliaria.getCidade());
                    cidade.setEstado(estadoAux);
                    cidadeRepository.save(cidade);

                }
            }

            if (dadosImobiliaria.getCep() != null || dadosImobiliaria.getBairro() != null) {

                Cidade cidadeAux = cidadeRepository.findAllByNome(dadosImobiliaria.getCidade());
                localizacao.setBairro(dadosImobiliaria.getBairro());
                localizacao.setCep(dadosImobiliaria.getCep());
                localizacao.setCidade(cidadeAux);
                localizacaoRepository.save(localizacao);
            }


            if (dadosImobiliaria.getCategoria() != null || dadosImobiliaria.getVagas() != null) {

                imoveis.setTipoImovel(dadosImobiliaria.getCategoria());
                imoveis.setVagasGaragem(dadosImobiliaria.getVagas());
                imoveisRepository.save(imoveis);
            }

            imobiliaria.setImoveis(imoveis);
            imobiliaria.setLocalizacao(localizacao);
            imobiliariaRepository.save(imobiliaria);

            cidade = new Cidade();
            estado = new Estado();
            localizacao = new Localizacao();
            imoveis = new Imoveis();
            imobiliaria = new Imobiliaria();
        }


    }
}
