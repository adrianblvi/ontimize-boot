package com.ontimize.model.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontimize.api.core.service.ICandidateService;
import com.ontimize.db.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.model.core.dao.CandidateDao;
import com.ontimize.model.core.dao.CurriculumDao;
import com.ontimize.model.core.dao.EducationDao;
import com.ontimize.model.core.dao.ExperienceLevelDao;
import com.ontimize.model.core.dao.OriginDao;
import com.ontimize.model.core.dao.ProfileDao;
import com.ontimize.model.core.dao.StatusDao;

@Service("CandidateService")
@Lazy
public class CandidateService implements ICandidateService {

	@Autowired
	private CandidateDao candidateDao;
	@Autowired
	private DefaultOntimizeDaoHelper daoHelper;
	@Autowired
	private MasterService masterService;
	@Autowired
	private CurriculumDao curriculumDao;

	@Override
	public EntityResult candidateQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.candidateDao, keyMap, attrList);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)

	public EntityResult candidateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		Map<String, Object> nonCandidateData = removeNonRelatedData(attrMap, CandidateDao.ATTR_EDUCATION,
				CandidateDao.ATTR_EXPERIENCE_LEVEL, CandidateDao.ATTR_ORIGIN, CandidateDao.ATTR_PROFILE,
				CandidateDao.ATTR_STATUS);
		this.insertNonRelatedData(nonCandidateData);
		attrMap.putAll(nonCandidateData);

		return this.daoHelper.insert(this.candidateDao, attrMap);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)

	public EntityResult candidateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {

		Map<String, Object> nonCandidateData = removeNonRelatedData(attrMap, CandidateDao.ATTR_EDUCATION,
				CandidateDao.ATTR_EXPERIENCE_LEVEL, CandidateDao.ATTR_ORIGIN, CandidateDao.ATTR_PROFILE,
				CandidateDao.ATTR_STATUS);
		this.insertNonRelatedData(nonCandidateData);
		attrMap.putAll(nonCandidateData);
		return this.daoHelper.update(this.candidateDao, attrMap, keyMap);
	}

	@Override
	public EntityResult candidateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.candidateDao, keyMap);
	}

	private Map<String, Object> removeNonRelatedData(Map<String, Object> attrMap, String... attrToExclude) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		for (String attr : attrToExclude) {
			if (attrMap.containsKey(attr) && attrMap.get(attr) instanceof String) {
				data.put(attr, attrMap.remove(attr));
			}
		}
		return data;
	}

	private void insertNonRelatedData(Map<String, Object> nonCandidateData) {
		for (Entry<String, Object> entry : nonCandidateData.entrySet()) {
			Map<String, Object> data = new HashMap<String, Object>();
			List<String> attr = new ArrayList<String>();
			EntityResult toret, query;
			switch (entry.getKey()) {
			case CandidateDao.ATTR_EDUCATION:
				data.put(EducationDao.ATTR_DESCRIPTION, entry.getValue());
				attr.add(EducationDao.ATTR_ID);
				query = this.masterService.educationQuery(data, attr);
				if (query.calculateRecordNumber() > 0) {
					entry.setValue(query.getRecordValues(0).get(EducationDao.ATTR_ID));
				} else {
					toret = this.masterService.educationInsert(data);
					entry.setValue(toret.get(EducationDao.ATTR_ID));
				}
				break;
			case CandidateDao.ATTR_EXPERIENCE_LEVEL:
				data.put(ExperienceLevelDao.ATTR_DESCRIPTION, entry.getValue());
				attr.add(ExperienceLevelDao.ATTR_ID);
				query = this.masterService.experienceLevelQuery(data, attr);
				if (query.calculateRecordNumber() > 0) {
					entry.setValue(query.getRecordValues(0).get(ExperienceLevelDao.ATTR_ID));
				} else {
					toret = this.masterService.experienceLevelInsert(data);
					entry.setValue(toret.get(ExperienceLevelDao.ATTR_ID));
				}
				break;
			case CandidateDao.ATTR_ORIGIN:
				data.put(OriginDao.ATTR_DESCRIPTION, entry.getValue());
				attr.add(OriginDao.ATTR_ID);
				query = this.masterService.originQuery(data, attr);
				if (query.calculateRecordNumber() > 0) {
					entry.setValue(query.getRecordValues(0).get(OriginDao.ATTR_ID));
				} else {
					toret = this.masterService.originInsert(data);
					entry.setValue(toret.get(OriginDao.ATTR_ID));
				}
				break;
			case CandidateDao.ATTR_PROFILE:
				data.put(ProfileDao.ATTR_DESCRIPTION, entry.getValue());
				attr.add(ProfileDao.ATTR_ID);
				query = this.masterService.profileQuery(data, attr);
				if (query.calculateRecordNumber() > 0) {
					entry.setValue(query.getRecordValues(0).get(ProfileDao.ATTR_ID));
				} else {
					toret = this.masterService.profileInsert(data);
					entry.setValue(toret.get(ProfileDao.ATTR_ID));
				}
				break;
			case CandidateDao.ATTR_STATUS:
				data.put(StatusDao.ATTR_DESCRIPTION, entry.getValue());
				attr.add(StatusDao.ATTR_ID);
				query = this.masterService.statusQuery(data, attr);
				if (query.calculateRecordNumber() > 0) {
					entry.setValue(query.getRecordValues(0).get(StatusDao.ATTR_ID));
				} else {
					toret = this.masterService.statusInsert(data);
					entry.setValue(toret.get(StatusDao.ATTR_ID));
				}
				break;
			default:
				break;
			}
		}
	}

	@Override
	public EntityResult curriculumQuery(Map<String, Object> keyMap, List<String> attrList)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.query(this.curriculumDao, keyMap, attrList);
	}

	@Override
	public EntityResult curriculumInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.insert(this.curriculumDao, attrMap);
	}

	@Override
	public EntityResult curriculumUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
			throws OntimizeJEERuntimeException {
		return this.daoHelper.update(this.curriculumDao, attrMap, keyMap);
	}

	@Override
	public EntityResult curriculumDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
		return this.daoHelper.delete(this.curriculumDao, keyMap);
	}
}
