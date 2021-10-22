@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure in-memory authentication provider for service accounts for
        // service inter-communication
        auth.inMemoryAuthentication()
        .withUser(serviceUsername)
        .password(passwordEncoder().encode(servicePassword))
        .roles(Role.SERVICE.getName());

        // Configure DB authentication provider for user accounts
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }