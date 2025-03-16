import com.petshop.model.Servico;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoTest {

    @Test
    public void testServicoValido() {
        Servico servico = new Servico();
        servico.setNome("Banho e Tosa");
        servico.setPreco(new BigDecimal("50.00"));
        servico.setDuracaoMinutos(60);

        assertEquals("Banho e Tosa", servico.getNome());
        assertEquals(new BigDecimal("50.00"), servico.getPreco());
        assertEquals(60, servico.getDuracaoMinutos());
    }

    @Test
    public void testServicoPrecoInvalido() {
        Servico servico = new Servico();
        servico.setNome("Banho e Tosa");

        assertThrows(IllegalArgumentException.class, () -> {
            servico.setPreco(new BigDecimal("-10.00")); // Preço negativo
        });
    }
}