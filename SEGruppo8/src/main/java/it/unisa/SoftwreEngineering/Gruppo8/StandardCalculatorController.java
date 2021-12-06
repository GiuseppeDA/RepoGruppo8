package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.vm.jcomplex.Complex;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class StandardCalculatorController implements Initializable{
    
    private Calculator calc = new Calculator();
    
    private Variables varList = new Variables();
    
    private String sizeMsg="Operandi non sufficienti!";
    
    private String inseMsg="Inserisci solo numeri e relativo segno!";
    
    private String divideeMsg="impossibile dividere per 0!"; 
    
    @FXML
    private ListView<Complex> memory;
    @FXML
    private TextField input;
    @FXML
    private Text screen;
    @FXML
    private Button insButton;
    @FXML
    private TableView<Variable> variables;
    @FXML
    private TableColumn<Variable, String> var;
    @FXML
    private TableColumn<Variable, Complex> value;
    
    ObservableList<Integer> selectedVarIndices;
    
    @FXML
    private Button setVarButton;
    @FXML
    private Button insertVarInStackButton;
    @FXML
    private Button addVarButton;
    @FXML
    private Button subVarButton;
    
    //Initializing
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        memory.setItems(calc.getMemory());
        
        memory.setStyle("-fx-font-size: 13px ;");
        
        memory.getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                if(memory.getItems().size() > 0)
                    screen.setText(memory.getItems().get(0).toString());
            }
        });
        
       
        input.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if(newPropertyValue)
                    insButton.setDefaultButton(true);
                else
                    insButton.setDefaultButton(false);
            }
        });
        
        
        //TableView
        
        var.setCellValueFactory( new PropertyValueFactory<>("name"));
        value.setCellValueFactory( new PropertyValueFactory<>("value"));
        
        variables.setItems(varList.getVariablesList());
        
        
        //Variables Buttons
        setVarButton.setDisable(true);
        insertVarInStackButton.setDisable(true);
        addVarButton.setDisable(true);
        subVarButton.setDisable(true);
        
        TableViewSelectionModel selectionModel = variables.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        
        selectedVarIndices = selectionModel.getSelectedIndices();

        selectedVarIndices.addListener(new ListChangeListener<Integer>() {
          @Override
          public void onChanged(Change<? extends Integer> change) {
                setVarButton.setDisable(false);
                insertVarInStackButton.setDisable(false);
                addVarButton.setDisable(false);
                subVarButton.setDisable(false);                 
              
               
          }
        });
        
        
    }
    
    @FXML
    private void insertComplex(ActionEvent event) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      Double realNum;
      Double imagNum;
        
      String s1 = input.getText();
      String s = s1.replaceAll("\\s+","");
      
      
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
              calc.insert(realNum, imagNum); 
          }
          else if(Pattern.matches(realPattern, s)){ //significa che è solo un numero reale
              String sa = st.nextToken();
              if (st.hasMoreTokens()) {
                if (sa.equals ("+")) sa = st.nextToken();
                if (sa.equals ("-")) sa = "-" + st.nextToken();
              } 
              realNum = Double.parseDouble (sa);
              
              calc.insert(realNum, 0.0);
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
              calc.insert(0.0, imagNum); 
          }
          
          input.setText("");
          
      }
      else if(isOperation(s)){
          input.setText("");
      }
      else if(isVarOperation(s)){
          input.setText("");
      }
      else{
          input.setText("");
          screen.setText("Syntax Error");
      }
      
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

    @FXML
    private void setVar(MouseEvent event) {
        varList.setVar(calc.removeTop(),selectedVarIndices.get(0));
    }

    @FXML
    private void insertVarInStack(MouseEvent event) {
        Variable v = varList.getVar(selectedVarIndices.get(0));
        
        calc.insert(v.getValue());
    }

    @FXML
    private void addVar(MouseEvent event) {
        varList.addVar(calc.getTop(), selectedVarIndices.get(0));
    }

    @FXML
    private void subVar(MouseEvent event) {
        varList.subVar(calc.getTop(), selectedVarIndices.get(0));
    }

    private boolean isOperation(String op) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        String operations[]= {"+", "-", "sqrt", "*", "+-", "drop", "dup", "over", "swap"};
        String methodName[]= {"add", "subtract", "sqrt", "multiply", "invert", "drop", "dup", "over", "swap"};
        
        int i;
        
        for(i=0;i<operations.length;i++){
            if(op.equals(operations[i]) == true){
                Object obj = calc.getClass().getDeclaredMethod(methodName[i]).invoke(calc);
                Boolean res = (Boolean) obj;
                if(res == false)
                    popupCaller(sizeMsg);
                return true;
            }
        }
        
        if(op.equals("/")){
            try {
                if(!calc.divide())
                    popupCaller(sizeMsg);
            } catch (ImpossibleDivisionException e) {
                popupCaller(divideeMsg);
            }
            return true;
        }
        
        if(op.equals("clear")){
            calc.clear();
            return true;
        }
            
        
        
        return false;
    }
    
    private boolean isVarOperation(String op){
 
        String opVarUp = "[a-zA-Z]";
        

        if(Pattern.matches(opVarUp,op.substring(1))){
            int index = varList.charToIndex(op.charAt(1));
            System.out.println(index);
            System.out.println(op);
            if(op.substring(0, 1).equals("<")){
                Variable v = varList.getVar(index);
        
                calc.insert(v.getValue());
                return true;
            }
            else if(op.substring(0, 1).equals(">")){
                varList.setVar(calc.removeTop(),index);
                return true;
            }
            else if(op.substring(0, 1).equals("-")){
                varList.subVar(calc.getTop(), index);
                return true;
            }else if (op.substring(0, 1).equals("+")){
                varList.addVar(calc.getTop(), index);
                return true;
            }
            
        }
        return false;
    }

    

}
