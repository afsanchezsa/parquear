/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package becker;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author COMPAQ
 */
public class Admin extends Robot{
    private int[]zona1;
    private int[]zona2;
    private int[]zona3;
    public Admin(City city, int i, int i1, Direction drctn) {
        super(city, i, i1, drctn);
        this.zona1=new int[5];
        this.zona2=new int[5];
        this.zona3=new int[5];
    }
    public void retornar_inicio(){
    boolean nosur=false;
        int y=this.getStreet();
    int x=this.getAvenue();
    if(y<9){
    Direction direccion=this.getDirection();
    if(direccion!=Direction.SOUTH){
    nosur=true;
    }
    while(nosur){
    this.turnLeft();
    nosur=this.getDirection()!=Direction.SOUTH;
    }
    for(int i=y;i<9;i++){
    this.move();
    }
    }
    this.turnLeft();
    while(x<19){
    this.move();
    x=this.getAvenue();
    }
    this.turnLeft();
    this.turnLeft();
    }
    public void mirar_desocupado(){
    //for(int i=19;i>5;i--){
    this.move();
        this.move();
        this.move();
        this.move();
        this.move();
        this.move();
        this.move();
    if(this.getAvenue()==12||this.getAvenue()==8||this.getAvenue()==4){
    this.turnLeft();
    this.turnLeft();
    this.turnLeft();
    for(int j=0;j<5;j++){
    if(this.getAvenue()==12){
    this.move();
    zona3[j]=this.canPickThing()?1:0;
    }
    }
    this.salir_de_zona();
    this.turnLeft();
    this.turnLeft();
    this.turnLeft();
    this.move();
    this.move();
    this.move();
    this.move();
    if(this.getAvenue()==8){
    this.turnLeft();
    this.turnLeft();
    this.turnLeft();
    for(int j=0;j<5;j++){
    
    this.move();
    zona2[j]=this.canPickThing()?1:0;
    
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
    if(this.getAvenue()==4){
    this.turnLeft();
    this.turnLeft();
    this.turnLeft();
    for(int j=0;j<5;j++){
    
    this.move();
    zona1[j]=this.canPickThing()?1:0;
    
    }
    
    }
    this.salir_de_zona();
    
    }
    this.retornar_inicio();
   
    
    }
    public void salir_de_zona(){
    int x;
    x=this.getStreet();
    Direction direccion=this.getDirection();
    while(direccion!=Direction.SOUTH){
    this.turnLeft();
    direccion=this.getDirection();
    }
    while(x<9){
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
    public void parquear_en_la_zona(int zona){
        this.pickThing();
    if(zona==3){
    for(int i=0;i<7;i++){
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
    
    for(int i=0;i<6;i++){
    if(this.canPickThing()==false&&this.countThingsInBackpack()!=0){
    this.putThing();
    }else{
    this.move();
    }
    
    }
    }
    //------------------------------------------------------------------------
    if(zona==2){
    for(int i=0;i<11;i++){
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
    
    for(int i=0;i<6;i++){
    if(this.canPickThing()==false&&this.countThingsInBackpack()!=0){
    this.putThing();
    }else{
    this.move();
    }
    
    }
    }
    //-----------------------------------------
    if(zona==1){
    for(int i=0;i<15;i++){
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
    
    for(int i=0;i<6;i++){
    if(this.canPickThing()==false&&this.countThingsInBackpack()!=0){
    this.putThing();
    }else{
    this.move();
    }
    
    }
    }
    
    
    
    
    }
}
