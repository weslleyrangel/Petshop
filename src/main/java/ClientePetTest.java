import com.petshop.model.Cliente;
import com.petshop.model.Pet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientePetTest {

    @Test
    public void testClientePetRelacionamento() {
        Cliente cliente = new Cliente();
        cliente.setNome("João Silva");

        Pet pet = new Pet();
        pet.setNome("Rex");
        pet.setCliente(cliente);

        assertEquals(cliente, pet.getCliente());
        assertEquals("João Silva", pet.getCliente().getNome());
    }
}