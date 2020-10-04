package com.xrafece.service;

import com.xrafece.entity.Classroom;

import java.util.List;

/**
 * @author Xrafece
 */
public interface ClassroomService {
    List<Classroom> listAllClassroom();

    List<Classroom> listAvailableClassroom();

    void insertClassroom(Classroom classroom);

    void removeClassroom(Classroom classroom);

    void updateClassroomStatus(Classroom classroom);
}
