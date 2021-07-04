package com.j4v4developers.repository;

import com.j4v4developers.db_model.entity.Account;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<Account, String> {

    @AllowFiltering
    Account getAccountByIdAndIsActive(String accountId, Boolean isActive);

}
