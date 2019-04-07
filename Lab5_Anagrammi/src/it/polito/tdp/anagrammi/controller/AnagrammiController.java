package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model=new Model();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInsert;

    @FXML
    private Button btnCalculate;

    @FXML
    private TextArea txtCorrect;

    @FXML
    private TextArea txtWrong;

    @FXML
    private Button btnReset;

    @FXML
    void doCalculate(ActionEvent event) {
    	txtWrong.clear();
    	txtCorrect.clear();
    	String input=txtInsert.getText().trim().toLowerCase();
    	if(!input.matches("[a-zA-Z]+")) {
    		txtCorrect.appendText("Formato non valido\n");
    		throw new InvalidParameterException();
    	}
    	model.genera(input);
    	model.controlloAnagramma(model.getSoluzioni());
    	for(String s:model.getGiuste()) {
    	txtCorrect.appendText(s+"\n");
    	}
    	for(String s1:model.getSbagliate()) {
    	txtWrong.appendText(s1+"\n");
 		}
    	model.getGiuste().clear();
    	model.getSbagliate().clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInsert.clear();
    	txtCorrect.clear();
    	txtWrong.clear();
    }

    @FXML
    void initialize() {
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalculate != null : "fx:id=\"btnCalculate\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    public void setModel(Model model) {
    	this.model=model;
    }
}
