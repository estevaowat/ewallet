package com.ewcode.ewallet.business.user;

import com.ewcode.ewallet.dtos.user.SaveUserDto;
import com.ewcode.ewallet.entity.User;

public interface UserService {
    User insertOrUpdate(SaveUserDto userDto);
}
