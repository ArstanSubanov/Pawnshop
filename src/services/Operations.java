package services;
import enums.OperationType;
import model.Item;

public interface Operations {
    void execute(OperationType operationType, int id);

}
