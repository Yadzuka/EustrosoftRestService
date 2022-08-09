package org.eustrosoft.dto;

public class DataBaseDTO {
    private String url;
    private String user;
    private String password;
    private String query;

    public DataBaseDTO() {

    }

    public DataBaseDTO(String url, String user, String password, String query) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
