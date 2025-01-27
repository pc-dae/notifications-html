package mn.dae.pc.notifications.repository;

import mn.dae.pc.notifications.entity.TemplateEntity;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/** Repository class to connect to Couchbase bucket to store templates. */
@Repository
@Collection(value = "templates")
@Scope
public interface TemplateRepository extends CouchbaseRepository<TemplateEntity, UUID> {}
