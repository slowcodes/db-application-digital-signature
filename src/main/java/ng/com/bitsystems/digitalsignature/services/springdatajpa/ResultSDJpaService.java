package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.converters.ResultsCommandToResults;
import ng.com.bitsystems.digitalsignature.converters.ResultsToResultsCommand;
import ng.com.bitsystems.digitalsignature.model.PrivateKeys;
import ng.com.bitsystems.digitalsignature.model.Results;
import ng.com.bitsystems.digitalsignature.repository.ResultsRepository;
import ng.com.bitsystems.digitalsignature.services.ResultsService;
import ng.com.bitsystems.digitalsignature.services.UploadService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class ResultSDJpaService implements ResultsService {
    private ResultsRepository resultsRepository;
    private ResultsToResultsCommand resultsToResultsCommand;
    private ResultsCommandToResults resultsCommandToResults;
    private AES encryption;
    private UploadService uploadService;

    public ResultSDJpaService(ResultsRepository resultsRepository, UploadService uploadService,
                              AES encryption,
                              ResultsToResultsCommand resultsToResultsCommand,
                              ResultsCommandToResults resultsCommandToResults) {
        this.resultsRepository = resultsRepository;
        this.encryption = encryption;
        this.resultsToResultsCommand = resultsToResultsCommand;
        this.resultsCommandToResults = resultsCommandToResults;
        this.uploadService = uploadService;
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


        if(results.getUpload().getId() !=1 ){

            PrivateKeys signingKey = uploadService.findByID(results.getUpload().getId()).getPrivateKeys();

            String exam = encryption.encrypt(String.valueOf(results.getExamScore()), signingKey.getPrivateKey()); //+signingKey.getPublicKeys().getPublickey()
            String test = encryption.encrypt(String.valueOf(results.getTestScore()), signingKey.getPrivateKey()); //+signingKey.getPublicKeys().getPublickey()

            results.setExamScore(exam);
            results.setTestScore(test);

        }
        Results detached = resultsRepository.save(results);
        return resultsToResultsCommand.convert(detached);
    }

    @Override
    public Set<Results> getStudentResultById(Long aLong) {
        Set<Results> results = new HashSet<>();
        Set<Results> allResults = findAll();

        for(Results result : allResults) {

            if(result.getStudent().getId() == aLong){
                results.add(result);
            }
        };
        return results;
    }
}
