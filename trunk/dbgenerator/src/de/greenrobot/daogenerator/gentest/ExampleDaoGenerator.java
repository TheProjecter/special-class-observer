/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Michael Tiede (modifications of the original ExampleDaoGenerator class of Markus Junginger)
 */
public class ExampleDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(3, "edu.uwp.cs.android.sco.entities");
        schema.enableKeepSectionsByDefault();

        addStudentDisabilty(schema);

        new DaoGenerator().generateAll(schema, "output");
    }
    
    private static void addStudentDisabilty(Schema schema) {
    	// generate student entity and DAO
    	Entity student = schema.addEntity("Student");
        student.addIdProperty();
        student.addStringProperty("fName").notNull();
        student.addStringProperty("lName").notNull();
        student.addStringProperty("note");
        student.addDateProperty("lastModified").notNull();
        student.addIntProperty("disabilityLevel");

        // generate disabilty entity and DAO
        Entity disability = schema.addEntity("Disability");
        disability.addIdProperty();
        disability.addStringProperty("name").notNull();
        disability.addStringProperty("info");
        disability.addIntProperty("rating");
        disability.addStringProperty("category").notNull();

        // set properties and relationships between Student and Disability
        Property studentId = disability.addLongProperty("studentId").notNull().getProperty();
        //disability.addToOne(student, studentId); // removed
        ToMany studentToDisability = student.addToMany(disability, studentId);
        studentToDisability.setName("disabilities");
        
        // generate course entity and DAO
        Entity course = schema.addEntity("Course");
        course.addIdProperty();
        course.addStringProperty("name").notNull();
        course.addStringProperty("category").notNull();
        course.addStringProperty("semester").notNull();
        course.addIntProperty("year").notNull();
        
        // generate relCourseStudent entity
        Entity relCourseStudent = schema.addEntity("RelationCourseStudent");
        relCourseStudent.addIdProperty(); // for deleting relation over primary key
        
        // relation between Course and Student will be set manually, not generated by the framework
        Property relStudentId = relCourseStudent.addLongProperty("studentId").notNull().getProperty();
        ToMany studentToRelCourseStudent = course.addToMany(relCourseStudent, relStudentId);
        studentToRelCourseStudent.setName("students");      
        Property relCourseId = relCourseStudent.addLongProperty("courseId").notNull().getProperty();
        ToMany courseToRelCourseStudent = student.addToMany(relCourseStudent, relCourseId);
        courseToRelCourseStudent.setName("courses");
    }

}
