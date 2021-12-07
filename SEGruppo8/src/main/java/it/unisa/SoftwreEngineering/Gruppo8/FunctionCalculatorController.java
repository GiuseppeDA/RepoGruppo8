package it.unisa.SoftwreEngineering.Gruppo8;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mario
 */
public class FunctionCalculatorController extends CalculatorController {

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
    private Button FunButton;
    @FXML
    private TableView<?> functionTableView;
    @FXML
    private TableColumn<?, ?> functionName;

    @FXML
    public void insertComplex(ActionEvent event) {
    }

    @FXML
    public void add(MouseEvent event) {
    }

    @FXML
    public void subtract(MouseEvent event) {
    }

    @FXML
    public void sqrt(MouseEvent event) {
    }

    @FXML
    public void multiply(MouseEvent event) {
    }

    @FXML
    public void divide(MouseEvent event) {
    }

    @FXML
    public void invert(MouseEvent event) {
    }

    @FXML
    public void clear(MouseEvent event) {
    }

    @FXML
    public void drop(MouseEvent event) {
    }

    @FXML
    public void dup(MouseEvent event) {
    }

    @FXML
    public void swap(MouseEvent event) {
    }

    @FXML
    public void over(MouseEvent event) {
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

    @FXML
    private void changeToStandardController(ActionEvent event) {
        try {
            App.setRoot("standardCalculator");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
