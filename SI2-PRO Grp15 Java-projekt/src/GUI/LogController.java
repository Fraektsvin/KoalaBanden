/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * @author Jonas
 * @author Thomas
 * @author Viktoria
 * @author Alex
 * @author Antonio
 */
public class LogController implements Initializable {

    @FXML
    private JFXButton oplogbtn;
    @FXML
    private JFXTextArea logField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Scanner s = new Scanner(new File("LogFile.log")).useDelimiter("\\s");
            while (s.hasNext()) {
                if (s.hasNextInt()) { // check if next token is an int
                    logField.appendText(s.nextInt() + "\n"); // display the found integer
                } else {
                    logField.appendText(s.next() + " "); // else read the next token
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

}
