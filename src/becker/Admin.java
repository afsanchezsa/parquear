/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.HOUR_OF_DAY;
import java.util.GregorianCalendar;

/**
 *
 * @author COMPAQ
 */
public class Admin extends Robot {

    private int[] zona1;
    private int[] zona2;
    private int[] zona3;

    public Admin(City city, int i, int i1, Direction drctn) {
        super(city, i, i1, drctn);
        this.zona1 = new int[5];
        this.zona2 = new int[5];
        this.zona3 = new int[5];
        for (int n = 0; n < 3; n++) {
            this.zona1[n] = 0;
            this.zona2[n] = 0;
            this.zona3[n] = 0;

        }

    }

    public void retornar_inicio() {
        boolean nosur = false;
        int y = this.getStreet();
        int x = this.getAvenue();
        if (y < 9) {
            Direction direccion = this.getDirection();
            if (direccion != Direction.SOUTH) {
                nosur = true;
            }
            while (nosur) {
                this.turnLeft();
                nosur = this.getDirection() != Direction.SOUTH;
            }
            for (int i = y; i < 9; i++) {
                this.move();
            }
        }
        this.turnLeft();
        while (x < 19) {
            this.move();
            x = this.getAvenue();
        }
        this.turnLeft();
        this.turnLeft();
    }

    public int mirar_desocupado() {
        //for(int i=19;i>5;i--){

        //------
        this.move();
        this.move();
        this.move();
        this.move();
        this.move();
        this.move();
        this.move();
        if (this.getAvenue() == 12 || this.getAvenue() == 8 || this.getAvenue() == 4) {
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            //for (int j = 0; j < 5; j++) {
            if (this.getAvenue() == 12) {
                for (int j = 0; j < 5; j++) {
                    this.move();
                    this.zona3[j] = this.canPickThing() ? 1 : 0;
                }
            }
            //}
            this.salir_de_zona();
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
            this.move();
            this.move();
            this.move();
            if (this.getAvenue() == 8) {
                this.turnLeft();
                this.turnLeft();
                this.turnLeft();
                for (int j = 0; j < 5; j++) {

                    this.move();
                    this.zona2[j] = this.canPickThing() ? 1 : 0;

                }
                this.salir_de_zona();
            }

            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
            this.move();
            this.move();
            this.move();
            if (this.getAvenue() == 4) {
                this.turnLeft();
                this.turnLeft();
                this.turnLeft();
                for (int j = 0; j < 5; j++) {

                    this.move();
                    this.zona1[j] = this.canPickThing() ? 1 : 0;

                }

            }
            this.salir_de_zona();

        }
        this.retornar_inicio();
        int suma1=0;
        int suma2=0;
        int suma3=0;
        for(int i=0;i<5;i++){
        suma1+=this.zona1[i];
        suma2+=this.zona2[i];
        suma3+=this.zona3[i];
        }
        int menor=0;
        System.out.println("seccion 1 tiene:"+suma1+"carros");
        System.out.println("seccion 2 tiene:"+suma2+"carros");
        System.out.println("seccion 3 tiene:"+suma3+"carros");
        
        int []sumas=new int [3];
        sumas[0]=suma1;
        sumas[1]=suma2;
        sumas[2]=suma3;
        for(int i=1;i<3;i++){
        if(sumas[i-1]<=sumas[i]){
        menor=sumas[i-1];
        }
        }
return menor;
    }

    public void salir_de_zona() {
        int x;
        x = this.getStreet();
        Direction direccion = this.getDirection();
        while (direccion != Direction.SOUTH) {
            this.turnLeft();
            direccion = this.getDirection();
        }
        while (x < 9) {
            this.move();
            x++;
        }
    }

    public int[] getZona1() {
        return zona1;
    }

    public int[] getZona2() {
        return zona2;
    }

    public int[] getZona3() {
        return zona3;
    }

