package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Student type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Students")
public final class Student implements Model {
  public static final QueryField ID = field("Student", "id");
  public static final QueryField STUDENTNAME = field("Student", "studentname");
  public static final QueryField SCHOOLYEAR = field("Student", "schoolyear");
  public static final QueryField STUDENT_MAJOR = field("Student", "studentStudentMajorId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String studentname;
  private final @ModelField(targetType="Int") Integer schoolyear;
  private final @ModelField(targetType="Major") @BelongsTo(targetName = "studentStudentMajorId", type = Major.class) Major studentMajor;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getStudentname() {
      return studentname;
  }
  
  public Integer getSchoolyear() {
      return schoolyear;
  }
  
  public Major getStudentMajor() {
      return studentMajor;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Student(String id, String studentname, Integer schoolyear, Major studentMajor) {
    this.id = id;
    this.studentname = studentname;
    this.schoolyear = schoolyear;
    this.studentMajor = studentMajor;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Student student = (Student) obj;
      return ObjectsCompat.equals(getId(), student.getId()) &&
              ObjectsCompat.equals(getStudentname(), student.getStudentname()) &&
              ObjectsCompat.equals(getSchoolyear(), student.getSchoolyear()) &&
              ObjectsCompat.equals(getStudentMajor(), student.getStudentMajor()) &&
              ObjectsCompat.equals(getCreatedAt(), student.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), student.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getStudentname())
      .append(getSchoolyear())
      .append(getStudentMajor())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Student {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("studentname=" + String.valueOf(getStudentname()) + ", ")
      .append("schoolyear=" + String.valueOf(getSchoolyear()) + ", ")
      .append("studentMajor=" + String.valueOf(getStudentMajor()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static StudentnameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Student justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Student(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      studentname,
      schoolyear,
      studentMajor);
  }
  public interface StudentnameStep {
    BuildStep studentname(String studentname);
  }
  

  public interface BuildStep {
    Student build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep schoolyear(Integer schoolyear);
    BuildStep studentMajor(Major studentMajor);
  }
  

  public static class Builder implements StudentnameStep, BuildStep {
    private String id;
    private String studentname;
    private Integer schoolyear;
    private Major studentMajor;
    @Override
     public Student build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Student(
          id,
          studentname,
          schoolyear,
          studentMajor);
    }
    
    @Override
     public BuildStep studentname(String studentname) {
        Objects.requireNonNull(studentname);
        this.studentname = studentname;
        return this;
    }
    
    @Override
     public BuildStep schoolyear(Integer schoolyear) {
        this.schoolyear = schoolyear;
        return this;
    }
    
    @Override
     public BuildStep studentMajor(Major studentMajor) {
        this.studentMajor = studentMajor;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String studentname, Integer schoolyear, Major studentMajor) {
      super.id(id);
      super.studentname(studentname)
        .schoolyear(schoolyear)
        .studentMajor(studentMajor);
    }
    
    @Override
     public CopyOfBuilder studentname(String studentname) {
      return (CopyOfBuilder) super.studentname(studentname);
    }
    
    @Override
     public CopyOfBuilder schoolyear(Integer schoolyear) {
      return (CopyOfBuilder) super.schoolyear(schoolyear);
    }
    
    @Override
     public CopyOfBuilder studentMajor(Major studentMajor) {
      return (CopyOfBuilder) super.studentMajor(studentMajor);
    }
  }
  
}
