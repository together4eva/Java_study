package com.example.studySpringboot0001.temp.entity.account;

import com.example.studySpringboot0001.temp.entity.account.abstact.Account;
import com.example.studySpringboot0001.temp.entity.account.interfaceModule.Search;

//mission : interface Search를 상속받은 메서드를 구현하시오
//mission : 회원가입 @Controller를 아래 AccountImple로 바꾸어서 정상적으로 실행되는지 확인하시오

public class AccountImpl extends Account implements Search {


    public AccountImpl(String id, String pw, String email, String name, Integer coin) {
        super(id, pw, email, name, coin);
    }

    /**
     * @param id : String
     * @return 인스턴스의 id와 비교하여 true/false 반환
     */
    @Override
    public boolean searchId(String id) {
        return super.getId().equals(id);
    }

    /**
     * @param email : String
     * @return 인스턴스의 email과 비교하여 ture/false 반환
     */
    @Override
    public boolean searchEmail(String email) {
        return super.getEmail().equals(email);
    }

    /**
     * @param pw : String
     * @return 인스턴스의 pw와 비교하여 true/false 반환
     */
    @Override
    public boolean searchPw(String pw) {
        return super.getPw().equals(pw);
    }


}
