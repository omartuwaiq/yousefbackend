package com.example.FoodDelivery.model.repository;

import com.example.FoodDelivery.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {



@Query("SELECT password FROM User WHERE username = :username" )
    String findPasswordByUsername(@Param("username") String username);

@Query("select case when count(username) > 0 then true else false end from User where username = :username")
    Boolean existsByUsername(@Param("username") String username);


//    @Query ("SELECT password FROM User WHERE password = :password")
//   String findByPassword(@Param("Password") String password);
//    @Query("SLECT username FROM user WHERE username =:username ")
//    String findByUsername(@Param("username")String username);
//
//    boolean existsByUsername(@Param("name") String name);
}


