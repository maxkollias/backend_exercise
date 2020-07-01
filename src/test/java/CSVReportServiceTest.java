import model.Transaction;
import model.Person;
import model.Transaction;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import repositories.TransactionRepository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.*;

public class CSVReportServiceTest {

    private final PersonsService personService = Mockito.mock(PersonsService.class);
    private final TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
    TransactionService transactionService = new TransactionService(personService, transactionRepository);

    @Test
    public void shouldGetPersonRolesForAllTransactions() {
        // given
        Person john = new Person();
        john.setRoles(Set.of("student", "gamer", "athlete"));
        john.setEmailAddress("john@test.com");

        Person jane = new Person();
        jane.setRoles(Set.of("employee", "athlete"));
        jane.setEmailAddress("jane@test.com");

        List<Person> persons = new ArrayList<>();

        persons.add(jane);
        persons.add(john);


        // and
        Mockito.stub(personService.getPersonByEmailAddress(Matchers.eq("john@test.com"))).toReturn(Optional.of(john));
        Mockito.stub(personService.getPersonByEmailAddress(Matchers.eq("jane@test.com"))).toReturn(Optional.of(jane));


        // and
        Mockito.stub(transactionRepository.getTransactions())
                .toReturn(
                        List.of(createTransaction(10, "john@test.com", LocalDateTime.now().minusDays(5)),
                                createTransaction(20, "john@test.com", LocalDateTime.now().minusDays(3)),
                                createTransaction(30, "john@test.com", LocalDateTime.now().minusDays(40)),
                                createTransaction(40, "john@test.com", LocalDateTime.now().minusDays(4)),
                                createTransaction(50, "jane@test.com", LocalDateTime.now().minusDays(20)),
                                createTransaction(50, "jane@test.com", LocalDateTime.now().minusDays(2)),
                                createTransaction(50, "jane@test.com", LocalDateTime.now().minusDays(1))
                        )
                );


       CSVReportService CSVService = new CSVReportService(personService, transactionRepository);

        List<Allinfo> newTrList= CSVService.tranNew(transactionRepository.getTransactions());
        //System.out.println(newTrList);
        for(Allinfo it : newTrList) {
            System.out.print(it.transaction.getAmount()+":"+it.person.get().getRoles());
        }




        // when
       // List<String> roles = transactionService.getPersonRolesOfAllTransactions();

        //assertEquals(4, roles.size());
        //assertTrue(roles.containsAll(List.of("student", "gamer", "athlete", "employee")));
    }

    private Transaction createTransaction(int amount, String emailAddress, LocalDateTime date) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setEmailAddress(emailAddress);
        transaction.setDate(date);
        return transaction;
    }

}
