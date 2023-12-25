package br.com.infnet;

import br.com.infnet.model.Tempo;
import br.com.infnet.util.TempoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempoTeste {
    @Test
    @DisplayName("Testa o retorno da requisição da api de tempo")
    public void teste1(){
        double latitude = -22.82;
        double longitude = -47.27;
        TempoUtil tempoUtil = new TempoUtil();
        Tempo tempo = tempoUtil.getClima(latitude, longitude);
        assertEquals(303.63, tempo.getMain().getTemp());
        assertEquals("scattered clouds", tempo.getWeather().get(0).getDescription());
    }
}
