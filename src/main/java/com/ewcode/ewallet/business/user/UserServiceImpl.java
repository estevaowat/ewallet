package com.ewcode.ewallet.business.user;

import com.ewcode.ewallet.dtos.user.SaveUserDto;
import com.ewcode.ewallet.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User insertOrUpdate(SaveUserDto userDto) {
        Optional<User> user = repository.findByEmail(userDto.email());
         
        if(user.isPresent()) {

            User userToUpdate = user.get();
            userToUpdate.setName(userDto.name());
            return userToUpdate;
        }

        User userToInsert = new User(userDto.name(), userDto.email());
        return repository.save(userToInsert);
    }
}
