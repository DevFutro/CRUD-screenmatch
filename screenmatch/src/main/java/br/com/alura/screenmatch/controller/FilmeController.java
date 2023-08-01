package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosAlteracaoFilme;
import br.com.alura.screenmatch.domain.filme.DadosCadastroFilmes;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model) {

        if(id != null) {
           var filme = repository.getReferenceById(id);
           model.addAttribute("filme", filme);
        }

        return "filmes/formulario";
    }

    @GetMapping
    public String carregaListaFilmes(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraFilme(DadosCadastroFilmes dadosFilme) {
        var filme = new Filme(dadosFilme);
        repository.save(filme);

        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String editaFilmes(DadosAlteracaoFilme dados) {
        var filme = repository.getReferenceById(dados.id());
        filme.atualizaDados(dados);

        return "redirect:/filmes";
    }

    @DeleteMapping
    @Transactional
    public String excluiFilmes(Long id) {
        repository.deleteById(id);

        return "redirect:/filmes";

    }


}
