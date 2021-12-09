package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Product;
import bg.tu_varna.sit.inventorymanagement.data.repositories.ProductRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.ProductListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private final ProductRepository repositoryProduct = ProductRepository.getInstance();

    public static ProductService getInstance(){
        return ProductService.ProductServiceHolder.INSTANCE;
    }

    private static class ProductServiceHolder {
        public static final ProductService INSTANCE = new ProductService();
    }

    public void addTheProduct(ProductListViewModel p)
    {
         Product product=new Product(p.getDescription(),p.getProdType(),p.isProdStatus(),p.getDiscardDate(),p.getProductValue(),p.getExploatationStart(),p.isDiscarded(),p.getByCondition(),p.getByMol(),p.getByAmortization());
        repositoryProduct.save(product);

    }

    public Product listViewToEntity(ProductListViewModel p){
        Product temp = new Product(p.getIdInventoryNumber(),p.getDescription());
        List<Product> products = repositoryProduct.getAll();
        for (Product product: products) {
            if(product.equals(temp))
                return product;
        }
        return null;
    }


    public ObservableList<ProductListViewModel> getAllProducts() {
        List<Product> products = repositoryProduct.getAll();

        return FXCollections.observableList(
                products.stream().map(p -> new ProductListViewModel(
                       p.getIdInventoryNumber(),p.getDescription()
                )).collect(Collectors.toList()));
    }

}
