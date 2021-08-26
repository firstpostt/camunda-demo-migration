package com.example.demo;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CreateItemRestController {
  private final RuntimeService runtimeService;

  @PostMapping(value="/create-item")
  public void createItem(){
    runtimeService.createMessageCorrelation("Message_StartProcess")
            .processInstanceBusinessKey(UUID.randomUUID().toString())
            .correlateStartMessage();
  }

}
