package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.vm.jcomplex.Complex;
import java.io.File;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class StandardCalculatorController extends CalculatorController implements Initializable{
    

    private String sizeMsg="Operandi non sufficienti!";
    
    private String inseMsg="Inserisci solo numeri e relativo segno!";
    
    private String divideeMsg="impossibile dividere per 0!"; 
        
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
    private MenuItem restoreFunctionContextMenuItem1;
    @FXML
    private MenuItem runFunctionContextMenuItem1;
    @FXML
    private MenuItem showunctionContextMenuItem11;
    
   
    //Initializing
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        super.initialize(url, rb);
    }
    
    @FXML
    public void insertComplex(ActionEvent event) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
      Double realNum;
      Double imagNum;
        
      String s1 = this.getInput().getText();
      
      Parser parser = new Parser(getCalculator(),this.getVarList());
      Command c = parser.parse(s1);
     
        try {
            if(c != null)
                c.execute();
            else{        
                this.getScreen().setText("Syntax Error");
            }

        } catch (CommandExecuteException ex) {
           this.getScreen().setText("Syntax Error");
        }
      
      this.getInput().setText("");
    }
    
    
    @FXML
    @Override
    public void add(MouseEvent event) {
        if(!getCalculator().add())
            popupCaller(sizeMsg);
 
    }

    @FXML
    @Override
    public void subtract(MouseEvent event) {
        if(!getCalculator().subtract())
            popupCaller(sizeMsg);
    }

    @FXML
    @Override
    public void sqrt(MouseEvent event) {
        if(!getCalculator().sqrt())
            popupCaller(sizeMsg);
    }

    @FXML
    @Override
    public void multiply(MouseEvent event) {
        if(!getCalculator().multiply())
            popupCaller(sizeMsg);
    }

    @FXML
    @Override
    public void divide(MouseEvent event) {
        try {
            if(!getCalculator().divide())
                popupCaller(sizeMsg);
        } catch (ImpossibleDivisionException e) {
            popupCaller(divideeMsg);
        }
    }

    @FXML
    @Override
    public void invert(MouseEvent event) {
        if(!getCalculator().invert())
            popupCaller(sizeMsg);
    }
    
    @FXML
    @Override
    public void clear(MouseEvent event){
        getCalculator().clear();
    }
    
    @FXML
    @Override
    public void drop(MouseEvent event){
        if(!getCalculator().drop())
            popupCaller(sizeMsg);
    }
    
    @FXML
    @Override
    public void dup(MouseEvent event){
        if(!getCalculator().dup())
            popupCaller(sizeMsg);
    }
    
    @FXML
    @Override
    public void over(MouseEvent event){
        if(!getCalculator().over())
          popupCaller(sizeMsg);
    }
    
    @FXML
    @Override
    public void swap(MouseEvent event){
        if(!getCalculator().swap())
          popupCaller(sizeMsg);
    }
    
    private void popupCaller(String msg){
        PopupController.display(msg);
    }

    @FXML
    @Override
    public void setVar(MouseEvent event) {
        this.getVarList().setVar(getCalculator().removeTop(),selectedVarIndices.get(0));
    }

    @FXML
    public void insertVarInStack(MouseEvent event) {
        Variable v = this.getVarList().getVar(selectedVarIndices.get(0));       
        getCalculator().insert(v.getValue());
    }

    @FXML
    public void addVar(MouseEvent event) {
        this.getVarList().addVar(getCalculator().getTop(), selectedVarIndices.get(0));
    }

    @FXML
    public void subVar(MouseEvent event) {
        this.getVarList().subVar(getCalculator().getTop(), selectedVarIndices.get(0));
    }

    @FXML
    private void changeToFunctionController(ActionEvent event) {
        
        SingletonCalculatorController scc = SingletonCalculatorController.getIstance();
        scc.setCalculator(this.getCalculator());
        scc.setVariables(this.getVarList());
        scc.setFunctions(this.getFunctions());
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("functionCalculator.fxml"));
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
    public void modifyFunction(ActionEvent event) {
        super.modifyFunction(event);
    }

    @FXML
    public void deleteFunction(ActionEvent event) {
        super.deleteFunction(event);
    }

    @FXML
    public void saveFunction(ActionEvent event) {
        super.saveFunction(event);
    }

    @FXML
    public void restoreFunction(ActionEvent event) {
        super.restoreFunction(event);
    }

    @FXML
    @Override
    public void runFunction(ActionEvent event) {
        super.runFunction(event);
    }

    @FXML
    @Override
    public void showFunction(ActionEvent event) {
        super.showFunction(event);
    }
    
    
}
