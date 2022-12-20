package com.example.proba1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButton;

    @FXML
    private Label lable_error;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    public void goToMenu() throws SQLException, ClassNotFoundException, IOException {
        String loginText = login.getText();
        String passText = password.getText();

        if (!loginText.equals("") && !passText.equals("")) {
            ConnectDB dbHandler = new ConnectDB();
            ResultSet result = dbHandler.getUser(loginText, passText);

            int count = 0;
            while (true) {
                if (!result.next())
                    break;
                count++;
            }
            if (count >= 1) {
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("test1.fxml")));
                Stage stage = (Stage) enterButton.getScene().getWindow();
                stage.setScene(new Scene(parent, 600, 400));
                stage.setResizable(false);
                stage.show();
            }
        } else lable_error.setText("Не все поля заполнены");
    }
}



    //функция для перехода на новое окно
//    public void goToHome() throws IOException {
//        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("test1.fxml")));
//        Stage stage = (Stage) enterButton.getScene().getWindow();
//        stage.setScene(new Scene(parent, 600, 400));
//        stage.setResizable(false);
//        stage.show();
//
//    }



