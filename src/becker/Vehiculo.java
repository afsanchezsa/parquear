/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Thing;
import becker.robots.icons.Icon;
import java.util.Calendar;
import static java.util.Calendar.HOUR_OF_DAY;
import java.util.GregorianCalendar;

/**
 *
 * @author COMPAQ
 */
public class Vehiculo extends Thing {
    private String Placa;
    private int numero;
     Calendar calendario;
     private int avenue;
     private int street;
    public Vehiculo(City city, int i, int i1, Direction drctn,String Placa) {
        super(city, i, i1, drctn);
        this.Placa=Placa;
        this.calendario=new GregorianCalendar();
    }

    public String getPlaca() {
        return Placa;
    }

    public int getNumero() {
        return numero;
    }
    public void setPlaca(String Placa){
    this.Placa=Placa;
    
    }
    public int getHora(){
    return this.calendario.get(HOUR_OF_DAY);
    
    }

    public int getAvenue() {
        return avenue;
    }

    public int getStreet() {
        return street;
    }
    public void setposicion(){
    this.avenue=this.getAvenue();
    this.street=this.getStreet();
    }

    public void setStreet(int street) {
        this.street = street;
    }
    
    
}