    public int parquear_en_la_zona(int zona) {
        this.pickThing();
        int calle=0;
        if (zona == 3) {
            for (int i = 0; i < 7; i++) {
                this.move();
            }
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            for (int i = 0; i < 5; i++) {
                this.move();
            }
            this.turnLeft();
            this.turnLeft();

            for (int i = 0; i < 6; i++) {
                if (this.canPickThing() == false && this.countThingsInBackpack() != 0) {
                    this.putThing();
                    calle=this.getStreet();
                } else {
                    this.move();
                }

            }
        }
        //------------------------------------------------------------------------
        if (zona == 2) {
            for (int i = 0; i < 11; i++) {
                this.move();
            }
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            for (int i = 0; i < 5; i++) {
                this.move();
            }
            this.turnLeft();
            this.turnLeft();

            for (int i = 0; i < 6; i++) {
                if (this.canPickThing() == false && this.countThingsInBackpack() != 0) {
                    this.putThing();
                    calle=this.getStreet();
                } else {
                    this.move();
                }

            }
        }
        //-----------------------------------------
        if (zona == 1) {
            for (int i = 0; i < 15; i++) {
                this.move();
            }
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            for (int i = 0; i < 5; i++) {
                this.move();
            }
            this.turnLeft();
            this.turnLeft();

            for (int i = 0; i < 6; i++) {
                if (this.canPickThing() == false && this.countThingsInBackpack() != 0) {
                    this.putThing();
                    calle=this.getStreet();
                } else {
                    this.move();
                }

            }
        }

    return calle;
    }

    public boolean parqueadero_lleno() {
        int suma = 0;
        this.mirar_desocupado();
        for (int i = 0; i < 3; i++) {
            suma += this.zona1[i];
            suma += this.zona2[i];
            suma += this.zona3[i];
        }

        if (suma == 15) {
            return true;

        } else {
            return false;
        }

    }

    public void sacar_vehiculo(int zona, int street) {
        int topex = 0, topey = street, posprovisional;
        if (zona == 3) {
            topex = 12;
        } else if (zona == 2) {
            topex = 8;
        } else if (zona == 1) {
            topex = 4;
        } else {
            System.out.println(" seccion no definida");
        }
        boolean llegar = false;
        while (!llegar) {

            if (this.getAvenue() != topex) {
                this.move();
            } else {
                this.turnLeft();
                this.turnLeft();
                this.turnLeft();
                llegar = true;
            }
        }
        this.move();

        /*for (int i = this.getStreet(); i < topey; i--) {
                this.move();
                if (this.canPickThing()) {
                    posprovisional = this.getStreet() - 3;
                    this.pickThing();
                    this.turnLeft();
                    this.turnLeft();
                    this.retornar_inicio();
                    for (int j = 6; j > posprovisional - 1; j--) {
                        this.move();
                    }
                    this.turnLeft();
                    this.turnLeft();
                    this.turnLeft();
                    this.move();
                    this.putThing();
                    //break;
                    //this.sacar_vehiculo(zona,street);
                }
            }*/
        while (!this.canPickThing() || this.getStreet() != street) {
            this.move();
        }
        if (this.canPickThing() && this.getStreet() != street) {
            this.pickThing();
            this.retornar_inicio();
            this.turnLeft();
            this.turnLeft();
            boolean parqueadoenprovisional = false;
            while (!parqueadoenprovisional) {
                this.move();
                this.turnLeft();
                this.turnLeft();
                this.turnLeft();
                this.move();
                if (this.canPickThing()) {
                    this.turnLeft();
                    this.turnLeft();
                    this.move();
                    this.turnLeft();
                    this.turnLeft();
                    this.turnLeft();
                    this.move();

                } else {
                    this.putThing();
                    parqueadoenprovisional = true;
                }
            }
        }

    }

    public void exit_vehiculo(int zona, int street) {
        int topex = 0, topey = street, posprovisional, calle;
         boolean []parqueaderos;
        if (zona == 3) {
            topex = 12;
        } else if (zona == 2) {
            topex = 8;
        } else if (zona == 1) {
            topex = 4;
        } else {
            System.out.println(" seccion no definida");
        }
        /*while(this.getAvenue()!=topex){
this.move();

} */ 
        
       // do {
       while (this.getAvenue() != topex) {
                this.move();

            }
        calle = extraer(street);
         while (calle-1> street){
       while (this.getAvenue() != topex) {
                this.move();

            }
            calle = extraer(street);
             parqueaderos=this.provisional();
            parquearenprovisional2(parqueaderos);
            
        //} while (calle-1> street);
         }
        while (this.getAvenue() != topex) {
                this.move();

            }
        extraer(street);
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
        this.move();
        this.putThing();
        this.turnLeft();
        this.turnLeft();
        this.move();
this.turnLeft();
this.turnLeft();
this.turnLeft();







 

       // while (this.getAvenue() != topex) {
         //   this.move();

        //}
        //calle=extraer(street);
       /* parqueaderos=this.provisional();
        parquearenprovisional2(parqueaderos);
        calle=extraer(street);
        parqueaderos=this.provisional();
*/
    }

