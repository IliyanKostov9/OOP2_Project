package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.CustomerBoard;
import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.CustomerBoardRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.CustomerBoardListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerBoardService {
    private final CustomerBoardRepository repositoryCustomerBoard = CustomerBoardRepository.getInstance();
    private final ProductService productService=ProductService.getInstance();



    public static CustomerBoardService getInstance(){
        return CustomerBoardService.CustomerBoardServiceHolder.INSTANCE;
    }

    private static class CustomerBoardServiceHolder {
        public static final CustomerBoardService INSTANCE = new CustomerBoardService();
    }

    public boolean  returnTheProduct(CustomerBoardListViewModel cb) {
        CustomerBoard customerBoard=new CustomerBoard(cb.getIdCustomerBoard(),  cb.getByCustomer(),cb.getByInventoryNumber(),cb.getRegisteredDate(),cb.getReturnDate());
        List<CustomerBoard> customerBoards = repositoryCustomerBoard.getAll();
        for(CustomerBoard cusBoard: customerBoards)
        {
            if(cusBoard.equals(customerBoard) && cusBoard.getReturnDate()==null)
            {customerBoard.setPkCustomerBoard(cusBoard.getPkCustomerBoard());
                repositoryCustomerBoard.update(customerBoard);
            Product p=customerBoard.getByInventoryNumber();
            productService.changeStatus(p);
            return true;}
        }
        return false;
    }

    public ObservableList<CustomerBoardListViewModel> getProductsInPeriod(LocalDate myFromDate, LocalDate myToDate) {
        List<CustomerBoard> customerBoards = repositoryCustomerBoard.getAll();
        List<CustomerBoard> boardInPeriod = new ArrayList<>();
        for(CustomerBoard cb: customerBoards){
            if(cb.getRegisteredDate().isAfter(myFromDate) && cb.getRegisteredDate().isBefore(myToDate) )
            {
                boardInPeriod.add(cb);
            }
        }
        return FXCollections.observableList(
                boardInPeriod.stream().map(cb -> new CustomerBoardListViewModel(
                        cb.getByCustomer(),cb.getByInventoryNumber(),cb.getRegisteredDate(),cb.getReturnDate()
                )).collect(Collectors.toList()));
    }





    public int addToTheBoard(CustomerBoardListViewModel cb) {
       // List<CustomerBoard> customerBoards = repositoryCustomerBoard.getAll();
        CustomerBoard customerBoard=new CustomerBoard(cb.getByCustomer(),cb.getByInventoryNumber(),cb.getRegisteredDate(),cb.getReturnDate());
        int num;
        Product prod;
            num=customerBoard.getByInventoryNumber().getIdInventoryNumber();
            prod=productService.getProductById(num);
            if(!prod.isProdStatus())
            return 0;
            if(prod.isDiscarded())
                return 1;
        repositoryCustomerBoard.save(customerBoard);
        productService.changeStatus(prod);
        return 2;
    }




    public ObservableList<CustomerBoardListViewModel> getAllBoards(){
        List<CustomerBoard> customerBoards = repositoryCustomerBoard.getAll();

        return FXCollections.observableList(
                customerBoards.stream().map(cb -> new CustomerBoardListViewModel(
                        cb.getByCustomer(),cb.getByInventoryNumber(),cb.getRegisteredDate(),cb.getReturnDate()
                )).collect(Collectors.toList()));
    }
}
