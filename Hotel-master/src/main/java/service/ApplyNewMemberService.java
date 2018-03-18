package service;


public interface ApplyNewMemberService {

    int applyNewMember(String name, String icard, String phone,
                        String bank_Num, String bank_password, String isMember,
                        String password1, String password2);
}
