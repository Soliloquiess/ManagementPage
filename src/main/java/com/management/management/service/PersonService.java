package com.management.management.service;

import com.management.management.domain.Block;
import com.management.management.domain.Person;
import com.management.management.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlocks() {
        return personRepository.findByBlockIsNull();
    }

    public List<Person> getPeopleByName(String name) {
        return personRepository.findByName(name);
    }

//    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        Person person = personRepository.findById(id).get();

        log.info("person : {}", person);

        return person;
    }
}