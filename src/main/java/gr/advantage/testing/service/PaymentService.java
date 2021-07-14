package gr.advantage.testing.service;

public interface PaymentService {
    double balance();

    boolean deposit(double amount);

    boolean withdraw(double amount);


}
