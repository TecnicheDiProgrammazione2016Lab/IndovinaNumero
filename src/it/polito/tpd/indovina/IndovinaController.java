package it.polito.tpd.indovina;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class IndovinaController {
	
	// numero da indovinare
	private int segreto ;
	
	// numero di tentativi fatti
	private int tentativi ;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInizio;

    @FXML
    private TextField txtGuess;

    @FXML
    private TextField txtTentativi;

    @FXML
    private Label txtMessaggio;

    @FXML
    private Button btnInserisci;

    @FXML
    void doIniziaPartita(ActionEvent event) {

    	this.segreto = (int)(Math.random()*100)+1 ;
    	this.tentativi = 0 ;
    	
    	txtMessaggio.setText("Buona partita") ;
    	txtTentativi.setText( Integer.toString(this.tentativi));
    }

    @FXML
    void doGuess(ActionEvent event) {
    	
    	int guess ;
    	try{
    		guess = Integer.parseInt(txtGuess.getText()) ;
    	}catch(NumberFormatException e) {
    		txtMessaggio.setText("Numero errato");
    		return ;
    	}
    	
    	this.tentativi++ ;
    	txtTentativi.setText(Integer.toString(this.tentativi));
    	
    	if( guess==segreto) {
    		// hai vinto!!
    		
    		txtMessaggio.setText("Hai vinto!") ;
    		
    	} else {
    		// non hai vinto :(
    		
    		if(guess > segreto) 
    			txtMessaggio.setText("Troppo alto") ;
    		else
    			txtMessaggio.setText("Troppo basso") ;
    	}

    }

    @FXML
    void initialize() {
        assert btnInizio != null : "fx:id=\"btnInizio\" was not injected: check your FXML file 'Indovina.fxml'.";
        assert txtGuess != null : "fx:id=\"txtGuess\" was not injected: check your FXML file 'Indovina.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Indovina.fxml'.";
        assert txtMessaggio != null : "fx:id=\"txtMessaggio\" was not injected: check your FXML file 'Indovina.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Indovina.fxml'.";

    }
}
