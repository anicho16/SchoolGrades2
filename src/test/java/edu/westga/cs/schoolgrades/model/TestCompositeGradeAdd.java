package edu.westga.cs.schoolgrades.model;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCompositeGradeAdd {

	private CompositeGrade composite;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	
	@BeforeEach
	public void setup() {
		composite = new CompositeGrade(mock(SumOfGradesStrategy.class));
		mockGrade0 = mock(SimpleGrade.class);
		when(mockGrade0.getValue()).thenReturn(10.00);
		mockGrade1 = mock(SimpleGrade.class);
		when(mockGrade1.getValue()).thenReturn(20.00);
		mockGrade2 = mock(SimpleGrade.class);
		when(mockGrade2.getValue()).thenReturn(30.00);
	}
	
	@Test
	public void canAddOneGrade() {
		composite.add(mockGrade0);
		List<Grade> grades = composite.getGrades();
		assertEquals(1, grades.size());
		assertEquals(mockGrade0, grades.get(0));
	}

	@Test
	public void canAddManyGrades() {
		composite.add(mockGrade0);
		composite.add(mockGrade1);
		composite.add(mockGrade2);
		List<Grade> grades = composite.getGrades();
		assertEquals(3, grades.size());
		assertEquals(mockGrade0, grades.get(0));
		assertEquals(mockGrade1, grades.get(1));
		assertEquals(mockGrade2, grades.get(2));
	}
	
	
	@Test
	public void shouldNotAddNullGrade() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			composite.add(null);
		});
	}
}
