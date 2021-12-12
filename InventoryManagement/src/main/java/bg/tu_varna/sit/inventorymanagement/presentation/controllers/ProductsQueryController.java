package bg.tu_varna.sit.inventorymanagement.presentation.controllers;

import bg.tu_varna.sit.inventorymanagement.business.services.ProductService;
import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ProductsQueryController implements Initializable {
    Stage s ;
    public ProductsQueryController(Stage stage){
        s=stage;
    }

    private final ProductService productService=ProductService.getInstance();

    @FXML
    private Button getProductsButton;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private TableView<ProductListViewModel> allProdTable;

    @FXML
    private TableColumn<ProductListViewModel, Integer> inventoryCol;

    @FXML
    private TableColumn<ProductListViewModel, String> descriptionCol;

    @FXML
    private TableColumn<ProductListViewModel, String> typeCol;

    @FXML
    private TableColumn<ProductListViewModel, Boolean> statCol;

    @FXML
    private TableColumn<ProductListViewModel, LocalDate> expCol;

    @FXML
    private TableColumn<ProductListViewModel, Double> valueCol;

    @FXML
    private TableColumn<ProductListViewModel, Mol> molCol;

    @FXML
    private TableColumn<ProductListViewModel, Amortization> amortCol;

    @FXML
    private TableColumn<ProductListViewModel, LocalDate> disCol;

    LocalDate myFromDate;
    LocalDate myToDate;

    @FXML
    public void getFromDate()
    {
        myFromDate=fromDate.getValue();
    }

    @FXML
    public void getToDate(){

        myToDate=toDate.getValue();
    }

    @FXML
    public void getAllProducts(){
        ObservableList<ProductListViewModel> productsInPeriod = productService.getAllProductsInPeriod(myFromDate, myToDate);
        allProdTable.setItems(productsInPeriod);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inventoryCol.setCellValueFactory(new PropertyValueFactory<>("idInventoryNumber"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("prodType"));
        statCol.setCellValueFactory(new PropertyValueFactory<>("prodStatus"));
        expCol.setCellValueFactory(new PropertyValueFactory<>("exploatationStart"));
        valueCol.setCellValueFactory(new PropertyValueFactory<>("productValue"));
        molCol.setCellValueFactory(new PropertyValueFactory<>("byMol"));
        amortCol.setCellValueFactory(new PropertyValueFactory<>("byAmortization"));
        disCol.setCellValueFactory(new PropertyValueFactory<>("discardDate"));
    }
}