package enums;

import model.Customer;
import model.Item;
import model.Product;
import services.CustomerOperations;
import services.Operations;
import services.PawnOperations;
import services.ProductOperations;

public enum ClassType {
    CUSTOMER(1), PAWN(2), PRODUCT(3);
    int id;

    Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    ClassType(int id) {
        this.id = id;
        if (id == 1){
            Operations operations = new CustomerOperations();
            setItem(new Item<>(operations));
        }else if (id == 2){
            Operations operations = new PawnOperations();
            setItem(new Item<>(operations));
        } else if (id == 3) {
            Operations operations = new ProductOperations();
            setItem(new Item<>(operations));
        }

    }

    public static ClassType getClassType(int id){
        for (ClassType classType: values()){
            if (classType.id == id)
                return classType;
        }
        return null;
    }

    public static void showClassType(){
        for (ClassType classType: values()){
            System.out.println(classType.id +" "+ classType);
        }
    }


}
