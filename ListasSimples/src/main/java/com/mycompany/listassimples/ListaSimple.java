/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listassimples;

import javax.swing.JOptionPane;

/**
 *
 * @author SCIS2-13
 */
public class ListaSimple {
    
    Nodo inicio;
    
    ListaSimple(){
    inicio=null;
    }
    
    public void insertarInicio(String name,int edad, int promedio){
    
    Nodo nuevo=new Nodo();
    
    nuevo.setNombre();
    nuevo.setEdad();
    nuevo.setPromedio();
    nuevo.setEnlace();
    
    if(inicio==null){JOptionPane.showMessageDialog(null,"La lista esta vacia");
    inicio=nuevo;
    }else{
        nuevo.setEnlace(inicio);
    inicio=nuevo;}
    }
    
    public void consultar(){
    Nodo temporal=inicio;
    if(inicio==null){
    JOptionPane.showMessageDialog(null, "La lista esta vacia");
    }else{
        
    do{JOptionPane.showMessageDialog(null, "Nombres: "+temporal.getNombre() + " La edad es: "
            + temporal.getEdad()+ " El promedio es: "+
            temporal.getPromedio());
    
    temporal=temporal.getEnlace();
    }while(temporal != null);
        
    
    }
    }
    
    public void insertarFinal(String name,int edad, int promedio){
    
    
    Nodo nuevo=new Nodo();
    
    nuevo.setNombre();
    nuevo.setEdad();
    nuevo.setPromedio();
    nuevo.setEnlace();
    
    if(inicio==null){JOptionPane.showMessageDialog(null,"La lista esta vacia");
    inicio=nuevo;
    }else{
        
        Nodo temporal = inicio;
        while(temporal!=null){
        temporal.getEnlace();
        }
        temporal.setEnlace(nuevo);
    }
        
    }
    
}
