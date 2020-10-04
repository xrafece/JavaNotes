package com.xrafece.mapper;

import com.xrafece.entity.Classroom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Xrafece
 */
@SpringBootTest
class ClassroomMapperTest {

    @Autowired
    private ClassroomMapper classroomMapper;

    @Test
    void testListAllClassroom() {
        for (Classroom classroom : classroomMapper.listAllClassroom()) {
            System.out.println(classroom);
        }
    }

    @Test
    void listAvailableClassroom() {
        for (Classroom classroom : classroomMapper.listAvailableClassroom()) {
            System.out.println(classroom);
        }
    }

    @Test
    void insertClassroom() {
        Classroom classroom = new Classroom("sss", 1);
        try {
            classroomMapper.insertClassroom(classroom);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void removeClassroom() {
        Classroom classroom = new Classroom("sss", 1);
        classroom.setId(5);
        classroomMapper.removeClassroom(classroom);
    }

    @Test
    void updateClassroomStatus() {
        classroomMapper.updateClassroomStatus(new Classroom(5, "sss", 3));
    }
}