    public int extraer(int street) {
        int calle;
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
        while (!this.canPickThing()) {
            this.move();

        }
        this.pickThing();
        calle = this.getStreet();
        this.turnLeft();
        this.turnLeft();
        while (this.getStreet() != 9) {
            this.move();
        }
        this.turnLeft();
        while (this.getAvenue() != 19) {
            this.move();
        }
        this.turnLeft();
        this.turnLeft();
        return calle;
    }

    public int getZonaMenor() {
        int suma1 = 0;
        int suma2 = 0;
        int suma3 = 0;

        for (int i = 0; i < 3; i++) {
            suma1 += this.zona1[i];
            suma2 += this.zona2[i];
            suma3 += this.zona3[i];
        }
        int sumas[] = new int[3];
        sumas[0] = suma1;
        sumas[1] = suma2;
        sumas[2] = suma3;
        int fin = sumas[0];
        for (int i = 1; i < 3; i++) {
            if (sumas[i - 1] < sumas[i]) {
                fin = sumas[i - 1];
            }
        }
        return fin;
    }

    public void parquearenprovisional() {
        boolean parqueado = false;
        this.move();
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
        while (!parqueado) {
    //_-------        /*this.move();
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
            if (!this.canPickThing()) {
                this.putThing();
                /*this.turnLeft();
                this.turnLeft();
                this.move();
                this.turnLeft();
                while (this.getAvenue() != 19) {
                    this.move();
                }*/
                //this.turnLeft();
                //this.turnLeft();
                parqueado = true;
                this.retornar_inicio();
               // break;
            } else {
                /*this.turnLeft();
                this.turnLeft();
                this.move();
                this.turnLeft();
                this.turnLeft();
                this.turnLeft();
                */
                
             //this.retornar_inicio();
             this.turnLeft();
             this.move();
             if(!this.canPickThing()){
             this.putThing();
             }else{
             this.move();
             if(!this.canPickThing()){
             this.putThing();
             }else{
             this.move();
             if(!this.canPickThing()){
             this.retornar_inicio();
             }
             }
             }
            }
        }

    }

