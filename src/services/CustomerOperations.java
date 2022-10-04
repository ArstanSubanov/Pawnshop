package services;

import enums.OperationType;
import enums.Singleton;
import model.Customer;
import model.Pawn;

import java.util.List;
import java.util.Scanner;

public class CustomerOperations implements Operations{
    @Override
    public void execute(OperationType operationType, int id) {
        if (operationType == OperationType.GET){
            System.out.println(getCustomer(id));
        } else if (operationType == OperationType.DELETE) {
            deleteCustomer(id);
        } else if (operationType == OperationType.UPDATE){
            updateCustomer(id);
        } else if (operationType == OperationType.GET_ALL) {
            showProductsByCustomer(id);
        }else {
            System.out.println("This operation cannot be perform in Customer");
        }
    }

    private Customer getCustomer(int id){
        try {
            return Singleton.INSTANCE.getPawns().stream().filter(pawn -> pawn.getCustomer().getId()==id).findAny().get().getCustomer();
        }catch (NullPointerException e){
            System.out.println("Not found this Customer");
        }
        return null;
    }

    private void deleteCustomer(int id){
        Customer customer = getCustomer(id);
        Pawn pawn = Singleton.INSTANCE.getPawns().stream().filter(p -> p.getCustomer().equals(customer)).findAny().get();
        pawn.setCustomer(null);
    }

    private void updateCustomer(int id){
        Scanner scanner = Singleton.scanner;
        Customer customer = getCustomer(id);
        System.out.println("Insert pls new name: ");
        String name = scanner.next();
        customer.setName(name);
    }

    private void showProductsByCustomer(int id){
        List<Pawn> pawns = Singleton.INSTANCE.getPawns();
        for (Pawn pawn: pawns) {
            if (pawn.getCustomer().getId() == id){
                System.out.println(pawn.getProduct());
            }
        }
    }
}
