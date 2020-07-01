import model.Person;
import model.Transaction;
import repositories.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

public class CSVReportService {

    private final PersonsService personsService;
    private final TransactionRepository transactionRepository;

    public CSVReportService(PersonsService personsService, TransactionRepository transactionRepository) {
        this.personsService = personsService;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Retrieve the average consumption (transaction amount) per @{@link model.Person}'s distinct roles during the last month
     *
     * Note that roles are just tags that each person is assigned. ie 'student', 'gamer', 'athlete', 'parent'
     * a Person may have multiple roles or none.
     *
     * @return data in csv file format,
     *         where the first line depict the roles
     *         and the second line the average consumption per role
     * ie: (formatted example -- the actual output should be just comma separated)
     * |student, gamer, parent|
     * |10.50  , 20.10, 0     |
     */
    public String getAverageConsumptionPerRoleDuringTheLastMonth() {
        throw new UnsupportedOperationException();
    }

    public List<Allinfo> tranNew(List<Transaction> allTransactions) {

List<Allinfo> ListOfPersonsTransactions= allTransactions.stream()
        .map(t-> new Allinfo(t,personsService.getPersonByEmailAddress(t.getEmailAddress())))
        .filter(a->a.getPerson().isPresent())
        .filter(t -> t.transaction.getDate().isAfter(LocalDateTime.now().minusDays(30)))
        .collect(Collectors.toList());



return ListOfPersonsTransactions;
    }

}


