import enums.ClassType;
import enums.OperationType;
import enums.Singleton;
import services.Operations;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome!");
        boolean doOperation = true;
        int id = 0;
        while (doOperation){
            ClassType.showClassType();
            System.out.println("Pls choose your object type id: ");
            id = Singleton.scanner.nextInt();
            Operations operations = (Operations) ClassType.getClassType(id).getItem().getElement();
            OperationType.showOperation();
            System.out.println("Choose your operation type id: ");
            id = Singleton.scanner.nextInt();
            OperationType operationType = OperationType.getOperationType(id);
            System.out.println("Insert pls id: ");
            id = Singleton.scanner.nextInt();
            operations.execute(operationType, id);

            System.out.println("Do you wanna end? y/n");
            String status = Singleton.scanner.next();
            if (status.equals("n")) doOperation = false;

        }


    }
}