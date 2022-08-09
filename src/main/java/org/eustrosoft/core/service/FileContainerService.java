package org.eustrosoft.core.service;

import org.eustrosoft.core.dao.FileDAO;
import org.eustrosoft.core.model.FileContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
@RequestScope
public class FileContainerService {
    @Autowired
    private FileDAO fileDAO;
    @Autowired
    private EntityManager entityManager;

    public List<FileContainer> getAllFiles() {
        List<FileContainer> fileList = new ArrayList<>();
        Iterable<FileContainer> files = fileDAO.findAll();
        files.forEach(fileList::add);
        return fileList;
    }

    public FileContainer getById(Long id) {
        return fileDAO.findById(id).orElse(null);
    }

    public byte[] getFileByFileId(long fileId) {
        return (byte[]) entityManager.createNativeQuery(
                "SELECT lo_get(:file_id)"
        ).setParameter("file_id", fileId)
                .getSingleResult();
    }
}
