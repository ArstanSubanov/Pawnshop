package enums;

import model.Customer;
import model.Pawn;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public enum Singleton {
    INSTANCE;

    List<Pawn> pawns;
    public static int customerIdCounter;
    public static int productIdCounter;

    public static int pawnIdCounter = 0;

    public static final Scanner scanner = new Scanner(System.in);


    Singleton() {
        List<Pawn> list = new ArrayList<>();
        Customer customer = new Customer(1, "Tom Riddle");
        Pawn pawn = new Pawn(new Product(1, 1, "Gold Cup Hufflepuff", 20000), customer, 30);
        list.add(pawn);
        pawn = new Pawn(new Product(2, 1, "Gold Medallion", 10000), customer, 25);
        list.add(pawn);
        customer = new Customer(2, "Jack Sparrow");
        pawn = new Pawn(new Product(3, customer.getId(), "Aztec gold coin", 5000), customer, 60);
        list.add(pawn);
        pawn = new Pawn(new Product(4, customer.getId(), "Black Pearl", 50000), customer, 100);
        list.add(pawn);

        setCustomerIdCounter(list.stream().max((x, y)-> x.getCustomer().getId() - y.getCustomer().getId()).get().getCustomer().getId());
        setProductIdCounter(list.stream().max((x,y)-> x.getProduct().getId() - y.getProduct().getId()).get().getProduct().getId());
        setPawnIdCounter(list.stream().max((x,y)->x.getPawnId()-y.getPawnId()).get().getPawnId());

        setPawns(list);

    }

    public List<Pawn> getPawns() {
        return pawns;
    }

    public void setPawns(List<Pawn> pawns) {
        this.pawns = pawns;
    }

    public static void setCustomerIdCounter(int customerIdCounter) {
        Singleton.customerIdCounter = customerIdCounter;
    }

    public static void setProductIdCounter(int productIdCounter) {
        Singleton.productIdCounter = productIdCounter;
    }

    public static void setPawnIdCounter(int pawnIdCounter) {
        Singleton.pawnIdCounter = pawnIdCounter;
    }
}
