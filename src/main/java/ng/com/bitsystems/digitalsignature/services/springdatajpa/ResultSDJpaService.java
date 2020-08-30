package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.converters.ResultsCommandToResults;
import ng.com.bitsystems.digitalsignature.converters.ResultsToResultsCommand;
import ng.com.bitsystems.digitalsignature.model.Results;
import ng.com.bitsystems.digitalsignature.repository.ResultsRepository;
import ng.com.bitsystems.digitalsignature.services.ResultsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class ResultSDJpaService implements ResultsService {
    private ResultsRepository resultsRepository;
    private ResultsToResultsCommand resultsToResultsCommand;
    private ResultsCommandToResults resultsCommandToResults;

    public ResultSDJpaService(ResultsRepository resultsRepository,
                              ResultsToResultsCommand resultsToResultsCommand,
                              ResultsCommandToResults resultsCommandToResults) {
        this.resultsRepository = resultsRepository;
        this.resultsToResultsCommand = resultsToResultsCommand;
        this.resultsCommandToResults = resultsCommandToResults;
    }

    @Override
    public Set<Results> findAll() {
        Set<Results> results = new HashSet<>();
        resultsRepository.findAll().forEach(results:: add);
        return results;
    }

    @Override
    public Results findByID(Long aLong) {
        return resultsRepository.findById(aLong).get();
    }

    @Override
    public Results add(Results object) {
        return resultsRepository.save(object);
    }

    @Override
    public void delete(Results object) {
        resultsRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        resultsRepository.deleteById(aLong);
    }

    @Override
    @Transactional
    public ResultCommand addResultCommand(ResultCommand resultCommand) {
        Results results = resultsCommandToResults.convert(resultCommand);
        Results detached = add(results);
        return resultsToResultsCommand.convert(detached);
    }
}
