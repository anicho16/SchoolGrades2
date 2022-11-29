package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class TestCompositeGradeConstructor {

	
	
	@Test
	public void shouldNotAllowNullStrategy() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new CompositeGrade(null);
		});
	}
	
	@Test
	public void shouldHaveNoGradesWhenCreated() {
		CompositeGrade grade = new CompositeGrade(mock(SumOfGradesStrategy.class));
		assertTrue(grade.getGrades().isEmpty());
	}

}
