package com.javacourse.model.entities;

public class User {
        private Integer id;
        private String login;
        private String passwordHash;
        private String salt;
        private String fullName;
        private String email;
        private String company;

        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getLogin() {
            return login;
        }
        public void setLogin(String login) {
            this.login = login;
        }
        public String getPasswordHash() {
            return passwordHash;
        }
        public void setPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
        }
        public String getSalt() {
        return salt;
    }
        public void setSalt(String salt) {
        this.salt = salt;
    }
        public String getFullName() {
            return fullName;
        }
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getCompany() {
            return company;
        }
        public void setCompany(String company) {
            this.company = company;
        }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password=" + passwordHash +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
