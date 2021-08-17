package com.lixin.core.service.lombok;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AService {

//    private final BService bService;

    public String say(){
        return "a";
    }
}
