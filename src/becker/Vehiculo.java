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

/**
 *
 * @author COMPAQ
 */
public class Vehiculo extends Thing {
    private String Placa;
    private int numero;
    public Vehiculo(City city, int i, int i1, Direction drctn,String Placa) {
        super(city, i, i1, drctn);
        this.Placa=Placa;
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
    
    
}
