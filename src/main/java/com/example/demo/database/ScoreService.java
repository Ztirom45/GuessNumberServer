
package com.example.demo.database;


import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ScoreService{

    @Autowired
    private ScoreRepository scoreRepository;

    // Save operation
    public ScoreEntity savescore(ScoreEntity score)
    {
        return scoreRepository.save(score);
    }

    // Read operation
    public List<ScoreEntity> fetchscoreList()
    {
        return (List<ScoreEntity>)
            scoreRepository.findAll();
    }

    // Update operation
    public ScoreEntity updatescore(ScoreEntity score,Long scoreId)
    {
        ScoreEntity scoreDB
            = scoreRepository.findById(scoreId)
                  .get();

        if (Objects.nonNull(score.getTries())){
            scoreDB.setTries(score.getTries());
        }
        if (Objects.nonNull(score.getTime())){
            scoreDB.setTime(score.getTime());
        }


        return scoreRepository.save(scoreDB);
    }

    // Delete operation
    public void deletescoreById(Long scoreId)
    {
        scoreRepository.deleteById(scoreId);
    }
}
