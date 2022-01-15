package com.example.projetaslaks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class LoginPage extends Iletisim{
        @FXML
        AnchorPane root;
        @FXML
        Button loginButton;
        @FXML
        Button SigninButton;
        @FXML
        TextField userIDField;
        @FXML
        PasswordField userPasswordField;
        @FXML
        Label feedback;

        public void GirisYap(){
            String userID = userIDField.getText();
            String password = userPasswordField.getText();
            String sql = "SELECT telNo,sifre FROM musteri WHERE telNo = ?";
            try (Connection conn = this.Connect();
                 PreparedStatement pstmt  = conn.prepareStatement(sql)){
                pstmt.setString(1,userID);
                ResultSet rs  = pstmt.executeQuery();
                    if(Objects.equals(rs.getString("sifre"), password)){
                        AnaMenu();
                        feedback.setText("");
                    }else{
                        feedback.setText("Sifre Hatalı.");
                        userPasswordField.clear();
                    }
            } catch (SQLException | IOException e) {
                feedback.setText("Hatalı giris.");
                userIDField.clear();
                userPasswordField.clear();
            }
}
private void AnaMenu() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void UyeOl() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("UyeOl.fxml"));
        root.getChildren().setAll(pane);
    }}