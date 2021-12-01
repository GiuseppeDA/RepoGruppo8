package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.vm.jcomplex.Complex;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.ListChangeListener;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class StandardCalculatorController implements Initializable{
    
    private Calculator calc = new Calculator();
    
    private String sizeMsg="Operandi non sufficienti!";
    
    private String inseMsg="Inserisci solo numeri e relativo segno!";
    
    private String divideeMsg="impossibile dividere per 0!"; 
    
    @FXML
    private ListView<Complex> memory;
    @FXML
    private TextField input;
    @FXML
    private TextField imag;
    @FXML
    private Text screen;
    
    //Initializing
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        memory.setItems(calc.getMemory());
        
        
        memory.getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                if(memory.getItems().size() > 0)
                    screen.setText(memory.getItems().get(0).toString());
            }
        });
        
    }
    
    @FXML
    private void insertComplex(MouseEvent event) {
        
      String s1 = input.getText();
      String optionalDecimalNumber = "[0-9]\\d*(\\.\\d+)?";
      
      String pattern = optionalDecimalNumber + "([+-]" + optionalDecimalNumber + "i)?";

      boolean matches = Pattern.matches(pattern, s1);

      System.out.println("matches = " + matches);
      
      calc.insert(Double.valueOf(s1), 0.0);
      
      
      /*
      
      double a = 0.0;
      double b = 0.0;
      StringTokenizer st = new StringTokenizer (s, "+-j", true);
      if (st.hasMoreTokens()) {
         String sa = st.nextToken().trim();
         System.out.println(sa);
         if (st.hasMoreTokens()) {
            if (sa.equals ("+")) sa = st.nextToken().trim();
            if (sa.equals ("-")) sa = "-" + st.nextToken().trim();
            if (sa.equals ("j")) System.out.println("Mario"); //throw new IllegalArgumentException(s + " is not a complex number");
         } 
         a = Double.parseDouble (sa);
         if (st.hasMoreTokens()) {
            String sb = st.nextToken().trim();
            if (st.hasMoreTokens()) {
               if (sb.equals ("+")) sb = st.nextToken().trim();
               if (sb.equals ("-")) sb = "-" + st.nextToken().trim();
            }
            b = Double.parseDouble (sb);
         }
         if (st.hasMoreTokens()) {
            String si = st.nextToken().trim();
            if (!si.equals ("j"))
               System.out.println("Mario");
               //throw new IllegalArgumentException(s + " is not a complex number");
            if (st.hasMoreTokens())
                System.out.println("Mario");
               //throw new IllegalArgumentException(s + " is not a complex number");
         } else
             System.out.println("Mario");
            //throw new IllegalArgumentException (s + " is not a complex number");
      } else 
         System.out.println("Mario");
         //throw new IllegalArgumentException (s + " is not a complex number");
        
        calc.insert(a, b);
            
        input.setText("");
        */
        /*
        
        Double realNum;
        Double imagNum;
        
        try {
            if(input.getText() == null || input.getText().trim().isEmpty())
                realNum = 0.0;
            else
                realNum = Double.parseDouble(input.getText());
            
            if(imag.getText() == null || imag.getText().trim().isEmpty())
                imagNum = 0.0;
            else
                imagNum = Double.parseDouble(imag.getText());
                 
            calc.insert(realNum, imagNum);
            
            input.setText("");
            imag.setText("");
   
        }catch(NumberFormatException exc){
                input.setText("");
                imag.setText("");
                popupCaller(inseMsg);
        }*/

    }
    
    @FXML
    private void add(MouseEvent event) {
        if(!calc.add())
            popupCaller(sizeMsg);
    }

    @FXML
    private void subtract(MouseEvent event) {
        if(!calc.subtract())
            popupCaller(sizeMsg);
    }

    @FXML
    private void sqrt(MouseEvent event) {
        if(!calc.sqrt())
            popupCaller(sizeMsg);
    }

    @FXML
    private void multiply(MouseEvent event) {
        if(!calc.multiply())
            popupCaller(sizeMsg);
    }

    @FXML
    private void divide(MouseEvent event) {
        try {
            if(!calc.divide())
                popupCaller(sizeMsg);
        } catch (ImpossibleDivisionException e) {
            popupCaller(divideeMsg);
        }
    }

    @FXML
    private void invert(MouseEvent event) {
        if(!calc.invert())
            popupCaller(sizeMsg);
    }
    
    @FXML
    private void clear(MouseEvent event){
        calc.clear();
    }
    
    @FXML
    private void drop(MouseEvent event){
        if(!calc.drop())
            popupCaller(sizeMsg);
    }
    
    @FXML
    private void dup(MouseEvent event){
        if(!calc.dup())
            popupCaller(sizeMsg);
    }
    
    @FXML
    private void over(MouseEvent event){
        if(!calc.over())
          popupCaller(sizeMsg);
    }
    
    @FXML
    private void swap(MouseEvent event){
        if(!calc.swap())
          popupCaller(sizeMsg);
    }
    
    private void popupCaller(String msg){
        PopupController.display(msg);
    }

}
