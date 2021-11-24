/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;
import com.vm.jcomplex.Complex;
import java.lang.UnsupportedOperationException;
import java.util.Stack;
/**
 *
 * @author 39324
 */
public class Calculator {
    private Stack<Complex> memory;

    public Calculator() {
        memory = new Stack<>();
    }

    
    /**
     *Somma i primi due valori in memoria
     * @return true se l'operazione di addizione è andata a buon fine false altrimenti
     */
    public boolean add(){
        if(!checkSize(2))
            return false;
        Complex a=memory.pop();
        Complex b=memory.pop(); 
        Complex c= a.add(b);
        insert(c);
        return true;
    }

    /**
     *Sottrae l'ultimo numero inserito al penultimo numero inserito.
     * @return true se l'operazione di sottrazione è andata a buon fine false altrimenti
     */
    public boolean subcract(){
         if(!checkSize(2))
            return false;
        Complex a=memory.pop();
        Complex b=memory.pop();            
        Complex c=b.subtract(a);
        insert(c);
        return true;
    }

    /**
     *Moltiplica i primi due valori in memoria
     * @return true se l'operazione di moltiplicazione è andata a buon fine false altrimenti
     */
    public boolean multiply(){
         if(!checkSize(2))
            return false;
        Complex a=memory.pop();
        Complex b=memory.pop();            
        Complex c=a.multiply(b);
        insert(c);
        return true;
    }

    /**
     *
     */
    public boolean divide (){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    public boolean sqrt(){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     */
    public boolean invert (){
       if(!checkSize(1))
            return false;
        Complex a=memory.pop();
        Complex b=new Complex(-1);           
        Complex c=a.multiply(b);
        insert(c);
        return true;
    }

    /**
     *
     * @return l'oggetto Complex in cima alla memory
     */
    public ComplexNumber getTop(){
        return (ComplexNumber)memory.peek();
    }

    /**
     *
     * @param a è il numero minimo di oggetti che devono essere presenti nello stack
     * @return true se il numero di oggetti in memoria non è minore di a, ritorna false se a è negativo o se il numero di operandi è insufficiente
     */
    protected boolean checkSize(int a){
        if (a<=0)
            return false;
        return memory.size()>=a;
    }

    /**
     *
     * @param real la parte reale del numero complesso da inserire
     * @param img la parte immaginaria del numero complesso da inserire
     */
    public void insert(double real ,double img){
        Complex c=new ComplexNumber(real,img);
        memory.push(c);
    } 

    /**
     *
     * @param x
     */
    public void insert (Complex x){
        Complex c=new ComplexNumber(x.getReal(),x.getImaginary());
        memory.push(c);
    }
}