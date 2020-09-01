package ng.com.bitsystems.digitalsignature.services.springdatajpa;

import ng.com.bitsystems.digitalsignature.command.SessionCommand;
import ng.com.bitsystems.digitalsignature.converters.SessionCommandToSession;
import ng.com.bitsystems.digitalsignature.converters.SessionToSessionCommand;
import ng.com.bitsystems.digitalsignature.model.Sessions;
import ng.com.bitsystems.digitalsignature.repository.SessionsRepository;
import ng.com.bitsystems.digitalsignature.services.SessionService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SessionSDJpaService implements SessionService {
    private SessionsRepository sessionsRepository;
    private SessionToSessionCommand sessionToSessionCommand;
    private SessionCommandToSession sessionCommandToSession;

    public SessionSDJpaService(SessionsRepository sessionsRepository, SessionToSessionCommand sessionToSessionCommand, SessionCommandToSession sessionCommandToSession) {
        this.sessionsRepository = sessionsRepository;
        this.sessionToSessionCommand = sessionToSessionCommand;
        this.sessionCommandToSession = sessionCommandToSession;
    }

    @Override
    public Set<Sessions> findAll() {
        Set<Sessions> sessions = new HashSet<>();
        sessionsRepository.findAll().forEach(sessions::add);
        return sessions;
    }

    @Override
    public Sessions findByID(Long aLong) {
        return sessionsRepository.findById(aLong).get();
    }

    @Override
    public Sessions add(Sessions object) {
        return sessionsRepository.save(object);
    }

    @Override
    public void delete(Sessions object) {
        sessionsRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        sessionsRepository.deleteById(aLong);
    }

    @Override
    public SessionCommand getSessionCommandById(Long id) {
        return sessionToSessionCommand.convert(findByID(id));
    }
}
