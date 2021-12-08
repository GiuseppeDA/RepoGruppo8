/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author mario
 */
public abstract class CalculatorController implements Initializable{
    
    private Calculator calculator = new Calculator();
    
    private Variables varList = new Variables();
    
    private Functions functions = new Functions(calculator,varList);
    
    private ObservableList<String> functionsKeyList;
    
    @FXML
    private ListView<Complex> memory;
    @FXML
    private TextField input;
    @FXML
    private Text screen;
    @FXML
    private Button insButton;
    @FXML
    private TableView<Variable> varTableView;
    @FXML
    private TableColumn<Variable, String> varName;
    @FXML
    private TableColumn<Variable, Complex> varValue;
    
    ObservableList<Integer> selectedVarIndices;
    
    @FXML
    private Button setVarButton;
    @FXML
    private Button insertVarInStackButton;
    @FXML
    private Button addVarButton;
    @FXML
    private Button subVarButton;
    @FXML
    private TableView<String> functionTableView;
    @FXML
    private TableColumn<String, String> functionName;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SingletonCalculatorController scc = SingletonCalculatorController.getIstance();
        if(scc.getCalculator() != null){
            setCalculator(scc.getCalculator());
        }
        
        if(scc.getVariables() != null){
            setVarList(scc.getVariables());
        }
        
        
        setMemory(getCalculator().getMemory());
        
        getMemory().setStyle("-fx-font-size: 13px ;");
        
        getMemory().getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                if(getMemory().getItems().size() > 0)
                    screen.setText(getMemory().getItems().get(0).toString());
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
        
        //Variables TableView
        varName.setCellValueFactory( new PropertyValueFactory<>("name"));
        varValue.setCellValueFactory( new PropertyValueFactory<>("value"));
        
        varTableView.setItems(varList.getVariablesList());
        
        
        //Variables Buttons
        setVarButton.setDisable(true);
        insertVarInStackButton.setDisable(true);
        addVarButton.setDisable(true);
        subVarButton.setDisable(true);
        
        TableView.TableViewSelectionModel selectionModel = varTableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        
        selectedVarIndices = selectionModel.getSelectedIndices();

        selectedVarIndices.addListener(new ListChangeListener<Integer>() {
          @Override
          public void onChanged(ListChangeListener.Change<? extends Integer> change) {
                setVarButton.setDisable(false);
                insertVarInStackButton.setDisable(false);
                addVarButton.setDisable(false);
                subVarButton.setDisable(false);                 
          }
        });
        
        
        //Functions TableView
        
        functionsKeyList = FXCollections.observableArrayList();
        
        functions.getMap().addListener((MapChangeListener.Change<? extends String, ? extends Function> change) -> {
                boolean removed = change.wasRemoved();
                if (removed != change.wasAdded()) {
                    // no put for existing key
                    if (removed) {
                        functionsKeyList.remove(change.getKey());
                    } else {
                        functionsKeyList.add(change.getKey());
                    }
    }
            });
        
        
        functionName = new TableColumn<>("Key");
        // display item value (= constant)
        functionName.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue()));
        functionName.prefWidthProperty().bind(functionTableView.widthProperty().multiply(1));

        
        functionTableView.getColumns().setAll(functionName);
        
        functionTableView.setItems(functionsKeyList);
    }
    
    @FXML
    public abstract void insertComplex(ActionEvent event) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
    
    @FXML
    public abstract void add(MouseEvent event);
        
    @FXML
    public abstract void subtract(MouseEvent event);
    
    @FXML
    public abstract void sqrt(MouseEvent event);

    @FXML
    public abstract void multiply(MouseEvent event);

    @FXML
    public abstract void divide(MouseEvent event);

    @FXML
    public abstract void invert(MouseEvent event);
    
    @FXML
    public abstract void clear(MouseEvent event);
    
    @FXML
    public abstract void drop(MouseEvent event);
    
    @FXML
    public abstract void dup(MouseEvent event);
    
    @FXML
    public abstract void over(MouseEvent event);
    
    @FXML
    public abstract void swap(MouseEvent event);

    @FXML
    public abstract void setVar(MouseEvent event);

    @FXML
    public abstract void insertVarInStack(MouseEvent event);

    @FXML
    public abstract void addVar(MouseEvent event);

    @FXML
    public abstract void subVar(MouseEvent event);
    
    public ListView<Complex> getMemory() {
        return memory;
    }

    public void setMemory(ObservableList<Complex> memory) {
        this.memory.setItems(memory);
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public TextField getInput() {
        return input;
    }

    public void setInput(TextField input) {
        this.input = input;
    }

    public Text getScreen() {
        return screen;
    }

    public void setScreen(Text screen) {
        this.screen = screen;
    }

    public Button getInsButton() {
        return insButton;
    }

    public void setInsButton(Button insButton) {
        this.insButton = insButton;
    }

    public TableView<Variable> getVarTableView() {
        return varTableView;
    }

    public void setVarTableView(TableView<Variable> varTableView) {
        this.varTableView = varTableView;
    }

    public TableColumn<Variable, String> getVarName() {
        return varName;
    }

    public void setVarName(TableColumn<Variable, String> varName) {
        this.varName = varName;
    }

    public TableColumn<Variable, Complex> getVarValue() {
        return varValue;
    }

    public void setVarValue(TableColumn<Variable, Complex> varValue) {
        this.varValue = varValue;
    }

    public ObservableList<Integer> getSelectedVarIndices() {
        return selectedVarIndices;
    }

    public void setSelectedVarIndices(ObservableList<Integer> selectedVarIndices) {
        this.selectedVarIndices = selectedVarIndices;
    }

    public Button getSetVarButton() {
        return setVarButton;
    }

    public void setSetVarButton(Button setVarButton) {
        this.setVarButton = setVarButton;
    }

    public Button getInsertVarInStackButton() {
        return insertVarInStackButton;
    }

    public void setInsertVarInStackButton(Button insertVarInStackButton) {
        this.insertVarInStackButton = insertVarInStackButton;
    }

    public Button getAddVarButton() {
        return addVarButton;
    }

    public void setAddVarButton(Button addVarButton) {
        this.addVarButton = addVarButton;
    }

    public Button getSubVarButton() {
        return subVarButton;
    }

    public void setSubVarButton(Button subVarButton) {
        this.subVarButton = subVarButton;
    }



    public Variables getVarList() {
        return varList;
    }

    public void setVarList(Variables varList) {
        this.varList = varList;
    }
    
    
}
