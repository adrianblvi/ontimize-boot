package com.ontimize.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("CurriculumDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/Curriculum.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CurriculumDao extends OntimizeJdbcDaoSupport {
	public static final String ATTR_ID = "ID";
	public static final String ATTR_ID_CANDIDATE = "ID_CANDIDATE";
	public static final String ATTR_EXPERIENCE = "EXPERIENCE";
	public static final String ATTR_IDIOM = "IDIOM";
	public static final String ATTR_DRIVING_LICENSE = "DRIVING_LICENSE";
	public static final String ATTR_CAR = "CAR";

}
