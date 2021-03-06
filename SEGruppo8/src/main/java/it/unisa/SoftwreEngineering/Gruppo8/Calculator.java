/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;
import it.unisa.SoftwreEngineering.Gruppo8.exception.ImpossibleDivisionException;
import com.vm.jcomplex.*;
import static com.vm.jcomplex.Complex.NaN;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author 39324
 */
public class Calculator {
    private ObservableList<Complex> memory;

    public Calculator() {
        memory = FXCollections.observableArrayList();
    }

    public void setMemory(ObservableList<Complex> memory) {
        this.memory = memory;
    }
    
    /**
     *Somma gli ulltimi due valori in memoria
     * @return true se l'operazione di addizione è andata a buon fine false altrimenti
     */
    public boolean add(){
        if(!checkSize(2))
            return false;
        Complex a=removeTop();
        Complex b=removeTop(); 
        Complex c= a.add(b);
        insert(c);
        return true;
    }

    /**
     *Sottrae l'ultimo numero in memoria al penultimo numero in memoria.
     * @return true se l'operazione di sottrazione è andata a buon fine false altrimenti
     */
    public boolean subtract(){
         if(!checkSize(2))
            return false;
        Complex a=removeTop();
        Complex b=removeTop();            
        Complex c=b.subtract(a);
        insert(c);
        return true;
    }

    /**
     *Moltiplica gli ultimi  due numeri in memoria
     * @return true se l'operazione di moltiplicazione è andata a buon fine false altrimenti
     */
    public boolean multiply(){
         if(!checkSize(2))
            return false;
        Complex a=removeTop();
        Complex b=removeTop();            
        Complex c=a.multiply(b);
        insert(c);
        return true;
    }

    /**
     *Divide il penultimo numero in memoria per l'ultimo numero in memora
     * @throws ImpossibleDivisionException se effettua una disione per 0
     * @return true se l'operazione di divisione è andata a buon fine false altrimenti
     */
    public boolean divide () throws ImpossibleDivisionException{
        if(!checkSize(2))
            return false;
        Complex a=removeTop();
        Complex b=removeTop();            
        Complex c=b.divide(a);
        if(c==NaN){
            insert(b);
            insert(a);
            throw new ImpossibleDivisionException("Divisione per 0 non consentita");           
        }
        insert(c);
        return true;
    }

    /**
     *fa la radice quadrata dell'ultimo numero in memoria
     * @return true se l'operazione di radice quadrata è andata a buon fine false altrimenti
     */
    public boolean sqrt(){
       if(!checkSize(1))
            return false;
        Complex a=removeTop();            
        Complex c=a.sqrt();
        insert(c);
        return true;
    }

    /**
     *fa l'inverso dell'ultimo numero in memoria
     * @return true se l'inversione è andata a buon fine false altrimenti
     */
    public boolean invert (){
       if(!checkSize(1))
            return false;
        Complex a=removeTop();
        Complex b=new Complex(-1);           
        Complex c=a.multiply(b);
        insert(c);
        return true;
    }

    /**
     *
     * @return l'oggetto Complex in cima alla memory
     */
    public Complex getTop(){
        return memory.get(0);
    }
    
    public Complex getOver(){
        return memory.get(1);
    }

    /**
     *controlla se nella memory ci sono a elementi
     * @param a è il numero minimo di oggetti che devono essere presenti nello stack
     * @return true se il numero di oggetti in memoria non è minore di a, ritorna false se a è negativo o se il numero di operandi è insufficiente
     */
    protected boolean checkSize(int a){
        if (a<=0)
            return false;
        return memory.size()>=a;
    }

    /**
     *inserisce un numero complesso nella memory partendo da parte reale e immaginaria
     * @param real la parte reale del numero complesso da inserire
     * @param img la parte immaginaria del numero complesso da inserire
     */
    public void insert(double real ,double img){
        Complex c=new ComplexNumber(real,img);
        memory.add(0,c);
    } 

    /**
     *inserisce un numero complesso nella memory partendo da un istanza di Complex
     * @param x l'oggetto Complex da aggiungere
     */
    public void insert (Complex x){
       Complex c=new ComplexNumber(x.getReal(),x.getImaginary());
       memory.add(0,c);
    }
    
    public Complex removeTop(){
     return memory.remove(0);
    }

    public ObservableList<Complex> getMemory() {
        return memory;
    }
    
    /**
     *cancella l'ultimo elemento dalla memory
     * @return true se l'inversione è andata a buon fine false altrimenti
     */
    public boolean drop(){
         if(!checkSize(1))
            return false;
        removeTop();
        return true;
    }

    /**
     *svuota la memory
     */
    public void clear(){
        memory.clear();
    }

    /**
     *scambia l'ultimo e il penultimo elemento della memory
     * @return true se l'inversione è andata a buon fine false altrimenti
     */
    public boolean swap(){
        if(!checkSize(2))
            return false;
        Complex a=removeTop();
        Complex b=removeTop();            
        insert(a);
        insert(b);
        return true;
    }

    /**
     *pusha nella memory una copia del penultimo elemento 
     * @return true se l'inversione è andata a buon fine false altrimenti 
     */
    public boolean over(){
       if(!checkSize(2))
            return false;
        Complex a=memory.get(1);
        insert(a);
        return true;
    }

    /**
     *pusha nella memory una copia dell'ultimo elemento 
     * @return true se l'inversione è andata a buon fine false altrimenti
     */
    public boolean dup(){
       if(!checkSize(1))
            return false;
        Complex a=memory.get(0);
        insert(a);
        return true;
    }
}