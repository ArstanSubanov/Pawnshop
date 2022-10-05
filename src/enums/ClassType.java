package enums;

import services.CustomerOperations;
import services.Operations;
import services.PawnOperations;
import services.ProductOperations;

public enum ClassType {
    CUSTOMER(1), PAWN(2), PRODUCT(3);
    int id;

    Operations operations;

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    ClassType(int id) {
        this.id = id;
        if (id == 1){
            Operations operations = new CustomerOperations();
            setOperations(operations);
        }else if (id == 2){
            Operations operations = new PawnOperations();
            setOperations(operations);
        } else if (id == 3) {
            Operations operations = new ProductOperations();
            setOperations(operations);
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
