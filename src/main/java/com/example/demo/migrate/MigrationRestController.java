package com.example.demo.migrate;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MigrationRestController {
  private final MigrateService migrateService;

  @PostMapping(value="/migrate/fromId/{fromId}/toId/{toId}")
  public void migrate(@PathVariable final String fromId, @PathVariable final String toId){
    migrateService.migrate(fromId, toId);
  }

}
