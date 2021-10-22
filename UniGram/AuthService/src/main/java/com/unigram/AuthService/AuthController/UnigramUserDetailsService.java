package com.unigram.AuthService.AuthController;

@Service
public class UnigramUserDetailService implements UserDetailsService {

    private UserService userService;

    public InstaUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userService
                .findByUsername(username)
                .map(InstaUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}