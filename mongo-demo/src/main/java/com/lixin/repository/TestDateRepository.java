package com.lixin.repository;

import com.lixin.domain.TestDate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lixin@tongbaninfo.com
 */
public interface TestDateRepository extends MongoRepository<TestDate,String> {
}
