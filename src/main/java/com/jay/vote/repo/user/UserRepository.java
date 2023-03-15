package com.jay.vote.repo.user;

import com.jay.vote.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
