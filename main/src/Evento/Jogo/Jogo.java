package Evento.Jogo;

import Evento.Evento;

public class Jogo extends Evento {
    private Time time1;
    private Time time2;
    private int golsTime1;
    private int golsTime2;
    
    public Jogo(String nome,String tipo, int numero_maximo, float preco, float duracao, String data,int horario,String status) {
        super(nome,tipo, numero_maximo, preco, duracao, data,horario,status);
    }

    /**
     * @return the time1
     */
    public Time getTime1() {
        return time1;
    }

    /**
     * @param time1 the time1 to set
     */
    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    /**
     * @return the time2
     */
    public Time getTime2() {
        return time2;
    }

    /**
     * @param time2 the time2 to set
     */
    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    /**
     * @return the golsTime1
     */
    public int getGolsTime1() {
        return golsTime1;
    }

    /**
     * @param golsTime1 the golsTime1 to set
     */
    public void setGolsTime1(int golsTime1) {
        this.golsTime1 = golsTime1;
    }

    /**
     * @return the golsTime2
     */
    public int getGolsTime2() {
        return golsTime2;
    }

    /**
     * @param golsTime2 the golsTime2 to set
     */
    public void setGolsTime2(int golsTime2) {
        this.golsTime2 = golsTime2;
    }
}
