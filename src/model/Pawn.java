package model;

import enums.PawnStatus;
import enums.Singleton;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Pawn {

    private int pawnId;
    private Product product;
    private Customer customer;
    private int period;
    private LocalDate startDate;
    private LocalDate endDate;

    private PawnStatus pawnStatus;

    public Pawn(Product product, Customer customer, int period) {

        this.product = product;
        this.customer = customer;
        this.period = period;

        LocalDate date = LocalDate.now();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, period);

        this.startDate = date;
        this.endDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.pawnStatus = PawnStatus.PLEDGE;
        this.pawnId = ++Singleton.pawnIdCounter;

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PawnStatus getPawnStatus() {
        return pawnStatus;
    }

    public void setPawnStatus(PawnStatus pawnStatus) {
        this.pawnStatus = pawnStatus;
    }

    public int getPawnId() {
        return pawnId;
    }

    public void setPawnId(int pawnId) {
        this.pawnId = pawnId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return period == pawn.period && Objects.equals(product, pawn.product) && Objects.equals(customer, pawn.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, customer, period);
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "pawnId=" + pawnId +
                ", product=" + product +
                ", customer=" + customer +
                ", period=" + period +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pawnStatus=" + pawnStatus +
                '}';
    }
}
