package com.ewcode.ewallet.user.integrations;

import com.ewcode.ewallet.business.user.UserService;
import com.ewcode.ewallet.dtos.user.SaveUserDto;
import com.ewcode.ewallet.entity.User;
import com.ewcode.ewallet.utils.TestContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InsertOrUpdateTest extends TestContainer {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("should insert a user in database")
    void insertUserInDatabase() {
        SaveUserDto userDto = new SaveUserDto("Monkey D. Luffy", "luffy@mugiwara.com");

        User savedUser = userService.insertOrUpdate(userDto);

        Assertions.assertEquals(userDto.name(), savedUser.getName());
        Assertions.assertEquals(userDto.email(), savedUser.getEmail());
    }

    @Test
    @DisplayName("should update a user name in database")
    void updateUserNameInDatabase() {
        SaveUserDto userDto = new SaveUserDto("aaa D. Luffy", "luffy@mugiwara.com");
        User savedUser = userService.insertOrUpdate(userDto);

        SaveUserDto updateUserDto = new SaveUserDto("Monkey D. Rufi", "luffy@mugiwara.com");
        User updatedUser = userService.insertOrUpdate(updateUserDto);

        Assertions.assertEquals(updatedUser.getId(), savedUser.getId());

        Assertions.assertEquals(updateUserDto.name(), updatedUser.getName());

        Assertions.assertEquals(updateUserDto.email(), updatedUser.getEmail());
    }

}
