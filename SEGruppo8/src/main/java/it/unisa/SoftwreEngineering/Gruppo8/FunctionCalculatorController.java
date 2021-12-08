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
    private MenuItem saveFunctionContextMenuItem;
    @FXML
    private MenuItem saveFunctionContextMenuItem1;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        super.initialize(url, rb);
    }
    
    @FXML
    public void insertComplex(ActionEvent event) {
        
        //DA SCRIVERE MEGLIO PER GESTIRE: NOME GIA PRESENTE E FUNZIONE NON CORRETTA
        
        Dialog dialog = new TextInputDialog();
        dialog.setHeaderText("Inserisci il nome dell'operazione.");
        Optional<String> funName = dialog.showAndWait();
        
        if(funName.isPresent()){
            try {
                this.getFunctions().stringToFunction(funName.get(), this.getInput().getText());
            } catch (InvalidCommandException ex) {
                ex.printStackTrace();
            }

        }
              
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
        
    }

    @FXML
    public void insertVarInStack(MouseEvent event) {
    }

    @FXML
    public void addVar(MouseEvent event) {
    }

    @FXML
    public void subVar(MouseEvent event) {
    }

    private void changeToStandardController(ActionEvent event) {
        SingletonCalculatorController scc = SingletonCalculatorController.getIstance();
        scc.setCalculator(this.getCalculator());
        scc.setVariables(this.getVarList());
        
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
    private void changeToFunctionController(ActionEvent event) {
                SingletonCalculatorController scc = SingletonCalculatorController.getIstance();
        scc.setCalculator(this.getCalculator());
        scc.setVariables(this.getVarList());
        
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



    
}
