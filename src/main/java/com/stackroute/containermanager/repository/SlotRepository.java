package com.stackroute.containermanager.repository;

import com.stackroute.containermanager.domain.SlotEvaluation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface SlotRepository extends MongoRepository<SlotEvaluation, Date>
{
    //public SlotEvaluation findByDate(Date date);
}
