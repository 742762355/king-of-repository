package com.lixin.service;

import com.lixin.domain.TestDate;
import com.lixin.repository.TestDateRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lixin@tongbaninfo.com
 */
@Service
public class TestDateService {

    private final TestDateRepository repository;

    @Autowired
    public TestDateService(TestDateRepository repository) {
        this.repository = repository;
        findOne();
    }

    public TestDate findOne() {
        List<TestDate> all = repository.findAll();
        return all.isEmpty() ? null : all.get(0);
    }
}
