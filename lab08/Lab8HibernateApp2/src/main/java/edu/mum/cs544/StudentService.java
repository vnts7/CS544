package edu.mum.cs544;

import javax.persistence.EntityManager;

public class StudentService {
	private StudentDAO studentdao;

	public StudentService() {
		studentdao = new StudentDAO();
	}
	private EntityManager em() {
		return EntityManagerHelper.getCurrent();
	}

	private void txBegin() {
		em().getTransaction().begin();
	}

	private void txCommit() {
		em().getTransaction().commit();
		em().close();
	}
	public Student getStudent(long studentid) {
		txBegin();
		Student s = studentdao.load(studentid);
		txCommit();
		return s;
	}
}
