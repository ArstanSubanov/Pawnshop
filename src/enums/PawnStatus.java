package enums;

public enum PawnStatus {
    PLEDGE(1), PAID_OUT(2), OVERDUE(3), DECOMISSIONED(4), SOLD(5);

    final int id;

    PawnStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static PawnStatus getById(int id){
        for (PawnStatus status: values()){
            if (status.id == id)
                return status;
        }
        return null;
    }
}
