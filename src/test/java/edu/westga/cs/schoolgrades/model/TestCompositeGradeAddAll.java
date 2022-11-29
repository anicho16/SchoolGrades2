package edu.westga.cs.schoolgrades.model;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCompositeGradeAddAll {

	private CompositeGrade composite;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;
	private List<Grade> list;
	
	@BeforeEach
	public void setup() {
		composite = new CompositeGrade(mock(SumOfGradesStrategy.class));
		mockGrade0 = mock(SimpleGrade.class);
		when(mockGrade0.getValue()).thenReturn(10.00);
		mockGrade1 = mock(SimpleGrade.class);
		when(mockGrade1.getValue()).thenReturn(20.00);
		mockGrade2 = mock(SimpleGrade.class);
		when(mockGrade2.getValue()).thenReturn(30.00);
		list = new ArrayList<Grade>();
	}
	

	@Test
	public void shouldNotAddNullGradesList() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			composite.addAll(null);
		});
	}
	
	@Test
	public void shouldAddEmptyList() {
		composite.addAll(new ArrayList<Grade>());
		assertTrue(composite.getGrades().isEmpty());
	}
	
	@Test
	public void shouldAddOneElementList() {
		list.add(mockGrade0);
		composite.addAll(list);
		List<Grade> actual = composite.getGrades();
		assertEquals(1, actual.size());
		assertEquals(mockGrade0, actual.get(0));
	}
	
	@Test
	public void shouldAddManyElementsList() {
		list.add(mockGrade0);
		list.add(mockGrade1);
		list.add(mockGrade2);
		composite.addAll(list);
		List<Grade> actual = composite.getGrades();
		assertEquals(3, actual.size());
		assertEquals(mockGrade0, actual.get(0));
		assertEquals(mockGrade1, actual.get(1));
		assertEquals(mockGrade2, actual.get(2));
	}
}
