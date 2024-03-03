package com.ecommerce.react.api.repository;

import com.ecommerce.react.api.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {


}
