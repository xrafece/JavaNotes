package com.xrafece.controller;

import com.xrafece.entity.Classroom;
import com.xrafece.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Xrafece
 */
@RestController
@RequestMapping("classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @GetMapping
    public List<Classroom> listAllClassroom() {
        return classroomService.listAllClassroom();
    }

    @PostMapping
    public String addClassroom(@RequestBody Classroom classroom) {
        System.out.println(classroom);
        return "one";
    }
}
