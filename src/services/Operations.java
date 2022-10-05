package services;
import enums.OperationType;

public interface Operations {
    void execute(OperationType operationType, int id);

}
