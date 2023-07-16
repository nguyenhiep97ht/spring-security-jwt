package jwt.example.userservice.service;

import jwt.example.userservice.domain.User;
import jwt.example.userservice.domain.Role;
import jwt.example.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
  User saveUser(User user);
  Role saveRole(Role role);

  void addRoleToUser(String username, String rolename);
  User getUser(String username);
  List<UserDto> getUsers();
}
