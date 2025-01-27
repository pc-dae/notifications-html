package mn.dae.pc.notifications.repository.impl;

import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.json.JsonArray;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TemplateRepositoryImpl implements TemplateRepository {
  private final Cluster couchbaseCluster;

  /**
   * Returns a single application json
   *
   * @param tenantId tenant Id
   * @param templateId template UUID
   * @return optional json document
   */
  @Override
  public Optional<JsonObject> lookupTemplateInTenant(String tenantId, String templateId) {
    try {
      String query =
          "select templates from `notification`.`test`.`templates` where tenantId = $1 and templateId = $2";

      // Execute the query
      QueryResult result =
          couchbaseCluster.query(
              query, QueryOptions.queryOptions().parameters(tenantId).parmeters(templateId));

      return result.rowsAsObject().stream().findFirst();
    } catch (Exception e) {
      log.error("Failed to look up template id {} for tenant {}", templateId, tenantId);
      throw e;
    }
  }
}
