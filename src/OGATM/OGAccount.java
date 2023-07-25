package OGATM;
public abstract class OGAccount {
    private int pin;

    public abstract  void deposit(String userInput);
    public abstract void withdrawal(String userInput);
    //TODO make account a Dao to connect accounts to a database, nest create pin and check pin in this class
    //TODO make integration test once account database is created


}

