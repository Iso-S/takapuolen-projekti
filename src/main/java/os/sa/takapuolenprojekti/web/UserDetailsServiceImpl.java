package os.sa.takapuolenprojekti.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import os.sa.takapuolenprojekti.domain.Users;
import os.sa.takapuolenprojekti.domain.UsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository repository;

    public UserDetailsServiceImpl(UsersRepository userRepository) {
        this.repository = userRepository;
    } 

    @Override
    public UserDetails loadUserByUsername(String username) throws
    UsernameNotFoundException {
        Users curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,
        curruser.getPasswordHash(),
            AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }    
}
