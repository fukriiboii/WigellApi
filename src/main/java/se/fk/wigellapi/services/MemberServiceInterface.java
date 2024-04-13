package se.fk.wigellapi.services;

import se.fk.wigellapi.models.Member;

import java.util.List;

public interface MemberServiceInterface  {
    //Methods for CRUD operations

    //Get all
    List<Member> getAllMembers();

    //Hämta medlem med specefik id
    Member getMemberById(Long id);

    //add new
    Member addNewMember(Member member);

    //Update
    Member updateMember(Long id, Member member);

    //Delete
    void deleteMember(Long id);
}
