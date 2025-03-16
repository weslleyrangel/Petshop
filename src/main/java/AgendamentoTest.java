import com.petshop.model.Agendamento;
import com.petshop.model.Pet;
import com.petshop.model.Servico;
import com.petshop.model.StatusAgendamento;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AgendamentoTest {

    @Test
    public void testAgendamentoRelacionamento() {
        Pet pet = new Pet();
        pet.setNome("Rex");

        Servico servico = new Servico();
        servico.setNome("Banho e Tosa");

        Agendamento agendamento = new Agendamento();
        agendamento.setPet(pet);
        agendamento.setServico(servico);
        agendamento.setDataHora(new Date());
        agendamento.setStatus(StatusAgendamento.AGENDADO);

        assertEquals(pet, agendamento.getPet());
        assertEquals(servico, agendamento.getServico());
        assertEquals("Rex", agendamento.getPet().getNome());
        assertEquals("Banho e Tosa", agendamento.getServico().getNome());
        assertEquals(StatusAgendamento.AGENDADO, agendamento.getStatus());
    }
}