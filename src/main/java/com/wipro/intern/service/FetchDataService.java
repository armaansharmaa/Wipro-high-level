package com.wipro.intern.service;

import com.wipro.intern.domain.Persons;
import com.wipro.intern.helper.Helper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository
public interface FetchDataService extends JpaRepository<Persons, Integer> {

    @Override
    List<Persons> findAll();

    @Override
    Optional<Persons> findById(Integer id);

    public default void save(MultipartFile file) {

        try {
            List<Persons> persons = Helper.convertExcelToListOfProduct(file.getInputStream());
            this.saveAll(persons);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
