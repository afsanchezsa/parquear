package becker;

import becker.robots.*;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DeliverParcel
{
   public static void main(String[] args)
   {  
     // Set up the initial situation
       Vehiculo vehiculo;
       int numvehiculo=0,calle=0;
      City prague = new City();
      //Thing parcel = new Thing(prague, 4, 8);
      //Thing parcel2 = new Thing(prague, 4, 12);
      int zona;
      //Robot karel = new Robot(prague, 9, 19, Direction.WEST,5);
      Wall[]muros=new Wall[50];
      ArrayList<Vehiculo>vehiculos=new ArrayList<>();
      crear_linea_muros(prague, 3, 3,16,Direction.NORTH, Direction.EAST);
       crear_linea_muros(prague, 3, 3, 6, Direction.WEST, Direction.SOUTH);
       crear_linea_muros(prague, 18, 8, 6, Direction.EAST, Direction.NORTH);
       crear_linea_muros(prague, 6, 3, 6, Direction.EAST, Direction.SOUTH);
       crear_linea_muros(prague, 10, 3, 6, Direction.EAST, Direction.SOUTH);
       crear_linea_muros(prague, 14, 3, 6, Direction.EAST, Direction.SOUTH);
       Scanner in=new Scanner(System.in);
       int seccion;
       
       ingresar_vehiculo(vehiculos, "htsn", prague);
       
       
       Admin admin=new Admin(prague, 4, 8, Direction.EAST);
       admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
      
      admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio();
       //-----------------------------------
        vehiculo=ingresar_vehiculo(vehiculos, "andres", prague);
       //admin.retornar_inicio();
       vehiculos.add(vehiculo);
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
              
       System.out.println("zona"+zona);
       calle=admin.parquear_en_la_zona(zona);
       vehiculos.get(vehiculos.size()-1).setStreet(calle);
       admin.retornar_inicio(); 
     
       //_-------------------------------------------------
       vehiculo=ingresar_vehiculo(vehiculos, "felipe", prague);
      // admin.retornar_inicio();
      vehiculos.add(vehiculo);
      admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       calle=admin.parquear_en_la_zona(zona);
       vehiculos.get(vehiculos.size()-1).setStreet(calle);
       admin.retornar_inicio(); 
       //_-----------------------------------------
       ingresar_vehiculo(vehiculos, "feli", prague);
      // admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio(); 
       //------------------------------------------------------
       ingresar_vehiculo(vehiculos, "fe", prague);
      // admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio(); 
       //--------------------------------------------------
       ingresar_vehiculo(vehiculos, "alisson", prague);
      // admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio(); 
       //-------------------------------------------------------------------------
        ingresar_vehiculo(vehiculos, "alisson2", prague);
      // admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio(); 
//------------------------------------------------
ingresar_vehiculo(vehiculos, "juliana", prague);
      // admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio(); 
       //-------------------------------------------
       ingresar_vehiculo(vehiculos, "alisson2", prague);
      // admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio(); 
       //-------------------------------------
       ingresar_vehiculo(vehiculos, "alisson3", prague);
      // admin.retornar_inicio();
       admin.mirar_desocupado();
       zona=zona_con_menos_vehiculos(admin.getZona1(), admin.getZona2(), admin.getZona3());
       
       System.out.println("zona"+zona);
       admin.parquear_en_la_zona(zona);
       
       admin.retornar_inicio(); 
//----------------------------------------
       if(admin.parqueadero_lleno()){
           System.out.println("el parqueadero esta lleno");
       }else{
           System.out.println("el parqueadero tiene cupos");
       }
       //-------sacar carro
       for(int i=0;i<vehiculos.size();i++){
       vehiculos.get(i).setposicion();
       }
       int callevehiculo=calle_vehiculo(1, "andres", vehiculos);
       System.out.println("calle"+callevehiculo);
       //admin.sacar_vehiculo(1, callevehiculo);
       admin.exit_vehiculo(1, callevehiculo);
       horasalida("andres", vehiculos);
       //------------delvover vehiculos a parqueadero
       admin.devolverdelprovisional2(1);
 

//--------mostrar vehiculos de la seccion
       System.out.println("inserte la seccion para mostrar sus autos");
      seccion=in.nextInt();
       System.out.println("en la seccion "+seccion+"se presentan los vehiculos con placas");
       for(Vehiculo v:vehiculos){
      if(v.getStreet()==4&&seccion==1){
          System.out.println(v.getPlaca());
          
      }else if(v.getStreet()==8&&seccion==2){
        System.out.println(v.getPlaca());
          
      }else if(v.getStreet()==12&&seccion==3){
        System.out.println(v.getPlaca());
          
      }
      }
       
   }
   public static void crear_linea_muros(City ciudad,int inicialx,int inicialy,int numero_muros,Direction direccion_a_la_que_mira,Direction hacia_donde_va_la_fila){
    Wall []muros=new Wall[numero_muros];
    int nummuros=0;
    
    if(hacia_donde_va_la_fila==Direction.EAST||hacia_donde_va_la_fila==Direction.WEST){
    for(int i=inicialy;hacia_donde_va_la_fila==Direction.EAST?i<inicialy+numero_muros:i>inicialy-numero_muros;i=hacia_donde_va_la_fila==Direction.EAST?i+1:i-1){
    muros[nummuros]=new Wall(ciudad,inicialx,i,direccion_a_la_que_mira);
    nummuros++;
    }
    }else if(hacia_donde_va_la_fila==Direction.NORTH||hacia_donde_va_la_fila==Direction.SOUTH){
    for(int i=inicialy;hacia_donde_va_la_fila==Direction.SOUTH?i<inicialy+numero_muros:i>inicialy-numero_muros;i=hacia_donde_va_la_fila==Direction.SOUTH?i+1:i-1){
    muros[nummuros]=new Wall(ciudad,i,inicialx,direccion_a_la_que_mira);
    nummuros++;
    }
    }else{
        
    }}
   /*public static void fila_carros(Vehiculo[]vehiculos, City ciudad){
   for(int i=0;i<15;i++){
   vehiculos[i]=new Vehiculo(ciudad,9, i+15, Direction.EAST);
   
   }*/
  public static Vehiculo ingresar_vehiculo(ArrayList<Vehiculo>vehiculos,String Placa,City ciudad){
  Vehiculo vehiculo=new Vehiculo(ciudad, 9, 19, Direction.EAST,Placa);
  //vehiculos.add(vehiculo);
      System.out.println("hora: "+vehiculo.getHora()+":00");
  return vehiculo;
  }
  public static int zona_con_menos_vehiculos(int[]zona1,int[]zona2,int[]zona3){
  int suma1=0,suma2=0,suma3=0;
  for(int i=0;i<5;i++){
  suma1+=zona1[i];
  }
  for(int i=0;i<5;i++){
  suma2+=zona2[i];
  }
  for(int i=0;i<5;i++){
  suma3+=zona3[i];
  }
  int[]sumas=new int[3];
  sumas[0]=suma1;
  sumas[1]=suma2;
  sumas[2]=suma3;
  int menor=sumas[2];
  for(int i=1;i<3;i++){
  if(sumas[i]<sumas[i-1]){
  menor=sumas[i];
  }
  }
  if(menor==sumas[0]){
  return 1;
  }else if(menor==sumas[1]){
  return 2;
  }else if(menor==sumas[2]){
  return 3;
  }
  return 0;
  }
   public static int calle_vehiculo(int seccion, String placa,ArrayList<Vehiculo>vehiculos){
  int street=0;
       for(Vehiculo v:vehiculos){
      if(v.getPlaca().equalsIgnoreCase(placa)){
          
      street=v.getStreet();
      }
      
      
  }
   return street;
   }
  public static int horasalida(String Placa,ArrayList<Vehiculo>vehiculos){
  int horasalida, minutos,segundos;
      for(Vehiculo v:vehiculos){
  if(Placa.equalsIgnoreCase(v.getPlaca())){
  Calendar micalendario=new GregorianCalendar();
 horasalida= micalendario.get(HOUR_OF_DAY);
 minutos=micalendario.get(Calendar.MINUTE);
 segundos=micalendario.get(Calendar.SECOND);
 System.out.println("Cobro con precio de 100 por minuto  = "+""+((v.getHora()-horasalida)*60*100));
      System.out.println("Hora de salida: "+horasalida+":"+minutos+":"+segundos);
              
      return horasalida;
  }
  }
  return 0;
  }
  
  }
  
   
   


