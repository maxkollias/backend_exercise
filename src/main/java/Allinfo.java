import model.Person;
import model.Transaction;
import java.util.Optional;

public class Allinfo {


    Transaction transaction;
    Optional<Person> person;


    public Allinfo(Transaction transaction, Optional<Person> person){
        setTransaction(transaction);
        setPerson(person);
    }



    public void setPerson(Optional<Person> person) {
        this.person = person;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Optional<Person> getPerson() {
        return person;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
