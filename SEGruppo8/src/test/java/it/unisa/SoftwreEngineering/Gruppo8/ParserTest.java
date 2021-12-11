/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author simon
 */
public class ParserTest {
    
    public ParserTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of parse method, of class Parser.
     */
    @Test
    public void testParse() {
        System.out.println("parse");
        Calculator calc = new Calculator();
        Variables var = new Variables();
        Parser instance = new Parser(calc,var);
        
        String s1 = "+";
        Command expResult = new AdderCommand(calc);
        Command result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "-";
        expResult = new SubtracterCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "*";
        expResult = new MultiplierCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "/";
        expResult = new DividerCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "drop";
        expResult = new DropperCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "clear";
        expResult = new ClearerCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "dup";
        expResult = new DuplerCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "over";
        expResult = new OvererCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "+-";
        expResult = new InverterCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "sqrt";
        expResult = new SqrterCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "swap";
        expResult = new SwapperCommand(calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "<A";
        expResult = new VariableGetterCommand(0,var,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = ">A";
        expResult = new VariableSetterCommand(0,var,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "+A";
        expResult = new VariableAdderCommand(0,var,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "-A";
        expResult = new VariableSubtracterCommand(0,var,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "1";
        ComplexNumber c1 = new ComplexNumber(1,0);
        expResult = new InserterCommand(c1,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "3j";
        ComplexNumber c2 = new ComplexNumber(0,3);
        expResult = new InserterCommand(c2,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1 = "1+3j";
        ComplexNumber c3 = new ComplexNumber(1,3);
        expResult = new InserterCommand(c3,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
        
        s1= "a";
        expResult = null;
        result = instance.parse(s1);
        assertEquals(expResult, result);
        
        s1 = "1+3j+4";
        expResult = null;
        result = instance.parse(s1);
        assertEquals(expResult, result);
        
        s1 = "3+2";
        expResult = null;
        result = instance.parse(s1);
        assertEquals(expResult, result);
        
        s1 = "3j+4";
        expResult = null;
        result = instance.parse(s1);
        assertEquals(expResult, result);
        
        s1 = "+2-3j";
        ComplexNumber c4 = new ComplexNumber(2,-3);
        expResult = new InserterCommand(c4,calc);
        result = instance.parse(s1);
        assertEquals(expResult.toString(), result.toString());
    }
    
}
