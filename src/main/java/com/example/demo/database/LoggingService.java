package com.example.demo.database;

//import com.example.demo.database.LoggingRepsitory;
//import com.example.demo.database.LoggingEntity;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class LoggingService{

    @Autowired
    private LoggingRepository logRepository;

    // Save operation
    public LoggingEntity savelog(LoggingEntity log)
    {
        return logRepository.save(log);
    }

    // Read operation
    public List<LoggingEntity> fetchlogList()
    {
        return (List<LoggingEntity>)
            logRepository.findAll();
    }

    // Update operation
    public LoggingEntity updatelog(LoggingEntity log,Long loggingId)
    {
        LoggingEntity logDB
            = logRepository.findById(loggingId)
                  .get();

        if (Objects.nonNull(log.getLoggingContent())
            && !"".equalsIgnoreCase(
                log.getLoggingContent())) {
            logDB.setLoggingContent(
                log.getLoggingContent());
        }


        return logRepository.save(logDB);
    }

    // Delete operation
    public void deletelogById(Long loggingId)
    {
        logRepository.deleteById(loggingId);
    }
}
