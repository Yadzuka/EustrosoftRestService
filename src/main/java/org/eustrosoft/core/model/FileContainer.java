package org.eustrosoft.core.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "files", schema = "tis")
public class FileContainer implements DBFile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "file_id")
    private Long fileId;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_size")
    private Long fileSize;
    @Column(name = "file_extension")
    private String fileExtension;
    @Column(name = "file_last_modified")
    private Date fileLastModified;
    @Column(name = "file_uploaded_date")
    private Date fileUploadedDate;
    @Column(name = "file_download_count")
    private Long fileDownloadCount;
    @Column(name = "file_uploaded_by")
    private String fileUploadedBy;
    @Column(name = "file_version")
    private Long fileVersion;
    @Column(name = "file_previous_version")
    private Long filePreviousVersion;
    @Column(name = "file_next_version")
    private Long fileNextVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Date getFileLastModified() {
        return fileLastModified;
    }

    public void setFileLastModified(Date fileLastModified) {
        this.fileLastModified = fileLastModified;
    }

    public Date getFileUploadedDate() {
        return fileUploadedDate;
    }

    public void setFileUploadedDate(Date fileUploadedDate) {
        this.fileUploadedDate = fileUploadedDate;
    }

    public Long getFileDownloadCount() {
        return fileDownloadCount;
    }

    public void setFileDownloadCount(Long fileDownloadCount) {
        this.fileDownloadCount = fileDownloadCount;
    }

    public String getFileUploadedBy() {
        return fileUploadedBy;
    }

    public void setFileUploadedBy(String fileUploadedBy) {
        this.fileUploadedBy = fileUploadedBy;
    }

    public Long getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(Long fileVersion) {
        this.fileVersion = fileVersion;
    }

    public Long getFilePreviousVersion() {
        return filePreviousVersion;
    }

    public void setFilePreviousVersion(Long filePreviousVersion) {
        this.filePreviousVersion = filePreviousVersion;
    }

    public Long getFileNextVersion() {
        return fileNextVersion;
    }

    public void setFileNextVersion(Long fileNextVersion) {
        this.fileNextVersion = fileNextVersion;
    }
}
