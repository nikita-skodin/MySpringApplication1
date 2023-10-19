package com.skodin.util;

import com.skodin.dao.UserDAO;
import com.skodin.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserDAO userDAO;

    @Autowired
    public UserValidator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
// TODO: 030 доделать валидацию
//        if(userDAO.checkEmail(user).isPresent()){
//            errors.rejectValue(
//                    "email", "", "This email is already taken");
//        }
//
//        if (userDAO.checkUsername(user).isPresent()){
//            errors.rejectValue(
//                    "username", "", "This username is already taken");
//        }
    }
}
