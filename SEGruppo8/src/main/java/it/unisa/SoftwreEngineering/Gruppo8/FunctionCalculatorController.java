package it.unisa.SoftwreEngineering.Gruppo8;

import com.vm.jcomplex.Complex;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mario
 */
public class FunctionCalculatorController extends CalculatorController implements Initializable{
    
    
    @FXML
    private Button STDButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    
    @FXML
    private ContextMenu functionContextMenu;
    @FXML
    private MenuItem modifyFunctionContextMenuItem;
    @FXML
    private MenuItem deleteFunctionContextMenuItem;
    @FXML
    private MenuItem restoreFunctionContextMenuItem;
    @FXML
    private ListView<?> memory;
    @FXML
    private TextField input;
    @FXML
    private Button insButton;
    @FXML
    private Text screen;
    @FXML
    private Button setVarButton;
    @FXML
    private Button insertVarInStackButton;
    @FXML
    private Button addVarButton;
    @FXML
    private Button subVarButton;
    @FXML
    private TableView<?> varTableView;
    @FXML
    private TableColumn<?, ?> varName;
    @FXML
    private TableColumn<?, ?> varValue;
    @FXML
    private TableView<?> functionTableView;
    @FXML
    private MenuItem showFunctionContextMenuItem1;
    @FXML
    private MenuItem modifyFunctionContextMenuItem1;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
    }
    
    @FXML
    public void insertComplex(ActionEvent event) {
        
        //DA SCRIVERE MEGLIO PER GESTIRE: NOME GIA PRESENTE E FUNZIONE NON CORRETTA
        
        Dialog dialog = new TextInputDialog();
        dialog.setHeaderText("Inserisci il nome dell'operazione.");
        Optional<String> funName;
        
        Boolean result = true;
        
        do {
            funName = dialog.showAndWait();
         if(funName.isPresent()){
            try {
                this.getFunctions().stringToFunction(funName.get(), this.getInput().getText());
                
                this.getInput().setText("");
                result = false;
            } catch (InvalidCommandException ex) {
                this.getScreen().setText("Syntax Error");
                result = false;
            } catch (FunctionDuplicateException ex) {
                dialog.setHeaderText("Nome di funzione gia esistente!");
                result = true;
            } 
         }else{
             result = false;
         }
        } while (result);
        
        
    }

    @FXML
    public void add(MouseEvent event) {
        this.getInput().appendText("+ ");
    }

    @FXML
    public void subtract(MouseEvent event) {
        this.getInput().appendText("- ");
    }

    @FXML
    public void sqrt(MouseEvent event) {
        this.getInput().appendText("sqrt ");
    }

    @FXML
    public void multiply(MouseEvent event) {
        this.getInput().appendText("* ");
    }

    @FXML
    public void divide(MouseEvent event) {
        this.getInput().appendText("/ ");
    }

    @FXML
    public void invert(MouseEvent event) {
        this.getInput().appendText("+- ");
    }

    @FXML
    public void clear(MouseEvent event) {
        this.getInput().appendText("clear ");
    }

    @FXML
    public void drop(MouseEvent event) {
        this.getInput().appendText("drop ");
    }

    @FXML
    public void dup(MouseEvent event) {
        this.getInput().appendText("dup ");
    }

    @FXML
    public void swap(MouseEvent event) {
        this.getInput().appendText("swap ");
    }

    @FXML
    public void over(MouseEvent event) {
        this.getInput().appendText("over ");
    }

    @FXML
    public void setVar(MouseEvent event) {
        if(selectedVarIndices.get(0) != null){   
            String str = ">"+getVarList().indexToChar(selectedVarIndices.get(0))+" ";           
            this.getInput().appendText(str);
        }
    }

    @FXML
    public void insertVarInStack(MouseEvent event) {
        if(selectedVarIndices.get(0) != null){   
            String str = "<"+getVarList().indexToChar(selectedVarIndices.get(0))+" ";           
            this.getInput().appendText(str);
        }
    }

    @FXML
    public void addVar(MouseEvent event) {
        if(selectedVarIndices.get(0) != null){   
            String str = "+"+getVarList().indexToChar(selectedVarIndices.get(0))+" ";           
            this.getInput().appendText(str);
        }
    }

    @FXML
    public void subVar(MouseEvent event) {
        if(selectedVarIndices.get(0) != null){   
            String str = "-"+getVarList().indexToChar(selectedVarIndices.get(0))+" ";           
            this.getInput().appendText(str);
        }
    }

    @FXML
    private void changeToStandardController(ActionEvent event) {
        SingletonCalculatorController scc = SingletonCalculatorController.getIstance();
        scc.setCalculator(this.getCalculator());
        scc.setVariables(this.getVarList());
        scc.setFunctions(this.getFunctions());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("standardCalculator.fxml"));
        try {
            root = loader.load();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void modifyFunction(ActionEvent event) {
        
        
        
    }

    @FXML
    private void deleteFunction(ActionEvent event) {
    }

    @FXML
    private void saveFunction(ActionEvent event) {
    }

    @FXML
    private void restoreFunction(ActionEvent event) {
    }

    @FXML
    @Override
    public void showFunction(ActionEvent event) {
        super.showFunction(event);
    }

    @FXML
    @Override
    public void runFunction(ActionEvent event) {
        super.runFunction(event);
    }




}
