package com.hansen.auditlog.srvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hansen.auditlog.dao.AuditlogDao;
import com.hansen.auditlog.model.Auditlog;

@Service
public class AuditlogService {

	@Autowired
	AuditlogDao auditlogDao;

	public Object create(Auditlog entity) {
//   	Optional<Auditlog> person = auditlogDao.findById(entity.getId());
//		if (person.isPresent()) {
//			return null;
//		} else {
			Auditlog Auditlog = auditlogDao.save(entity);
			return Auditlog;
//		}
	}

	public Object read(Long id) {
		Optional<Auditlog> person = auditlogDao.findById(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}

	}

	public Iterable<Auditlog> readAll() {
		Iterable<Auditlog> AuditlogList = auditlogDao.findAll();
		return AuditlogList;
	}

	public Object update(Auditlog tobemerged) {

		// Homework... write the code to upgrade
		Optional<Auditlog> person = auditlogDao.findById(tobemerged.getId());

		if (person.isPresent() && tobemerged.getModificationDate() != null && tobemerged.getOperationType() != null
				&& tobemerged.getEntityJson() != null && tobemerged.getId() != 0) {
			Auditlog Auditlog = auditlogDao.save(tobemerged);
			return Auditlog;
		} else {
			return null;
		}
	}

	public boolean delete(Long planid) {
		// Homework... write the code to delete
		Optional<Auditlog> person = auditlogDao.findById(planid);
		System.out.println(
				"hiiiiiiiiiiiii, I am the stupidest person to add this sysout in mobileplan project which got copied here to new project by another stupid: "
						+ person);
		if (person.isPresent()) {
			auditlogDao.deleteById(planid);
			return true;
		}
		return false;
	}
}
