package ca.jrvs.apps.trading.model.domain;

import javax.persistence.Id;

public interface Entity<ID> {
    ID getId();
    void setId(Id id);
}
