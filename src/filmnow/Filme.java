package filmnow;
import java.util.*;

/**
 * Representação de um Filme. Todo filme precisa ter um nome, o ano de
 * lançamento, e o local onde assistir, além da indicação de se é hot
 * ou não. Cada Filme é identificado unicamente pelo nome e ano de lançamento
 *
 * @author ana.luisa.lopes.carneiro.de.aragao.monteiro
 */
public class Filme {

    private String nome;

    private String anoDeLancamento;

    private String ondeAssistir;

    private boolean hot;

    /**
     * Construtor da classe. Constrói um filme a partir do seu nome,
     * ano de lançamento e onde assistir.
     * Todo filme começa com o atributo hot como false.
     *
     * @param nome
     * @param anoDeLancamento
     * @param ondeAssistir
     */
    public Filme(String nome, String anoDeLancamento, String ondeAssistir) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.ondeAssistir = ondeAssistir;
    }

    /**
     * Define o valor booleano do atributo hot.
     *
     * @param valor
     */
    public void setHot(boolean valor) {
        this.hot = valor;
    }

    /**
     * Verifica se o atributo hot é verdadeiro.
     *
     * @return se hot é true ou false
     */
    public boolean isHot() {
        return this.hot;
    }

    /**
     * Muda o atributo do local onde o filme pode ser assistido.
     *
     * @param local
     */
    public void setOndeAssistir(String local) {
        this.ondeAssistir = ondeAssistir;
    }

    /**
     * Pega a String do atributo nome do objeto filme.
     *
     * @return nome do filme
     */
    public String getNome() {
        return nome;
    }

    /**
     * Pega a String do atributo ano de lancamento do objeto filme.
     *
     * @return ano de lancamento
     */
    public String getAnoDeLancamento() {
        return anoDeLancamento;
    }

    /**
     * Retorna a String que representa o filme. A representação segue
     * o formato:
     *  "(simbolo que representa se o filme é hot) nome, ano, onde assistir
     *
     * @return a representação em String de um filme
     */
    @Override
    public String toString() {
        String fogo = "";
        if (isHot()){
            fogo = "\uD83D\uDD25";
        }
        return fogo + " " +this.nome + ", " + anoDeLancamento + ", " + ondeAssistir;
    }

    /**
     * Este método compara a igualdade entre o filme atual e outro
     * objeto, usando para checagem os identificadores únicos de filme,
     * nome e ano de lancamento.
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){
        if (o == null){
            return false;
        }

        if (o instanceof Filme){
            Filme oObject = (Filme) (o);
            if ((oObject.getNome().equals(this.nome)) &&(oObject.getAnoDeLancamento().equals(this.anoDeLancamento))){
                return true;
            }

        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nome, this.anoDeLancamento);
    }


}