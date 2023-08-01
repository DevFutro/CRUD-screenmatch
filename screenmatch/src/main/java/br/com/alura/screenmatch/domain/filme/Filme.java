package br.com.alura.screenmatch.domain.filme;

import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer anoLancamento;
    private Integer duracaoFilme;
    private String generoFilme;
    private String nomeFilme;

    public Filme(DadosCadastroFilmes dadosFilme) {
        this.nomeFilme = dadosFilme.nomeFilme();
        this.duracaoFilme = dadosFilme.duracaoFilme();
        this.anoLancamento = dadosFilme.anoLancamento();
        this.generoFilme = dadosFilme.generoFilme();
    }

    public Filme() {
    }

    @Override
    public String toString() {
        return "Filme{" +
                "anoLancamento=" + anoLancamento +
                ", duracaoFilme=" + duracaoFilme +
                ", generoFilme='" + generoFilme + '\'' +
                ", nomeFilme='" + nomeFilme + '\'' +
                '}';
    }
    public Long getId() {
        return id;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public Integer getDuracaoFilme() {
        return duracaoFilme;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }


    public void atualizaDados(DadosAlteracaoFilme dados) {
        this.nomeFilme = dados.nomeFilme();
        this.duracaoFilme = dados.duracaoFilme();
        this.anoLancamento = dados.anoLancamento();;
        this.generoFilme = dados.generoFilme();
    }
}
