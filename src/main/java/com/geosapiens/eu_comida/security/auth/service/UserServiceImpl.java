package com.geosapiens.eu_comida.security.auth.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.tuple.entity.VersionProperty;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.geosapiens.eu_comida.security.auth.Login;


@Service	
public class UserServiceImpl implements UserService {

	private static Properties users = null;
	
	@Override
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
            	String userPass = getUsers().getProperty(username);
            	if(StringUtils.hasText(userPass)) 
            		return new Login(username, userPass);
            		
                throw new UsernameNotFoundException("User not found");
            }
        };
	}
	
    private static Properties getUsers() {
        if (users == null) {
            InputStream is = null;
            try {
                users = new Properties();
                is = VersionProperty.class.getClassLoader().getResourceAsStream("users.properties");
                users.load(is);

            } catch (Exception ex) {
                ex.printStackTrace();

            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return users;
    }

}
