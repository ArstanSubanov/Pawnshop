package services;

import enums.OperationType;
import enums.Singleton;
import model.Pawn;
import model.Product;

public class ProductOperations implements Operations {

    @Override
    public void execute(OperationType operationType, int id) {

            if (operationType == OperationType.GET) {
                System.out.println(getProduct(id));
            } else if (operationType == OperationType.DELETE) {
                deleteProduct(id);
            }else if (operationType == OperationType.UPDATE){
                updateProduct(id);
            }else {
                System.out.println("This operation cannot be perform in Product");
            }
    }

    public Product getProduct(int id) {
        try {
            return Singleton.INSTANCE.getPawns().stream().filter(pawn -> pawn.getProduct().getId() == id).findAny().get().getProduct();
        } catch (Exception e) {
            System.out.println("Product not found");
        }
        return null;
    }

    public void deleteProduct(int id) {
        Product product = getProduct(id);
        Pawn pawn = Singleton.INSTANCE.getPawns().stream().filter(p -> p.getProduct().equals(product)).findAny().get();
        pawn.setProduct(null);
    }

    public void updateProduct(int id) {
        Product product = getProduct(id);
        System.out.println("Insert pls new name: ");
        String name = Singleton.scanner.next();
        product.setName(name);
        System.out.println("Insert pls new price: ");
        double price = Singleton.scanner.nextDouble();
        product.setPrice(price);
    }

}
