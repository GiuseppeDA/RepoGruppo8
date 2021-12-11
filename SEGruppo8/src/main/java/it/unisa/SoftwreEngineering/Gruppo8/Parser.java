/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import it.unisa.SoftwreEngineering.Gruppo8.command.DividerCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.AdderCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.ClearerCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.DropperCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.DuplerCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.InserterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.InverterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.MultiplierCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.OvererCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.SqrterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.SubtracterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.VariableGetterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.VariableSetterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.VariableSubtracterCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.SwapperCommand;
import it.unisa.SoftwreEngineering.Gruppo8.command.VariableAdderCommand;
import com.vm.jcomplex.Complex;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;

/**
 *
 * @author 39324
 */
public class Parser {
    private Calculator calc;
    private Variables var;

    /**
     *
     * @param calc
     * @param var
     */
    public Parser(Calculator calc, Variables var) {
        this.calc = calc;
        this.var = var;
    }

    /**
     *restituisce il comando corrispondente a quello scritto su una stringa
     * @param s1 la stringa in cui è scritto il comando
     * @return il comando corrispondente a ciò scritto nella stringa o null se non era valido
     */
    public Command parse(String s1) {
     
      String s = s1.replaceAll("\\s+","");
      Command c;
      c=isNumber(s);
      if (c!=null)
          return c;
      
      c=isOperation(s);
      if (c!=null)
        return c;
      c=isVarOperation(s);
      return c;
      
      }
      
    /**
     *restituisce un comando di inserimento di un nemero complesso a partire da una stringa su cui è scritto il complex
     * @param s la stringa  su cui è scritto il complex
     * @return il comando di inserimento del numero complesso corrispondente alla stringa, null se non era valido
     */
    public Command isNumber(String s){
       s = s.replaceAll("\\s+","");
       Double realNum;
       Double imagNum;
       String optionalDecimalNumber = "[0-9]\\d*(\\.\\d+)?";
      
       String pattern = "(([+-])?" + optionalDecimalNumber + ")?(([+-])?(" + optionalDecimalNumber + ")?j)?";
      
       String complexPattern = "([+-])?" + optionalDecimalNumber + "[+-](" + optionalDecimalNumber + ")?j";
      
       String realPattern = "([+-])?" + optionalDecimalNumber;
      
       String imagPattern = "([+-])?(" + optionalDecimalNumber + ")?j";
       
       if(Pattern.matches(pattern, s)){ //significa che il valore inserito è accettabile
          
          StringTokenizer st = new StringTokenizer (s, "+-j", true);
          if(Pattern.matches(complexPattern, s)){ //significa che è un numero complesso completo
              String sa = st.nextToken();
              if (st.hasMoreTokens()) {
                if (sa.equals ("+")) sa = st.nextToken();
                if (sa.equals ("-")) sa = "-" + st.nextToken();
              } 
              realNum = Double.parseDouble (sa);
              
              sa = st.nextToken();
              if (st.hasMoreTokens()) {
                if (sa.equals ("+")){
                    sa = st.nextToken();
                    if (sa.equals("j"))
                        sa = "1";
                }    
                if (sa.equals ("-")){
                    sa = "-" + st.nextToken();
                    if (sa.equals("-j"))
                        sa = "-1";
                }
              }
 
              imagNum = Double.parseDouble (sa);
              return new InserterCommand(new ComplexNumber(realNum, imagNum),calc); 
          }
          else if(Pattern.matches(realPattern, s)){ //significa che è solo un numero reale
              String sa = st.nextToken();
              if (st.hasMoreTokens()) {
                if (sa.equals ("+")) sa = st.nextToken();
                if (sa.equals ("-")) sa = "-" + st.nextToken();
              } 
              realNum = Double.parseDouble (sa);
              
              return new InserterCommand(new ComplexNumber(realNum, 0.0),calc);
          }
          else if (Pattern.matches(imagPattern, s)){
              String sa = st.nextToken();
              if (st.hasMoreTokens()) {
                if (sa.equals ("+")){
                    sa = st.nextToken();
                    if (sa.equals("j"))
                        sa = "1";
                }    
                else if (sa.equals ("-")){
                    sa = "-" + st.nextToken();
                    if (sa.equals("-j"))
                        sa = "-1";
                }
              }
              if(sa.equals ("j"))
                    sa = "1";
              imagNum = Double.parseDouble (sa);
              return new InserterCommand(new ComplexNumber(0.0, imagNum),calc); 
          }
       }
       
       return null;
   }    
    
    
    
    
    private Command isOperation(String op){
        
            if(op.equals("+")){
               return new AdderCommand(calc);
            }
            else if(op.equals("-")){
               return new SubtracterCommand(calc);    
            }
            else if(op.equals("sqrt")){
               return new SqrterCommand(calc);    
            }
            else if(op.equals("*")){
               return new MultiplierCommand(calc);    
            }
            else if(op.equals("+-")){
               return new InverterCommand(calc);    
            }
            else if(op.equals("drop")){
               return new DropperCommand(calc);    
            }
            else if(op.equals("dup")){
               return new DuplerCommand(calc);    
            }
            else if(op.equals("over")){
               return new OvererCommand(calc);    
            }
            else if(op.equals("swap")){
               return new SwapperCommand(calc);    
            }
            else if(op.equals("clear")){
               return new ClearerCommand(calc);    
            }
            else if(op.equals("/")){
               return new DividerCommand(calc);    
            }
            return null;
                    
    }
    
    private Command isVarOperation(String op){
        String opVarUp = "[A-Z]";
        
        if(Pattern.matches(opVarUp,op.substring(1))){
            int index = new Variables().charToIndex(op.charAt(1));
            
            if(op.substring(0, 1).equals("<")){
               return new VariableGetterCommand(index,var,calc);
            }
            else if(op.substring(0, 1).equals(">")){
               return new VariableSetterCommand(index,var,calc);
                
            }
            else if(op.substring(0, 1).equals("-")){
                return new VariableSubtracterCommand(index,var,calc);
                
            }else if (op.substring(0, 1).equals("+")){
                return new VariableAdderCommand(index,var,calc);
                
            }     
        }
        return null;

    }
}
