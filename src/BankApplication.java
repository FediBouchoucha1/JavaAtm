import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BankApplication {

    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User("fedi",100.0,12345678,1234));
        users.add(new User("test",100.0,12345678,0123));
    }


    public BankApplication() {

    }

    public static void run()
    {

        System.out.println("Welcome to the ATM-BANK");
        while(true)
        {
            Scanner scanner=new Scanner(System.in);

            System.out.println("Enter your userName");
            String name= scanner.next();
            System.out.println("Enter your PinCode");
            int pin= scanner.nextInt();

            /*List<User> custommer =users.stream().filter(user -> user.getName()==name && user.getPinCode()==pin).collect(Collectors.toList());*/

            boolean Found=false;
            User c=null;
            for(User user : users)
            {

                if(user.getName().equals(name) && user.getPinCode()==pin)
                {
                    Found=true;
                    c=user;
                    break;
                }
            }

            if(Found==false){
                System.out.println("enter a valid userName and Passowrd PlEASE!!");
            }else{
                System.out.println("LOGIN IS SUCCESSFUL");
                userview(c);
            }


        }
    }

    private static void userview(User custommer)
    {
        int x=1;
        while (x!=0)
        {

            System.out.println("Choose One:");
            System.out.println("  1.check Balance");
            System.out.println("  2.Withdraw");
            System.out.println("  3.Deposit");
            System.out.println("  4.Transactions");
            System.out.println("  5.logOut");

            Scanner scanner=new Scanner(System.in);
            int number=scanner.nextInt();
            switch (number)
            {
                case 1:
                    System.out.println(custommer.getBalance());
                    break;
                case 2 :
                    System.out.println("How much you want to withdraw");
                    int amount=scanner.nextInt();
                    custommer.withdraw(amount);
                    break;
                case 3:
                    System.out.println("How much you want to deposit");
                    amount=scanner.nextInt();
                    custommer.deposit(amount);
                    break;
                case 4:
                    custommer.getTransactions();
                    break;
                case 5:
                    x=0;
                    break;
            }
        }

    }
}
