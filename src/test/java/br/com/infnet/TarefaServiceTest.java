package br.com.infnet;

import br.com.infnet.exceptions.ValorInvalidoException;
import br.com.infnet.model.Tarefa;
import br.com.infnet.service.TarefaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TarefaServiceTest {
    @Autowired
    TarefaService tarefaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TarefaService.class);

    @Test
    @DisplayName("Testa a função de chamar todos os elementos")
    public void teste1(){
        List<Tarefa> tarefas = tarefaService.getAll();
        assertEquals(3, tarefas.size());
    }

    @Test
    @DisplayName("Testa pegar o elemento pelo id")
    public void teste2(){
        int id = -1;
        assertThrows(ValorInvalidoException.class, () -> {
            LOGGER.error("Id não pode ser negativo");
            Tarefa tarefa = tarefaService.getById(id);
        });

    }

    @Test
    @DisplayName("Testa o a função delete")
    public void teste3(){
        Tarefa tarefa = tarefaService.delete(2);
        assertNotNull(tarefa);
    }
}
