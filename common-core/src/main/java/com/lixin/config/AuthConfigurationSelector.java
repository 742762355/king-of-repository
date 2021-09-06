package com.lixin.config;

import com.lixin.annotation.EnableAuthorization;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class AuthConfigurationSelector extends AdviceModeImportSelector<EnableAuthorization> {

    @Override
    @Nullable
    protected String[] selectImports(@NonNull AdviceMode adviceMode) {
        //todo  根据代理模式做事,现阶段不需要
        switch (adviceMode){
            case PROXY:
                System.out.println(1);
            case ASPECTJ:
        }
        return new String[]{AuthAutoConfiguration.class.getName()};
    }
}
