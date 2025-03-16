import com.petshop.model.Atendimento;
import com.petshop.model.Pet;
import com.petshop.model.Servico;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AtendimentoTest {

    @Test
    public void testAtendimentoRelacionamento() {
        Pet pet = new Pet();
        pet.setNome("Rex");

        Servico servico = new Servico();
        servico.setNome("Banho e Tosa");

        Atendimento atendimento = new Atendimento();
        atendimento.setPet(pet);
        atendimento.setServico(servico);
        atendimento.setDataHora(new Date());
        atendimento.setValorCobrado(new BigDecimal("50.00"));

        assertEquals(pet, atendimento.getPet());
        assertEquals(servico, atendimento.getServico());
        assertEquals("Rex", atendimento.getPet().getNome());
        assertEquals("Banho e Tosa", atendimento.getServico().getNome());
    }
}