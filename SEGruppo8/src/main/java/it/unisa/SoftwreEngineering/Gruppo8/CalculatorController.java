/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 *
 * @author mario
 */
public abstract class CalculatorController implements Initializable{
    
    private Calculator calculator = new Calculator();
    
    private Variables varList = new Variables();
    
    private Functions functions;
    
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
    
    ObservableList<Integer> selectedFunIndices;
    
    @FXML
    private AnchorPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //ATTRIBUTES INITIALIZE
        SingletonCalculatorController scc = SingletonCalculatorController.getIstance();
        if(scc.getCalculator() != null){
            setCalculator(scc.getCalculator());
        }
        
        if(scc.getVariables() != null){
            setVarList(scc.getVariables());
        }
        functions = new Functions(calculator,varList);
        if(scc.getFunctions() != null){
            setFunctions(scc.getFunctions());
        }
        //END ATTRIBUTES INITIALIZE
        
        //------------------------------------------------------------------------------------------//
        
        //MEMORY INITIALIZE
        setMemory(getCalculator().getMemory());
        
        getMemory().setStyle("-fx-font-size: 13px ;");
        
        getMemory().getItems().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                if(getMemory().getItems().size() > 0)
                    screen.setText(getMemory().getItems().get(0).toString());
            }
        });
        //END MEMORY INITIALIZE
        
        //------------------------------------------------------------------------------------------//
        
        //INSERT BUTTON INITIALIZE
        input.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean oldPropertyValue, Boolean newPropertyValue) {
                if(newPropertyValue)
                    insButton.setDefaultButton(true);
                else
                    insButton.setDefaultButton(false);
            }
        });
        //INSERT BUTTON INITIALIZE
        
        //------------------------------------------------------------------------------------------//
        
        //FUNCTIONS TABLEVIEW INITIALIZE
        varName.setCellValueFactory( new PropertyValueFactory<>("name"));
        varValue.setCellValueFactory( new PropertyValueFactory<>("value"));       
        varTableView.setItems(varList.getVariablesList());
        //END FUNCTIONS TABLEVIEW INITIALIZE
        
        //------------------------------------------------------------------------------------------//
        
        //VARIABLES BUTTON INITIALIZE
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
        //END VARIABLES BUTTON INITIALIZE
        
        //------------------------------------------------------------------------------------------//
        
        //FUNCTIONS TABLEVIEW INITIALIZE
        
        functionsKeyList = FXCollections.observableArrayList();
        functionsKeyList.addAll(functions.getMap().keySet());
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
        functionName = new TableColumn<>("Function");
        functionName.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue()));
        functionName.prefWidthProperty().bind(functionTableView.widthProperty().multiply(1));       
        functionTableView.getColumns().setAll(functionName);      
        functionTableView.setItems(functionsKeyList);
        //FUNCTIONS TABLEVIEW INITIALIZE END
        
        //------------------------------------------------------------------------------------------//
        
        //FUNCTIONS TABLEVIEW SELECTION CHECK
        TableView.TableViewSelectionModel selectionFunModel = functionTableView.getSelectionModel();
        selectionFunModel.setSelectionMode(SelectionMode.SINGLE);
        
        selectedFunIndices = selectionFunModel.getSelectedIndices();

        selectedFunIndices.addListener(new ListChangeListener<Integer>() {
          @Override
          public void onChanged(ListChangeListener.Change<? extends Integer> change) {
              screen.setText(functions.getFunction(functionsKeyList.get(selectedFunIndices.get(0))).toString());
          }
        });
        //END FUNCTIONS TABLEVIEW SELECTION CHECK
       
        
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
    
    @FXML
    public void runFunction(ActionEvent event) {
                
        if(this.getFunctionsKeyList().get(selectedFunIndices.get(0)) != null)
            this.getFunctions().getFunction(this.getFunctionsKeyList().get(selectedFunIndices.get(0))).run();
            
        setCalculator(this.getFunctions().calc);
    }
    
    @FXML
    public void showFunction(ActionEvent event) {
        if(this.getFunctionsKeyList().get(selectedFunIndices.get(0)) != null)
            screen.setText(functions.getFunction(functionsKeyList.get(selectedFunIndices.get(0))).toString());
    }
    
    @FXML
    public void deleteFunction(ActionEvent event) {
        try {
            if(this.getFunctionsKeyList().get(selectedFunIndices.get(0)) != null){
                String funName = this.getFunctionsKeyList().get(selectedFunIndices.get(0));
                this.getFunctions().removeFunction(funName);
            }   
        } catch (NotExistingFunctionException ex) { 
            ex.printStackTrace();
        }
    }
    
    @FXML
    public void modifyFunction(ActionEvent event) {
        
        if(this.getFunctionsKeyList().get(selectedFunIndices.get(0)) != null){
            
            String funName = this.getFunctionsKeyList().get(selectedFunIndices.get(0));
            Dialog dialog = new TextInputDialog(this.getFunctions().getFunction(funName).toString());
            dialog.setHeaderText("Modifica la funzione.");
            Optional<String> fun;
            
            Boolean result = true;

            do {
                fun = dialog.showAndWait();
             if(fun.isPresent()){
                try {
                    
                    this.getFunctions().stringToFunctionReplace(funName, fun.get());

                    result = false;
                } catch (InvalidCommandException ex) {
                    dialog.setHeaderText("Syntax Error.");
                    result = true;
                }
             }else{
                 result = false;
             }
            } while (result);
        }

    }
    
    @FXML
    public void saveFunction(ActionEvent event) {
        FileChooser fc=new FileChooser();
        fc.setTitle("save");
        File file= fc.showSaveDialog(rootPane.getScene().getWindow());
        
        this.getFunctions().save(file.getAbsolutePath());
    }
    
    @FXML
    public void restoreFunction(ActionEvent event) {
        FileChooser fc=new FileChooser();
        fc.setTitle("save");
        File file= fc.showOpenDialog(rootPane.getScene().getWindow());
        
        this.getFunctions().restore(file.getAbsolutePath());
    }
    
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

    public Variables getVarList() {
        return varList;
    }

    public void setVarList(Variables varList) {
        this.varList = varList;
    }

    public Functions getFunctions() {
        return functions;
    }

    public void setFunctions(Functions functions) {
        this.functions = functions;
    }

    public ObservableList<String> getFunctionsKeyList() {
        return functionsKeyList;
    }

    public void setFunctionsKeyList(ObservableList<String> functionsKeyList) {
        this.functionsKeyList = functionsKeyList;
    }
    
    
}
