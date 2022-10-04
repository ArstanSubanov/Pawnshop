package services;

import enums.OperationType;
import enums.PawnStatus;
import enums.Singleton;
import model.Customer;
import model.Pawn;
import model.Product;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;

public class PawnOperations implements Operations{
    @Override
    public void execute(OperationType operationType, int id) {
        if (operationType == OperationType.GET){
            System.out.println(getPawn(id));
        } else if (operationType == OperationType.ADD) {
            addPawn(++Singleton.pawnIdCounter);
        } else if (operationType == OperationType.DELETE){
            deletePawn(id);
        } else if (operationType == OperationType.UPDATE){
            updatePawn(1);
        }else if (operationType == OperationType.CALCULATE){
            calculatePawn(id);
        }else if (operationType == OperationType.GET_ALL){
            showAll();
        }

    }

    private Pawn getPawn(int id){
        try {
            return Singleton.INSTANCE.getPawns().stream().filter(pawn -> pawn.getPawnId() == id).findAny().get();
        }catch (NullPointerException e){
            System.out.println("Not found this Pawn");
        }
        return null;
    }

    private void addPawn(int id){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        System.out.println("Insert Customer name: ");
        String name = Singleton.scanner.nextLine();
        Customer customer = new Customer(++Singleton.customerIdCounter, name);

        System.out.println("Insert Product name: ");
        name = Singleton.scanner.nextLine();
        System.out.println("Insert Product price: ");
        double price = Singleton.scanner.nextDouble();
        Product product = new Product(++Singleton.productIdCounter, Singleton.customerIdCounter, name, price);
        List<Pawn> pawns = Singleton.INSTANCE.getPawns();
        System.out.println("Insert period: ");
        int period = Singleton.scanner.nextInt();
        Pawn pawn = new Pawn(product, customer, period);
        pawns.add(pawn);
        Singleton.INSTANCE.setPawns(pawns);

    }

    private void deletePawn(int id){
        List<Pawn> pawns = Singleton.INSTANCE.getPawns();
        pawns.remove(getPawn(id));
        Singleton.INSTANCE.setPawns(pawns);
    }

    private void updatePawn(int id){
        Pawn pawn = getPawn(id);
        for (PawnStatus pawnStatus: PawnStatus.values()){
            System.out.println(pawnStatus.getId()+" "+pawnStatus);
        }
        System.out.println("Insert pls pawn status: ");
        int status = Singleton.scanner.nextInt();
        pawn.setPawnStatus(PawnStatus.getById(status));

    }

    private void calculatePawn(int id){
        Pawn pawn = getPawn(id);

        int period = Period.between(pawn.getStartDate(), LocalDate.now()).getDays();
        double result = 0;
        double price = pawn.getProduct().getPrice();

        if (period<=pawn.getPeriod()){
            result = price + price/100*period;
        }else if (period> pawn.getPeriod()){
            double normalPrice = price + price/100*pawn.getPeriod();
            result = normalPrice + price/100*2*(period- pawn.getPeriod());
        }
        System.out.println("Total price  = "+ result);
    }

    private void showAll(){
        System.out.println(Singleton.INSTANCE.getPawns());
    }





}