    public void devolverdelprovisional(int zona) {
        boolean todosretornados = false;
        int topex = 0;
        if (zona == 3) {
            topex = 12;
        } else if (zona == 2) {
            topex = 8;
        } else if (zona == 1) {
            topex = 4;
        } else {
            System.out.println(" seccion no definida");
        }
        while (!todosretornados) {
            this.move();
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
            this.turnLeft();
            if (!this.canPickThing()) {
               // this.pickThing();
               this.putThing();
               this.turnLeft();
                this.turnLeft();
                this.move();
                this.turnLeft();
                this.turnLeft();
                this.turnLeft();
                while (this.getAvenue() != topex) {
                    this.move();

                }
                this.turnLeft();
                this.turnLeft();
                this.turnLeft();
                for (int i = 0; i < 5; i++) {
                    this.move();
                }
                this.turnLeft();
                this.turnLeft();
                while (this.getStreet() != 9) {
                    if (this.canPickThing()) {
                        this.move();
                    } else {
                        this.putThing();
                        this.retornar_inicio();
                        break;
                    }
                }
            }//------
            else{
                this.turnLeft();
            while(!this.canPickThing()){
            this.move();
            }
      this.putThing();
            }/*
            this.move();
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
            this.turnLeft();
            while (this.getAvenue() != 15) {
                if (this.canPickThing()) {
                    todosretornados = true;
                } else {
                    todosretornados = false;
                    this.retornar_inicio();
                }

            }*/
        }

    }
public boolean[] provisional(){
boolean []parqueaderospro=new boolean[4];
this.move();
this.turnLeft();
this.turnLeft();
this.turnLeft();
this.move();
this.turnLeft();
for(int i=0;i<3;i++){
parqueaderospro[i]=this.canPickThing();
        this.move();
        
} 
this.turnLeft();
this.move();
this.turnLeft();
this.move();
this.move();
this.move();
this.move();
this.turnLeft();
this.turnLeft();

 
return parqueaderospro;

}
public void parquearlo_en_provisional(boolean[]parqueaderospro){
this.move();
this.turnLeft();
this.turnLeft();
this.turnLeft();
this.move();
this.turnLeft();
for(int i=0;i<4;i++){
if(parqueaderospro[i]==true){
this.putThing();
break;
}else{
this.move();
}

}
this.retornar_inicio();
}
 public void parquearenprovisional2(boolean []parqueaderos) {
       this.move();
       this.turnLeft();
       this.turnLeft();
       this.turnLeft();
       
       this.move();
       this.turnLeft();
       for(int i=0;i<4;i++){
       if(parqueaderos[i]==false){
       this.putThing();
       this.retornar_inicio();
       
       break;
       }else{
       this.move();
       }
       }
 }
    /**
     *
     * @param zona
     * @param placa
     * @return
     */
   /* public int calle_vehiculo2(int zona,String placa){
           int topex = 0,calle=0;
        if (zona == 3) {
            topex = 12;
        } else if (zona == 2) {
            topex = 8;
        } else if (zona == 1) {
            topex = 4;
        } else {
            System.out.println(" seccion no definida");
        }
        while (this.getAvenue() != topex) {
                    this.move();

                }
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
        
        this.move();
        this.pickThing();
        Iterator cosas=(Iterator) this.examineThings();
        for(Thing t:cosas){
        
        }
        
       return calle;
       }
      */ 
    public void devolverdelprovisional2(int zona) {
        boolean todosretornados = false;
        int topex = 0;
        if (zona == 3) {
            topex = 12;
        } else if (zona == 2) {
            topex = 8;
        } else if (zona == 1) {
            topex = 4;
        } else {
            System.out.println(" seccion no definida");
        }
        boolean[]provisional=this.provisional();
        for(int i=0;i<4;i++){
        todosretornados=todosretornados||provisional[i];
        }
        
       int n=1;
       int p=0;
            while(todosretornados){
            for(int i=0;i<n;i++){
            this.move();
            }
             
            
            
                
            this.turnLeft();
            this.turnLeft();
            this.turnLeft();
            this.move();
            this.turnLeft();
            
           if(!this.canPickThing()){
           this.move();
           }else{
           this.pickThing();
           this.retornar_inicio();
           while(this.getAvenue()!=topex){
           this.move();
           }
           this.turnLeft();
           this.turnLeft();
           this.turnLeft();
            for(int i=0;i<5;i++){
            this.move();
            }
            this.turnLeft();
            this.turnLeft();
            
            for(int i=0;i<5;i++){
            if(!this.canPickThing()){
            this.putThing();
            this.retornar_inicio();
            break;
            }else{
            this.move();
            }
            
            
            
            }
            
           }
        todosretornados=false;
           provisional=this.provisional();
        for(int i=0;i<4;i++){
        todosretornados=todosretornados||provisional[i];
        }
        n++;
        
       }
    }
     public void exit_vehiculo2(int zona, int street) {
        int topex = 0, topey = street, posprovisional, calle;
         int []parqueaderosseccion=new int [5];
         boolean[]parqueaderos;
        if (zona == 3) {
            topex = 12;
        } else if (zona == 2) {
            topex = 8;
        } else if (zona == 1) {
            topex = 4;
        } else {
            System.out.println(" seccion no definida");
        }
        /*while(this.getAvenue()!=topex){
this.move();

} */ 
        
       // do {
      
       while (this.getAvenue() != topex) {
                this.move();

            }
       this.turnLeft();
       this.turnLeft();
       this.turnLeft();
       for(int i=0;i<5;i++){
       this.move();
       }
          this.turnLeft();
          this.turnLeft();
          for(int i=4;i>=0;i--){
          if(this.canPickThing()&&this.getStreet()==street){
          parqueaderosseccion[i]=2;
          this.move();
          }else if(this.canPickThing()){
          parqueaderosseccion[i]=1;
          this.move();
          }else if(!this.canPickThing()){
          parqueaderosseccion[i]=0;
          this.move();
          }
          }
          this.retornar_inicio();
          int contador=0;
          for(int i=0;i<5;i++){
          if(parqueaderosseccion[i]==0){
          
          }else if(parqueaderosseccion[i]==1){
          contador++;
          }else if(parqueaderosseccion[i]==2){
          break;
          }
          
          }
          System.out.println("contador ="+contador);
          
          for(int i=0;i<contador;i++){
            
       while (this.getAvenue() != topex) {
                this.move();

            }
              calle = extraer(street);
             parqueaderos=this.provisional();
            parquearenprovisional2(parqueaderos);
          
          }
           while (this.getAvenue() != topex) {
                this.move();

            }
        extraer(street);
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
        this.move();
        this.putThing();
        this.turnLeft();
        this.turnLeft();
        this.move();
this.turnLeft();
this.turnLeft();
this.turnLeft();
          






    }

        
}


