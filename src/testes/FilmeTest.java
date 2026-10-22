package testes;

import filmnow.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmeTest {
    private Filme filme;
    @BeforeEach
    void setUp() {
        this.filme = new Filme("TestFilm","2026","intellij");
    }

    @Test
    void testToString() {
        assertEquals("TestFilm, 2026\nintellij",this.filme.toString());
        filme.setHot(true);
        assertEquals("\uD83D\uDD25 TestFilm, 2026\nintellij",this.filme.toString());
    }

    @Test
    void testEquals() {
        Filme novoFilme = new Filme("TestFilm", "2026","NetFlix");
        Filme novoFilme2 = new Filme("TestFilm", "2026","amazon");
        Filme novoFilme3 = new Filme("Film", "2026","NetFlix");
        Filme novoFilme4 = new Filme("Test", "2026","NetFlix");
        Filme novoFilme5 = new Filme("TestFilm", "2025","NetFlix");
        Filme novoFilme6 = new Filme("TestFilm", "2024","NetFlix");
        assert(filme.equals(novoFilme));
        assert(filme.equals(novoFilme2));
        assert(!filme.equals(novoFilme3));
        assert(!filme.equals(novoFilme4));
        assert(!filme.equals(novoFilme5));
        assert(!filme.equals(novoFilme6));
    }
}