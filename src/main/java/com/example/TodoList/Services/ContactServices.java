package com.example.TodoList.Services;

import com.example.TodoList.Entity.ContactEntity;
import com.example.TodoList.Repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServices {
    private final ContactRepository contactrepo;

    public ContactServices(ContactRepository contactrepo) {
        this.contactrepo = contactrepo;
    }

    public ContactEntity savecontact(ContactEntity contectentity){
        return contactrepo.save(contectentity);
    }
    public List<ContactEntity> findallcontact(){
        return contactrepo.findAll();
    }
}
