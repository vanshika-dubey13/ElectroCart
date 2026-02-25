package com.electronic.store.services.impl;

import com.electronic.store.dtos.UserDto;
import com.electronic.store.entities.User;
import com.electronic.store.exceptions.ResourceNotFoundException;
import com.electronic.store.repositories.UserRepository;
import com.electronic.store.services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // CREATE USER
    @Override
    public UserDto createUser(UserDto userDto) {
        // Generate unique ID
        userDto.setUserId(UUID.randomUUID().toString());
        // Encode password
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        // Save user
        User user = mapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        return mapper.map(savedUser, UserDto.class);
    }

    // UPDATE USER
    @Override
    public UserDto updateUser(UserDto userDto, String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given ID!"));
        
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setGender(userDto.getGender());

        if (!userDto.getPassword().equalsIgnoreCase(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        User updatedUser = userRepository.save(user);
        return mapper.map(updatedUser, UserDto.class);
    }

    // DELETE USER
    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given ID!"));
        userRepository.delete(user);
    }

    // GET SINGLE USER
    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given ID!"));
        return mapper.map(user, UserDto.class);
    }

    // GET USER BY EMAIL
    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email!"));
        return mapper.map(user, UserDto.class);
    }

    // SEARCH USERS BY NAME
    @Override
    public List<UserDto> searchUser(String keyword) {
        List<User> users = userRepository.findByNameContaining(keyword);
        return users.stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    // GET ALL USERS
    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

	// Return an Optional<User> by email
	@Override
	public Optional<User> findUserByEmailOptional(String email) {
	    return userRepository.findByEmail(email);
	}

	// Return all users as a List<UserDto>
	@Override
	public List<UserDto> getAllUsers() {
	    List<User> users = userRepository.findAll();
	    return users.stream()
	            .map(user -> mapper.map(user, UserDto.class))
	            .collect(Collectors.toList());
	}
}