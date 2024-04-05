package sh.satamahaku.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sh.satamahaku.domain.User;
import sh.satamahaku.domain.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.repository = userRepository;
    }
@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
            User curruser = repository.findByuserName(userName);

         if (curruser == null) {
            throw new UsernameNotFoundException("User not found with username" + userName);
            
         }

    UserDetails user = new org.springframework.security.core.userdetails.User(userName,
            curruser.getPasswordHash(),
            AuthorityUtils.createAuthorityList(curruser.getUserType().getUserType()));
    return user;
}
}
