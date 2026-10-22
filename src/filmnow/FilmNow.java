package filmnow;
import java.util.*;

/**
 * A classe FilmNow organiza os filmes em um array do objeto Filme e em uma hot list, com os filmes que se quer assistir
 * com mais urgência, que caso ja estiverem sidos adicionados, podem ser marcados como hot. É possível listar os filmes,
 * tanto hot como normais, e detalhar-los.
 *
 * @author ana.luisa.lopes.carneiro.de.aragao.monteiro
 */
public class FilmNow {
    private Filme[] filmes;
    private Filme[] hotList;
    private static final int MAXFILMES = 101;
    private static final int MAXHOT = 11;

    /**
     * Construtor da classe. Inicializa os arrays (TAMANHO FIXO).
     * Usa-se um número a mais que a especificação para
     * facilitar o tratamento do índice.
     *
     */
    public FilmNow() {
        this.filmes = new Filme[MAXFILMES];
        this.hotList = new Filme[MAXHOT];
    }

    /**
     * Recebe parâmetros para a inicialização de um objeto da classe Filme,
     * que logo em seguida é adicionado à lista de filmes.
     *
     * @param posicaoLista
     * @param nome
     * @param anoDeLancamento
     * @param ondeAssistir
     * @return possíveis erros ao se adicionar o filme, esclarecidos na especificação.
     */
    public String adicionaFilme(int posicaoLista, String nome, String anoDeLancamento, String ondeAssistir) {
        if (posicaoLista < 1 || posicaoLista >= MAXFILMES){
            return "POSIÇÃO INVÁLIDA";
        }
        else if((nome == null || nome.isBlank()) || (ondeAssistir == null || ondeAssistir.isBlank())){
            return "FILME INVALIDO";
        }
        Filme filme = new Filme(nome,anoDeLancamento,ondeAssistir);
         if(temFilme(filme)){
            return "FILME JÁ ADICIONADO!";
        }
        else {
            filmes[posicaoLista] = filme;
            return "FILME ADICIONADO!";
        }
    }

    /**
     * O método visualiza filmes retorna todos os filmes no array
     * de filmes gerais. A representação segue o formato:
     * "posição - nome do filme1"
     * "posicao - nome do filme2"
     * e assim por diante, retornando apenas uma String.
     *
     * @return String que enlenca todos os filmes do array filmes[]
     */
    public String visualizaFilmes() {
        String retorno = "";
        for (int i = 0; i < MAXFILMES; i++){
            if (filmes[i] != null){

                retorno += i + " - " + filmes[i].getNome()+"\n";
            }
        }
        return retorno;
    }

    /**
     * Detalha os atributos de um filme na posição especificada
     * na lista geral.
     *
     * @param posicaoLista
     * @return o toString do filme, caso o filme seja encontrado,
     * e posiçao inválida, caso o número informado supere o limite
     * ou não haja filme na posição.
     */
    public String detalhaFilme(int posicaoLista) {
        if ((posicaoLista < 1) || (posicaoLista >= MAXFILMES)){
            return "POSIÇÃO INVÁLIDA";
        }
        else if (filmes[posicaoLista] == null){
            return "";
        }

        return filmes[posicaoLista].toString();
    }

    /**
     * Recebe parâmetros para a inicialização de um objeto da classe Filme,
     * que logo em seguida é adicionado à hot list.
     *
     * @param posicaoHot
     * @param posLista
     * @return possíveis erros ao se adicionar o filme, esclarecidos na especificação.
     */
    public String adicionarHot(int posicaoHot, int posLista) {
        if ((posicaoHot < 1) || (posicaoHot >= MAXHOT)){
            return "POSIÇÃO INVÁLIDA";
        }
        if ((posLista < 1) || (posLista >= MAXFILMES)){
            return "FILME INVÁLIDO";
        }
        if (filmes[posLista] == null){
            return "FILME INVALIDO";
        }

        Filme filme = filmes[posLista];
        if(temHot(filme)){
            return "FILME JÁ ADICIONADO!";
        }

        if(hotList[posicaoHot] != null){
            hotList[posicaoHot].setHot(false);
        }
        hotList[posicaoHot] = filme;
        filme.setHot(true);
        return "FILME ADICIONADO!";

    }

    /**
     * O método exibir hot list retorna todos os filmes no array
     * de filmes hots. A representação segue o formato:
     * "posição na hotlist - nome do filme1"
     * "posicao na hotlist - nome do filme2"
     * e assim por diante, retornando apenas uma String.
     * @return
     */
    public String exibirHotList() {
        String retorno = "";
        for (int i = 1; i < MAXHOT; i++){
            if (hotList[i] != null){
                retorno += i + " - " + hotList[i].getNome()+"\n";
            }
        }
        return retorno;
    }

    /**
     * Checa se o filme está na hot list, e caso já esteja, o remove
     * do array, setando o seu balor de hot como falso.
     *
     * @param posicaoHot
     * @return
     */
    public String removerHot(int posicaoHot) {
        if((posicaoHot < 1) && (posicaoHot >= MAXHOT)){
            return "POSIÇÃO INVÁLIDA";
        }
        else{
            hotList[posicaoHot].setHot(false);
            hotList[posicaoHot] = null;
            return "FILME REMOVIDO DA HOTLIST!";
        }
    }

    /**
     * Percorre o array de filmes gerais e verifica se já tem um outro
     * objeto da classefilme, igual ao fornecido, dentro do array.
     *
     * @param filme
     * @return se o filme já existe no array
     */
    private boolean temFilme(Filme filme) {
        for (int i = 1; i < MAXFILMES; i++){
            if ((filmes[i]!= null) && (filmes[i].equals(filme))){
                return true;
            }
        }
        return false;
    }

    /**
     * Percorre o array de filmes na hot list e verifica se já tem um outro
     * objeto da classe filme, igual ao fornecido, dentro do array de filmes
     * hot.
     *
     * @param filme
     * @return se o filme já existe no array de filmes hot.
     */
    private boolean temHot(Filme filme) {
        for (int i = 1; i < MAXHOT; i++){
            if ((hotList[i]!= null) && (hotList[i].equals(filme))){
                return true;
            }
        }
        return false;
    }

}