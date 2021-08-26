package com.example.demo.migrate;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class MigrateService {
  private final RuntimeService runtimeService;

  public MigrateService(final RuntimeService runtimeService) {
    this.runtimeService = runtimeService;
  }

  public void migrate(final String sourceDefinitionId, final String targetDefinitionId) {
      log.info("migration is to be done from {} to {}", sourceDefinitionId, targetDefinitionId);
      final var migrationPlan = runtimeService.createMigrationPlan(sourceDefinitionId, targetDefinitionId).mapEqualActivities().build();
      final var processQuery = runtimeService.createProcessInstanceQuery().processDefinitionId(sourceDefinitionId);
      runtimeService.newMigration(migrationPlan)
        .processInstanceQuery(processQuery)
        .executeAsync();
      log.info("moving process done from {} to {}", sourceDefinitionId, targetDefinitionId);

  }
}
