package com.example.studySpringboot0001.temp.entity.account.interfaceModule;

public interface Search {
    /**
     * @param id : String
     * @return 인스턴스의 id와 비교하여 true/false 반환
     */
    public boolean searchId(String id);

    /**
     * @param email : String
     * @return 인스턴스의 email과 비교하여 ture/false 반환
     */
    public boolean searchEmail(String email);

    /**
     * @param pw : String
     * @return 인스턴스의 pw와 비교하여 true/false 반환
     */
    public boolean searchPw(String pw);
}
