package University.UniversitySources.service.Test;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.firebase.database.DatabaseReference;

import University.UniversitySources.Entity.instructorEntity;
import University.UniversitySources.service.InstructorService;

@SpringBootTest
public class InstructorServiceTest {

    @Mock
    private DatabaseReference mockDatabaseReference;

    @InjectMocks
    private InstructorService InstructorService;

    @Test
    public void addInstructorTest() {
        // Arrange
        instructorEntity instructor = new instructorEntity(
            "John Doe",
            "JohnDoe123@gmail.com",
            "123456",
            "Computer Science"
        );

        when(mockDatabaseReference.child("instructor123")).thenReturn(mockDatabaseReference);

        // Act
        instructorService.saveInstructor("instructor123", instructor);

        // Assert
        verify(mockDatabaseReference.child("instructor123")).setValueAsync(instructor);
    }
}