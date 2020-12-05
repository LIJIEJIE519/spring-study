package com.xjj.e_05_mysql;

import org.springframework.data.repository.CrudRepository;

/**
 * @Author LJ
 * @Date 2020/11/25
 * msg
 */
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete 自动实现
public interface UserRepository extends CrudRepository<User, Integer> {

}
