package enums;

import services.Operations;

public enum OperationType {
    ADD(1), DELETE(2), GET(3), UPDATE(4), CALCULATE(5), GET_ALL(6);

    int id;

    OperationType(int id) {
        this.id = id;
    }

    public static OperationType getOperationType(int id){
        for (OperationType operationType: values()){
            if (operationType.id == id)
                return operationType;
        }
        return null;
    }

    public static void showOperation(){
        for (OperationType operationType: values()){
            System.out.println(operationType.id+" "+ operationType);
        }
    }
}
