package com.example.TodoList.Services;
import com.example.TodoList.Entity.SignUpEntity;
import com.example.TodoList.Repository.SignUpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpServices {
    private final SignUpRepository SignUprepo;

    public SignUpServices(SignUpRepository signUprepo) {
        SignUprepo = signUprepo;
    }
    public SignUpEntity savesignpdata(SignUpEntity signupentity){

        return SignUprepo.save(signupentity);
    }
    public boolean emailExists(String email){
        return SignUprepo.findByEmail(email).isPresent();
    }
    public List<SignUpEntity> showsignupdata(){
        return SignUprepo.findAll();
    }
public boolean validateLogin(String email, String password) {
    SignUpEntity user = SignUprepo.findByEmail(email).orElse(null);
    if (user != null) {
        return user.getPassword().equals(password);
    }
    return false;
}
}
