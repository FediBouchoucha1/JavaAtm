import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;

enum transTtpe{
    WITHDRAW,
    DEPOSIT
}

class transaction{

    private transTtpe type;
    private LocalDateTime dateTrans;

    public transaction(transTtpe type, LocalDateTime dateTrans) {
        this.type = type;
        this.dateTrans = dateTrans;
    }

    @Override
    public String toString() {
        return "transaction{" +
                "type=" + type +
                ", dateTrans=" + dateTrans +
                '}';
    }
}



public class User {

    private String name;
    private double balance;
    private int cardNumber;
    private int PinCode;
    private ArrayList<transaction> transactions=new ArrayList<transaction>();


    public User() {
    }
    public User(String name, double balance, int cardNumber, int pinCode) {
        super();
        this.name = name;
        this.balance = balance;
        this.cardNumber = cardNumber;
        PinCode = pinCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance<0)
            return;
        this.balance = balance;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        if(cardNumber<0)
                return;
        this.cardNumber = cardNumber;
    }

    public int getPinCode() {
        return PinCode;
    }

    public void setPinCode(int pinCode) {
        if(pinCode<0)
            return;
        PinCode = pinCode;
    }

    public void deposit(int amount )
    {
        if(amount<=0){
            System.out.println("please input a valid number");
            return;
        }
        balance+=amount;

        transactions.add(new transaction(transTtpe.DEPOSIT,LocalDateTime.now()));

    }

    public void withdraw(int amount )
    {
        if(balance<=0)
        {
            System.out.println("you are POOR , you can't withdraw ");
            return;
        }
        balance-=amount;
        transactions.add(new transaction(transTtpe.WITHDRAW,LocalDateTime.now()));
    }

    public void getTransactions() {
        System.out.println(transactions);
    }
}
