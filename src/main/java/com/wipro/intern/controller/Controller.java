package com.wipro.intern.controller;

import com.wipro.intern.domain.FileInfo;
import com.wipro.intern.domain.Persons;
import com.wipro.intern.exception.ResourceNotFoundException;
import com.wipro.intern.helper.Helper;
import com.wipro.intern.service.FetchDataService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//for all -  /api/person
//for specific person  -  /api/person/{id} - should not string should be a present
@CrossOrigin(origins = "*")

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    FetchDataService fetchDataService;
    private final Path root = Paths.get("uploads");
    @GetMapping(path = "/person")
    public ResponseEntity<List<Persons>> getUsers(){
        List<Persons> user=fetchDataService.findAll();

        if(user.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(user));
    }

    @GetMapping(path="/person/{id}")
    public ResponseEntity<Persons> getUsers(@PathVariable String id){
        
        if(!Helper.onlyDigits(id))
            throw new ResourceNotFoundException("Pass the valid person id. Should contains only numeric.");
        Persons user=fetchDataService.findById(Integer.parseInt(id))
                .orElseThrow(() -> new ResourceNotFoundException("Not found Person with id = " + id));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path="/person/uploadedFiles")
    public ResponseEntity<List<FileInfo>> getUploadedFiles(){
        List<FileInfo> filesList = new ArrayList();
//        filesList.add("Test.xlsx");
//        filesList.add("Test_2.xlsx");
        if(!Files.exists(root)){
            return new ResponseEntity<>(filesList, HttpStatus.OK);
        }
        List<Path> result = null;
        try (Stream<Path> walk = Files.walk(root)) {
            result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        for(Path p : result){
            String uploadedFileName = p.getFileName().toString();
            String uploadedFilePath = p.toString();
            System.out.println(p.toString());

            FileInfo f = new FileInfo(uploadedFileName,uploadedFilePath);
            filesList.add(f);

        }

        return new ResponseEntity<>(filesList, HttpStatus.OK);
    }

//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
//        Resource file = storageService.load(filename);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }
    @PostMapping("/person/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {

        long time= System.currentTimeMillis();
        try {
            if(!Files.exists(root))
                Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
        String fileName = file.getOriginalFilename();
        String basename = FilenameUtils.getBaseName(fileName);
        String extension = FilenameUtils.getExtension(fileName);
        try {
            Files.copy(file.getInputStream(), root.resolve(basename+"_"+time+"."+extension));
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
        if (Helper.checkExcelFormat(file)) {
            //true
            fetchDataService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body("Excel File is uploaded.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }
}
