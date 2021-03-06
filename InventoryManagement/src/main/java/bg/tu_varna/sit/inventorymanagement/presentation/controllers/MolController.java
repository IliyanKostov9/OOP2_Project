package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.MolService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static bg.tu_varna.sit.inventorymanagement.common.Constants.View.*;

public class MolController {
    Stage s = new Stage();

    private final MolService adminService=MolService.getInstance();

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
    private Button getByStatusButton;

    @FXML
    private Button getByTypeButton;

    public MolController(Stage stage){
        s=stage;
    }

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
    public void boardRegisterByUser(){
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
    public void getAllProductQueryByStatus(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STATUS_QUERY_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new ProductByStatusQueryController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getAllProductQueryByType(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(TYPE_QUERY_VIEW));
            Stage stage = new Stage();
            fxmlLoader.setController(new ProductByTypeQueryController(stage));
            Parent root3 = fxmlLoader.load();
            stage.setScene(new Scene(root3));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clientRegisterByUser(){
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
    public void productRegisterByUser(){
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
    public void conditionRegisterByUser(){
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
    public void logOutMol(){
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
