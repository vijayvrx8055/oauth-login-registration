package com.vrx.oauth.service.impl;

import com.vrx.oauth.dto.UserRegistrationDto;
import com.vrx.oauth.model.Role;
import com.vrx.oauth.model.User;
import com.vrx.oauth.repository.RoleRepository;
import com.vrx.oauth.repository.UserRepository;
import com.vrx.oauth.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public User registerUser(UserRegistrationDto userRegistrationDto) {
        Role role = roleRepository.findByRole("USER");
        User user = new User();
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(encoder.encode(userRegistrationDto.getPassword()));
        user.setRoles(role);
        return userRepository.save(user);

    }

}
