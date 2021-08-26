package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateItem implements JavaDelegate {

    @Override
    public void execute(final DelegateExecution execution) {

        String sss = null;
        boolean aaa = sss.equalsIgnoreCase("mmm");

    }
}



