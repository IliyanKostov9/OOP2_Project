package bg.tu_varna.sit.inventorymanagement.business.services;

import bg.tu_varna.sit.inventorymanagement.data.entities.Amortization;
import bg.tu_varna.sit.inventorymanagement.data.entities.Mol;
import bg.tu_varna.sit.inventorymanagement.data.repositories.AdminRepository;
import bg.tu_varna.sit.inventorymanagement.data.repositories.MolRepository;
import bg.tu_varna.sit.inventorymanagement.presentation.models.AmortizationListViewModel;
import bg.tu_varna.sit.inventorymanagement.presentation.models.MolListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class MolService {
    private final MolRepository repositoryMol = MolRepository.getInstance();

    public static MolService getInstance(){
        return MolService.MolServiceHolder.INSTANCE;
    }

    private static class MolServiceHolder {
        public static final MolService INSTANCE = new MolService();
    }

    public ObservableList<MolListViewModel> getAllMols(){
        List<Mol> amorts = repositoryMol.getAll();

        return FXCollections.observableList(
                amorts.stream().map(m -> new MolListViewModel(m.getUsername(),
                        m.getTelNum(),m.getEmail(),m.getUsername(),m.getPassword()
                )).collect(Collectors.toList()));
    }
}
