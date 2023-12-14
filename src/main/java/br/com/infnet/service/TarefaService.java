package br.com.infnet.service;

import br.com.infnet.model.Tarefa;
import br.com.infnet.exceptions.ValorInvalidoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {
    List<Tarefa> tarefas = initClientes();
    Logger logger = LoggerFactory.getLogger(TarefaService.class);
    private List<Tarefa> initClientes() {
        Tarefa ranieri = new Tarefa(0, "Estudar");
        Tarefa pedro = new Tarefa(1, "Academia");
        Tarefa maria = new Tarefa(2, "Trabalho");
        ArrayList<Tarefa>tarefas = new ArrayList<>();
        tarefas.add(ranieri);
        tarefas.add(pedro);
        tarefas.add(maria);
        return tarefas;
    }
    public List<Tarefa> getAll(){
        return tarefas;
    }
    public Tarefa getById(int id){
        if(id < 0){
            throw new ValorInvalidoException("O id não pode ser negativo");
        }
        return tarefas.get(id);
    }
    public void save(Tarefa tarefa){
        tarefas.add(tarefa);
    }
    public Tarefa delete(int id){
        return tarefas.remove(id);
    }
    public void update(int id, Tarefa tarefa){
        tarefas.remove(id);
        tarefa.setId(id);
        tarefas.add(id, tarefa);
    }
}
