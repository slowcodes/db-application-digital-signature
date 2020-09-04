package ng.com.bitsystems.digitalsignature.services;


import ng.com.bitsystems.digitalsignature.command.ResultCommand;
import ng.com.bitsystems.digitalsignature.model.Results;

public interface ResultsService extends CrudService<Results, Long> {
    ResultCommand addResultCommand(ResultCommand resultCommand);
}