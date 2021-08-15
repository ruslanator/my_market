package ru.ruslanator.corelib.interfaces;


import ru.ruslanator.corelib.models.UserInfo;

public interface ITokenService {

    String generateToken(UserInfo user);

    UserInfo parseToken(String token);
}
