package jwt.example.userservice.service;

import jwt.example.userservice.domain.User;
import jwt.example.userservice.domain.Role;
import jwt.example.userservice.dto.UserDto;
import jwt.example.userservice.repo.RoleRepo;
import jwt.example.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //   System.out.println("user login step: " + 2);
        User user = userRepo.findByUsername(username);
        if (user == null) {
            log.error("user not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("user found in the database {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role ->
                authorities.add(new SimpleGrantedAuthority(role.getName()))
        );
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("saving new user {} to the database", user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        log.info("adding role {} to user {}", rolename, username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("fetching user {}", username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<UserDto> getUsers() {
        log.info("fetching all users");
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .build()).collect(Collectors.toList());
    }
}
