package br.com.infnet.service;

import br.com.infnet.model.Conversor;
import br.com.infnet.model.Tarefa;
import br.com.infnet.exceptions.ValorInvalidoException;
import br.com.infnet.model.Tempo;
import br.com.infnet.util.TempoUtil;
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
        double latitude = -22.82;
        double longitude = -47.27;
        TempoUtil tempoUtil = new TempoUtil();
        Tempo tempo = tempoUtil.getClima(latitude, longitude);
        Tarefa tarefa1 = new Tarefa(0, "Corrida no parque", Conversor.conversorKelvinCelsius(tempo.getMain().getTemp()), tempo.getWeather().get(0).getDescription());
        ArrayList<Tarefa>tarefas = new ArrayList<>();
        tarefas.add(tarefa1);
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
