package br.com.infnet.model;

public class Conversor {
    public static double conversorKelvinCelsius(double tempKelvin) {
        double tempCelsius = tempKelvin - 273.15;
        return tempCelsius;
    }
}
