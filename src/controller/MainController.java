package controller;

import java.awt.datatransfer.*;
import java.awt.Toolkit;
import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import code.Cipher;



public class MainController implements Initializable {

    @FXML
    private CheckBox codeButton;

    @FXML
    private CheckBox decodeButton;

    @FXML
    private TextArea insertSentence;

    @FXML
    private TextArea insertKey;

    @FXML
    private Button startButton;
    
    @FXML
    private Button clearButton;
    
    @FXML
    private Button copyButton;

    @FXML
    private TextArea outputSentence;

    @FXML
    public void onCopyButton() {
    	String output = outputSentence.getText();
    	StringSelection stringSelection = new StringSelection(output);
    	Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
    	clpbrd.setContents(stringSelection, null);
    }
    
    @FXML
    public void onClearButton() {
    	codeButton.setSelected(false);
    	decodeButton.setSelected(false);
    	codeButton.setDisable(false);
    	decodeButton.setDisable(false);
    	insertSentence.clear();
    	insertKey.clear();
    	outputSentence.clear();
    }
    
    @FXML
    public void codeBlocker() {
    	boolean decodeCheckBox = decodeButton.isSelected();
        
        if(decodeCheckBox == true) codeButton.setDisable(true);
        	
        else codeButton.setDisable(false);
        	
    }
    
    @FXML
    public void decodeBlocker() {
    	boolean codeCheckBox = codeButton.isSelected();
        
        if(codeCheckBox == true) decodeButton.setDisable(true);
        	
        else decodeButton.setDisable(false);
        	
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean codeCheckBox = codeButton.isSelected();
                boolean decodeCheckBox = decodeButton.isSelected();
                int checkBox;
                if(codeCheckBox == true) {
                	checkBox = 1;
                	}
                else if(decodeCheckBox == true) {
                	checkBox = 2;
                	}
                else checkBox = 0;
                
                Cipher cipher = new Cipher();
                String sentence = ((insertSentence.getText()).toLowerCase()).trim();
                String key = (((insertKey.getText()).toLowerCase()).trim()).replace(" ", "");
                String result = cipher.runApplication(sentence, key, checkBox);
                outputSentence.setText(result);
            }
        });
    }
}
