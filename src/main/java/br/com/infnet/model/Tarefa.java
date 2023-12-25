package br.com.infnet.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class Tarefa {
    private int id;
    private String titulo;
    private double temperatura;
    private String descricaoClima;
}
