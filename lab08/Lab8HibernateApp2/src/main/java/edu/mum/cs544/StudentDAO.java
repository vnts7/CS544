package edu.mum.cs544;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;

public class StudentDAO {

	private EntityManager em() {
		return EntityManagerHelper.getCurrent();
	}
	public StudentDAO() {


	}

	public Student load(long studentid) {
		return em().find(Student.class, studentid);
	}
}
