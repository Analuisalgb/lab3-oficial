package testes;
import filmnow.FilmNow;
import filmnow.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class FilmNowTest {
    private FilmNow fn;
    @BeforeEach
    void setUp() {
        fn = new FilmNow();
    }

    @Test
    void adicionaFilmeTest1() {
        assertEquals("FILME ADICIONADO!", fn.adicionaFilme(1, "Avatar", "2009", "Disney+"));
    }
    @Test
    void adicionaFilmeTest2(){
        fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
        assertEquals("FILME ADICIONADO!",fn.adicionaFilme(1,"20 dias em Mariupol", "2023", "Cinema"));
    }

    @Test
    void adicionaFilmeTest3(){
        fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
        assertEquals("FILME JÁ ADICIONADO!", fn.adicionaFilme(3, "Avatar", "2009", "Disney+"));
    }

    @Test
    void adicionaFilmeTest4(){
        fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
        assertEquals("FILME JÁ ADICIONADO!", fn.adicionaFilme(3, "Avatar", "2009", "Popcornflix"));
    }

    @Test
    void adicionaFilmeTest5(){
        assertEquals("FILME ADICIONADO!", fn.adicionaFilme(100, "Avatar", "2009", "Popcornflix"));
    }

    @Test
    void adicionaFilmeTest6(){
        assertEquals("POSIÇÃO INVÁLIDA", fn.adicionaFilme(101, "Avatar", "2009", "Popcornflix"));
    }

    @Test
    void adicionaFilmeTest7(){
        assertEquals("POSIÇÃO INVÁLIDA", fn.adicionaFilme(0, "Avatar", "2009", "Popcornflix"));
    }

    @Test
    void adicionaFilmeTest8(){
        assertEquals("FILME INVALIDO", fn.adicionaFilme(1, "20 dias em Mariupol", "2023", ""));
    }

    @Test
    void adicionaFilmeTest9(){
        assertEquals("FILME ADICIONADO!", fn.adicionaFilme(1, "20 dias em Mariupol", "", "Cinema"));
    }

    @Test
    void adicionaFilmeTest10(){
        assertEquals("FILME INVALIDO", fn.adicionaFilme(1, "", "2023", "Cinema"));
    }

    @Test
    void visualizaFilmes() {
        assertEquals("",fn.visualizaFilmes());
        fn.adicionaFilme(1,"TestFilm","2026", "intellij");
        assertEquals("1 - TestFilm\n",fn.visualizaFilmes());
        fn.adicionaFilme(3,"TestFilm3","2026", "intellij");
        assertEquals("1 - TestFilm\n3 - TestFilm3\n",fn.visualizaFilmes());
        fn.adicionaFilme(2,"TestFilm2","2026", "intellij");
        assertEquals("1 - TestFilm\n2 - TestFilm2\n3 - TestFilm3\n",fn.visualizaFilmes());
    }

    @Test
    void detalhaFilmeTest1() {
        fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
        assertEquals("Avatar, 2009\nDisney+",fn.detalhaFilme(1));
    }

    @Test
    void detalhaFilmeTest2() {
        fn.adicionaFilme(1, "20 dias em Mariupol", "", "Cinema");
        assertEquals("20 dias em Mariupol\nCinema",fn.detalhaFilme(1));
    }

    @Test
    void detalhaFilmeTest3() {
        assertEquals("",fn.detalhaFilme(100));
    }

    @Test
    void detalhaFilmeTest4() {
        assertEquals("POSIÇÃO INVÁLIDA",fn.detalhaFilme(0));
    }

    @Test
    void detalhaFilmeTest5() {
        assertEquals("POSIÇÃO INVÁLIDA",fn.detalhaFilme(101));
    }

    @Test
    void detalhaFilmeTest6() {
        fn.adicionaFilme(1, "Avatar", "2009", "Disney+");
        fn.adicionarHot(1,1);
        assertEquals("\uD83D\uDD25 Avatar, 2009\nDisney+",fn.detalhaFilme(1));
    }


    @Test
    void adicionarHot() {
    }

    @Test
    void exibirHotList() {
    }

    @Test
    void removerHot() {
    }
}