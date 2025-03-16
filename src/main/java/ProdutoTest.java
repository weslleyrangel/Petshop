import com.petshop.model.Produto;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    public void testProdutoValido() {
        Produto produto = new Produto();
        produto.setNome("Ração para Cães");
        produto.setPreco(new BigDecimal("100.00"));
        produto.setQuantidadeEstoque(10);

        assertEquals("Ração para Cães", produto.getNome());
        assertEquals(new BigDecimal("100.00"), produto.getPreco());
        assertEquals(10, produto.getQuantidadeEstoque());
    }

    @Test
    public void testDiminuirEstoque() {
        Produto produto = new Produto();
        produto.setQuantidadeEstoque(10);

        produto.diminuirEstoque(5);
        assertEquals(5, produto.getQuantidadeEstoque());

        assertThrows(IllegalArgumentException.class, () -> {
            produto.diminuirEstoque(10); // Estoque insuficiente
        });
    }
}