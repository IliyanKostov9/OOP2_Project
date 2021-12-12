package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.AdminService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.*;

public class AdminController {
    Stage s ;
    public AdminController(Stage stage){
        s=stage;
    }

    private final AdminService adminService=AdminService.getInstance();

    @FXML
    private Button logOutButton;
    @FXML
    private Button openRegisterCustomerButton;
    @FXML
    private Button openRegisterConditionButton;

    @FXML
    private Button openRegisterProductButton;
    @FXML
    private Button boardButton;

    @FXML
    private Button cusProdsQuery;

    @FXML
    private Button allProductQueryButton;



    @FXML
    public void cusProdsQueryOpen(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(BOARD_QUERY_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new CustomerProdsController(stage));
            Parent root4 = fxmlLoader.load();
            stage.setScene(new Scene(root4));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getAllProductQuery(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PRODUCT_QUERY_VIEW));
            Stage stage = new Stage();

            fxmlLoader.setController(new ProductsQueryController(stage));
            Parent root4 = fxmlLoader.load();
            stage.setScene(new Scene(root4));
            stage.setResizable(true);


            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void boardRegisterByAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(BOARD_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new CustomerBoardController(stage));
            Parent root4 = fxmlLoader.load();
            stage.setScene(new Scene(root4));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void clientRegisterByAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CUSTOMER_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new CustomerController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void productRegisterByAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PRODUCT_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new ProductController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void conditionRegisterByAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CONDITION_REGISTER_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new ConditionController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void logOutAdmin(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LOGIN_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new LoginController(stage));
            Parent root1 = fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
