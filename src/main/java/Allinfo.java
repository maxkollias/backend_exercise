import model.Person;
import model.Transaction;

import java.util.List;
import java.util.Optional;

public class Allinfo {


    Transaction transaction;
    Optional<Person> person;

    String email;
    long value;
    Optional<String> roles;
    List<String> rolesL;





    public Allinfo(Transaction transaction, Optional<Person> person){
        setTransaction(transaction);
        setPerson(person);
    }
    public Allinfo(String email, Long value, Optional <String> roles){
        this.email=email;
        this.value=value;
        this.roles=roles;
    }

    public Allinfo(long value, List <String> roles){
        this.value=value;
        this.rolesL=roles;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public  void  setValue(Long value){
        this.value=value;
    }
    public  long  getValue(){
        return this.value;
    }
    public List getRolesL(){return rolesL;}

    public  void  setRoles(Optional<String> roles){
        this.roles=roles;
    }
    public  void  setRoles(List<String> roles){
        this.rolesL=roles;
    }


    public  Optional<String> getRoles(){
        return roles;
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
