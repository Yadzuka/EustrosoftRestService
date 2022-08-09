package org.eustrosoft.core.model;

import java.util.Date;

public interface DBFile {
    Long getFileId();

    String getFileName();

    Date getFileUploadedDate();

    Long getFileVersion();
}
