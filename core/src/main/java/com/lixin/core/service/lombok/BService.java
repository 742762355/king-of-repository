package com.lixin.core.service.lombok;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BService {

    private final AService aService;

    public String say(){
        return "b";
    }

}
