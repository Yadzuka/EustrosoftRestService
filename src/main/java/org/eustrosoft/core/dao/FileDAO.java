package org.eustrosoft.core.dao;

import org.eustrosoft.core.model.FileContainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDAO extends CrudRepository<FileContainer, Long> {

}
